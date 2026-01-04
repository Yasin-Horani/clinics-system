package com.microservices.patient.controller;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.service.PatientService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/patient/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping(path = "/add-patient")
    public AddPatientDTO addPatient(@RequestBody AddPatientDTO addPatientDTO) {
        return this.patientService.addPatient(addPatientDTO);
    }

    @PutMapping(path = "/update-patient")
    public UpdatePatientDTO updatePatient(@RequestBody UpdatePatientDTO updatePatientDTO) {
        return this.patientService.updatePatient(updatePatientDTO);
    }

    @DeleteMapping(path = "/delete-patient/{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId) {
        this.patientService.deletePatient(patientId);
    }

    @GetMapping("/all-patient")
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/get-patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

}
