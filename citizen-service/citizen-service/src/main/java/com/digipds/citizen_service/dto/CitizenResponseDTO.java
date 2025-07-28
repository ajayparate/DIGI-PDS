package com.digipds.citizen_service.dto;

import java.util.Date;

import com.digipds.citizen_service.entity.Gender;

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
public class CitizenResponseDTO {
    private Long citizenId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Gender gender;
    private String aadharNumber;
    private boolean isHeadOfFamily;

}
