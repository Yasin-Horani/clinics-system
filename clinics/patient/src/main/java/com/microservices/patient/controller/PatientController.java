package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.service.PatientService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping(path = "/add-patient")
    public AddPatientDTO addPatient(@RequestBody AddPatientDTO addPatientDTO) {
        return this.patientService.addPatient(addPatientDTO);
    }

}
