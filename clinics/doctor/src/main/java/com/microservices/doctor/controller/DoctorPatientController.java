package com.microservices.doctor.controller;

import com.microservices.doctor.service.DoctorPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorPatientController {

    @Autowired
    private DoctorPatientService doctorPatientService; ;

    @GetMapping("/doctor/get-patient/{patientName}")
    public String getPatient(@PathVariable String patientName) {
        return doctorPatientService.getPatientByFeignClient(patientName);
    }
}
