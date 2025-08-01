package com.digipds.grievance_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GrievanceDTO {
    private Long grievanceId;
    private Long citizenId;
    private Integer fpsId;
    private String grievanceType;
    private String title;
    private String description;
    private String priority;
    private String status;
    private Long assignedToUserId;
    private String resolutionNotes;

}
