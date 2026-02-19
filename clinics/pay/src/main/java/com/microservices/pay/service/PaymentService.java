package com.microservices.pay.service;

import com.microservices.pay.model.dto.AddPaymentDTO;
import com.microservices.pay.model.dto.PaymentDTO;
import com.microservices.pay.model.entity.Payment;
import com.microservices.pay.model.mapper.PaymentMapper;
import com.microservices.pay.repository.PaymentRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final PaymentRepo paymentRepo;
    private final PaymentMapper paymentMapper;

    public PaymentDTO getPayment(UUID transactionId) {
        log.info("Fetching payment with transactionId: {}", transactionId);
        Payment payment = paymentRepo.findByTransactionId(transactionId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Payment not found with transactionId: " + transactionId));
        log.info("Payment found: {}", payment);
        return paymentMapper.PaymentToDTO(payment);
    }

    @Transactional
    public PaymentDTO addPayment(AddPaymentDTO addPaymentDTO) {
        Payment payment = Payment.builder()
                .transactionId(UUID.randomUUID())
                .paymentAmount(addPaymentDTO.getPaymentAmount())
                .patientId(addPaymentDTO.getPatientId())
                .paymentTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                .build();
        Payment savedPayment = this.paymentRepo.save(payment);
        log.info("Payment saved: {}", savedPayment);
        return paymentMapper.PaymentToDTO(savedPayment);
    }
}
