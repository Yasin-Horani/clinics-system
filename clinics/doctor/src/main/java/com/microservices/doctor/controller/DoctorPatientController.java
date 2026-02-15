package com.microservices.doctor.controller;
import com.microservices.doctor.model.dto.PatientDTO;
import com.microservices.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/doctor")
@RestController
public class DoctorPatientController {

    @Autowired
    private DoctorPatientService doctorPatientService;

    @GetMapping("/get-patient/{patientId}")
    public PatientDTO getPatientById(@PathVariable Long patientId) {
        return doctorPatientService.getPatient(patientId);
    }

}
