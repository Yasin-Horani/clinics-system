package com.microservices.pay.model.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "payment")
@Entity
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @Column(name = "transaction_id")
    private UUID transactionId;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "payment_time")
    private LocalDateTime paymentTime;
}
