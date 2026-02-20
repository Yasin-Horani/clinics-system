package com.microservices.patient.service.patientPaymentService;

import com.microservices.patient.model.dto.payment.AddPaymentDTO;
import com.microservices.patient.model.dto.payment.PaymentDTO;
import com.microservices.patient.proxy.PatientPaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientPaymentService {
    
    @Autowired
    private PatientPaymentProxy patientPaymentProxy;


    public PaymentDTO getPayment(UUID transactionId) {
        return patientPaymentProxy.getPayment(transactionId);
    }

    public PaymentDTO addPayment(AddPaymentDTO addPaymentDTO) {
        return this.patientPaymentProxy.addPayment(addPaymentDTO);
    }

    public List<PaymentDTO> getAllPaymentsByPatientId(Long patientId) {
        return patientPaymentProxy.getAllPaymentsByPatientId(patientId);
    }
}
