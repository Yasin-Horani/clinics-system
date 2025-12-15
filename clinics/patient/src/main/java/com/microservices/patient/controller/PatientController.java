package com.microservices.patient.controller;

import com.microservices.patient.service.PatientService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/search/{patientName}")
    public String searchPatientName(@PathVariable String patientName) {
        log.info("Searching for patient with name {} - {}", patientName, UUID.randomUUID());
        return patientService.getPatientName(patientName);
    }
}
