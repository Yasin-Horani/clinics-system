package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "PATIENT-SERVICE", url = "http://localhost:8081")
public interface PatientProxy {
    @GetMapping("/patient/get-patient/{patientId}")
    PatientDTO getPatientById(@PathVariable("patientId") Long patientId);
}

