package com.microservices.doctor.service;

import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorPatientService {

    @Autowired
    private PatientProxy patientProxy;

    public String getPatientByFeignClient(String patientName) {
        return this.patientProxy.getPname(patientName);
    }
}
