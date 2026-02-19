package com.microservices.pay.repository;

import com.microservices.pay.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

    Optional<Payment> findByTransactionId(UUID id);
}
