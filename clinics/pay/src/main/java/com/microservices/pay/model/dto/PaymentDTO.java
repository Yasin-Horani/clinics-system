package com.microservices.pay.model.dto;


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
    private Double amount;
    private Long patientId;
    private LocalDateTime paymentTime;
}
