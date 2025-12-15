package com.microservices.patient.controller;

import com.microservices.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/search/{patientName}")
    public String searchPatientName(@PathVariable("patientName") String patientName) {
        return this.patientService.getPatientName(patientName);
    }
}
