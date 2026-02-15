package com.microservices.doctor.service;
import com.microservices.doctor.model.dto.AddPatientDTO;
import com.microservices.doctor.model.dto.PatientDTO;
import com.microservices.doctor.model.dto.UpdatePatientDTO;
import com.microservices.doctor.proxy.PatientProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    public PatientDTO updatePatient(UpdatePatientDTO updatePatientDTO) {
        return this.patientProxy.updatePatient(updatePatientDTO);
    }

    public void deletePatient(Long patientId) {
        this.patientProxy.deletePatient(patientId);
    }
}
