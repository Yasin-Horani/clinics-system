package com.microservices.doctor.service;
import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.PatientDTO;
import com.microservices.doctor.proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorPatientService {

    @Autowired
    private PatientProxy patientProxy;

    public PatientDTO getPatient(long patientId) {
        return this.patientProxy.getPatientById(patientId);
    }

    public AddPatientDTO addPatient(AddPatientDTO addPatientDTO) {
        return this.patientProxy.addPatient(addPatientDTO);
    }

    public List<PatientDTO> getAllPatients() {
        return this.patientProxy.getAllPatients();
    }
}
