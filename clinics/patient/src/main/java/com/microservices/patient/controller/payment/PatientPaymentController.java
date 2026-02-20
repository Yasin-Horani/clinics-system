package com.microservices.patient.controller.payment;

import com.microservices.patient.model.dto.payment.AddPaymentDTO;
import com.microservices.patient.model.dto.payment.PaymentDTO;
import com.microservices.patient.service.patientPaymentService.PatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/patient/")
@RestController
public class PatientPaymentController {

    @Autowired
    private PatientPaymentService patientPaymentService;
    @GetMapping( "/payment/{transactionId}")
    public PaymentDTO getPayment(@PathVariable UUID transactionId) {
        return this.patientPaymentService.getPayment(transactionId);
    }

    @PostMapping(path = "/payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO) {
        return this.patientPaymentService.addPayment(addPaymentDTO);
    }

    @GetMapping("payment/patient-id/{patientId}")
    public List<PaymentDTO> getAllPaymentsByPatientId(@PathVariable Long patientId) {
        return this.patientPaymentService.getAllPaymentsByPatientId(patientId);
    }
}
