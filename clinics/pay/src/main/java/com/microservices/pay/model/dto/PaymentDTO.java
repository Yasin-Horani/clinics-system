package com.microservices.pay.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long paymentId;
    private UUID transactionId;
    private Double paymentAmount;
    private Long patientId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm EEEE")
    private LocalDateTime paymentTime;
}
