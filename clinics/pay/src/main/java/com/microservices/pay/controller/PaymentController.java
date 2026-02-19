package com.microservices.pay.controller;

import com.microservices.pay.model.dto.AddPaymentDTO;
import com.microservices.pay.model.dto.PaymentDTO;
import com.microservices.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/payments/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping( "/payment/{transactionId}")
    public PaymentDTO getPayment(@PathVariable UUID transactionId) {
        return this.paymentService.getPayment(transactionId);
    }

    @PostMapping(path = "/payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO) {
        return this.paymentService.addPayment(addPaymentDTO);
    }


}
