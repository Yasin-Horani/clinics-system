package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

//    private List<String> names = Arrays.asList("yasin", "thomas", "tom");
//
//    public String getPatientName(String name) {
//        return names.stream().filter(n -> n.equals(name)).findAny().orElse("No patient found");
//    }

    // add new patient
    public AddPatientDTO addPatient(AddPatientDTO addPatientDTO) {
        Patient entity = Patient.builder()
                .patientName(addPatientDTO.getPatientName())
                .patientAge(addPatientDTO.getPatientAge())
                .build();
        Patient patient = this.patientRepo.save(entity);
        return AddPatientDTO.builder()
                .patientName(patient.getPatientName())
                .patientAge(patient.getPatientAge())
                .build();
    }

    // update patient
    public UpdatePatientDTO updatePatient(UpdatePatientDTO updatePatientDTO) {
        Patient entity = Patient.builder()
                .patientId(updatePatientDTO.getPatientId())
                .patientName(updatePatientDTO.getPatientName())
                .patientAge(updatePatientDTO.getPatientAge())
                .build();
        Patient patient = this.patientRepo.save(entity);
        return UpdatePatientDTO.builder()
                .patientId(patient.getPatientId())
                .patientName(patient.getPatientName())
                .patientAge(patient.getPatientAge())
                .build();
    }

}
