package com.microservices.doctor.proxy;

import com.microservices.doctor.model.dto.patient.AddPatientDTO;
import com.microservices.doctor.model.dto.patient.PatientDTO;
import com.microservices.doctor.model.dto.patient.UpdatePatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "PATIENT-SERVICE", url = "http://localhost:8081")
public interface PatientProxy {

    @PostMapping(path = "/patient/add-patient")
    AddPatientDTO addPatient(@RequestBody AddPatientDTO addPatientDTO);

    @GetMapping("/patient/get-patient/{patientId}")
    PatientDTO getPatientById(@PathVariable("patientId") Long patientId);

    @PutMapping(path = "/patient/update-patient")
    PatientDTO updatePatient(@RequestBody UpdatePatientDTO dto);

    @GetMapping("/patient/all-patient")
    List<PatientDTO> getAllPatients();

    @DeleteMapping(path = "/patient/delete-patient/{patientId}")
    void deletePatient(@PathVariable("patientId") Long patientId);
}

