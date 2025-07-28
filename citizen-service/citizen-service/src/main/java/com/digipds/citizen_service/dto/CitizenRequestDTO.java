package com.digipds.citizen_service.dto;

import java.util.Date;

import com.digipds.citizen_service.entity.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CitizenRequestDTO {
    @NotNull

    private Long userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private Date dateOfBirth;

    private Gender gender;

    private String addressLine1;
    private String addressLine2;

    private String city;
    private String state;

    @Pattern(regexp = "\\d{6}", message = "Pincode must be 6 digits")
    private String pincode;

    @Size(min = 12, max = 12, message = "Aadhar must be 12 digits")
    private String aadharNumber;

    private boolean isHeadOfFamily;

}
