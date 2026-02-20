package com.microservices.doctor.service;

import com.microservices.doctor.model.dto.payment.AddPaymentDTO;
import com.microservices.doctor.model.dto.payment.PaymentDTO;
import com.microservices.doctor.proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorPatientPaymentService {
    @Autowired
    private PaymentProxy paymentProxy;

    public PaymentDTO addPayment(AddPaymentDTO addPaymentDTO) {
        return paymentProxy.addPayment(addPaymentDTO);
    }

    public PaymentDTO getPayment(UUID transactionId) {
        return paymentProxy.getPayment(transactionId);
    }

}
