package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.repository.PatientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

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

    public void deletePatient(Long patientId) {
        if (patientRepo.existsById(patientId)) {
            patientRepo.deleteById(patientId);
            log.info("Deleted patient with id {}", patientId);
        } else {
            log.warn("Patient with id {} does not exist", patientId);
        }
    }
}