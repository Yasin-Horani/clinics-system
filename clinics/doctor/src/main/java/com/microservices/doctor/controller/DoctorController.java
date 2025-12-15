package com.microservices.doctor.controller;

import com.microservices.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "doctor/get-patient/{pName}")
    public String getPname(@PathVariable("pName") String pName) {
        return this.doctorService.getPatient(pName);
    }
}
