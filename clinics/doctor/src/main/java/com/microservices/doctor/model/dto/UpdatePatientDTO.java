package com.microservices.doctor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePatientDTO {
    private Long patientId;
    private String patientName;
    private Integer patientAge;
}
