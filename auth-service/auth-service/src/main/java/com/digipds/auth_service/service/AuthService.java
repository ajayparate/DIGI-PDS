package com.digipds.auth_service.service;

import java.util.Collections;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.digipds.auth_service.dto.AuthResponse;
import com.digipds.auth_service.dto.LoginRequest;
import com.digipds.auth_service.dto.RegisterRequest;
import com.digipds.auth_service.entity.Role;
import com.digipds.auth_service.entity.RoleType;
import com.digipds.auth_service.entity.User;
import com.digipds.auth_service.repository.RoleRepository;
import com.digipds.auth_service.repository.UserRepository;
import com.digipds.auth_service.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email is already registered.");
        }

        Role role = roleRepository.findByName(RoleType.valueOf(request.getRole().toUpperCase()))
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(role))
                .isActive(true)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail(), request.getRole());

        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(request.getRole())
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Assuming a user has one role
        String role = user.getRoles().stream().findFirst().map(r -> r.getName().name()).orElse("UNKNOWN");

        String token = jwtService.generateToken(user.getEmail(), role);

        return AuthResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(role)
                .build();
    }

}
