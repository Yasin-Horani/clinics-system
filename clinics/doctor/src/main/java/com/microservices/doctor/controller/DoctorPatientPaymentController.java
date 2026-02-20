package com.microservices.doctor.controller;

import com.microservices.doctor.model.dto.payment.AddPaymentDTO;
import com.microservices.doctor.model.dto.payment.PaymentDTO;
import com.microservices.doctor.service.DoctorPatientPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/doctor/")
public class DoctorPatientPaymentController {

    @Autowired
    private DoctorPatientPaymentService doctorPatientPaymentService;

    @GetMapping( "/payment/{transactionId}")
    public PaymentDTO getPayment(@PathVariable UUID transactionId) {
        return this.doctorPatientPaymentService.getPayment(transactionId);
    }

    @PostMapping(path = "/payment")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO addPaymentDTO) {
        return this.doctorPatientPaymentService.addPayment(addPaymentDTO);
    }

    @GetMapping("payment/patient-id/{patientId}")
    public List<PaymentDTO> getAllPaymentsByPatientId(@PathVariable Long patientId) {
        return this.doctorPatientPaymentService.getAllPaymentsByPatientId(patientId);
    }

}
