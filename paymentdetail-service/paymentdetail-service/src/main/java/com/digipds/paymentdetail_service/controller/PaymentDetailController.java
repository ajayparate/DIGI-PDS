package com.digipds.paymentdetail_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.paymentdetail_service.dto.APIResponseDTO;
import com.digipds.paymentdetail_service.dto.PaymentDetailRequestDTO;
import com.digipds.paymentdetail_service.dto.PaymentDetailResponseDTO;
import com.digipds.paymentdetail_service.service.PaymentDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment-details")
@RequiredArgsConstructor
public class PaymentDetailController {
    
    private final PaymentDetailService service;

    @PostMapping
    public ResponseEntity<APIResponseDTO> create(@RequestBody PaymentDetailRequestDTO dto) {
        PaymentDetailResponseDTO detailResponseDTO = service.create(dto);
        return  ResponseEntity.status(HttpStatus.CREATED)
                                .body(APIResponseDTO.builder()
                                .statusCode(HttpStatus.CREATED.value())
                                .message("Paymment Details has Been Created. ")
                                .timestamp(LocalDateTime.now())
                                .data(detailResponseDTO)
                                .build()
                                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDetailResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentDetailResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDetailResponseDTO> update(@PathVariable Long id,
                                                           @RequestBody PaymentDetailRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
