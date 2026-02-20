package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.payment.AddPaymentDTO;
import com.microservices.doctor.model.dto.payment.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "PAYMENT-SERVICE", url = "http://localhost:8082")
public interface PaymentProxy {
    @GetMapping( "/payments/payment/{transactionId}")
    PaymentDTO getPayment(@PathVariable UUID transactionId);

    @PostMapping(path = "/payments/payment")
    PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO);
}
