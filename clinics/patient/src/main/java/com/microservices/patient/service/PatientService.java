package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        log.info("Patient added: {}", patient);
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
        log.info("Patient updated: {}", entity);
        Patient patient = this.patientRepo.save(entity);
        return UpdatePatientDTO.builder()
                .patientId(patient.getPatientId())
                .patientName(patient.getPatientName())
                .patientAge(patient.getPatientAge())
                .build();
    }

    // delete patient
    public void deletePatient(Long patientId) {
        if (patientRepo.existsById(patientId)) {
            patientRepo.deleteById(patientId);
            log.info("Deleted patient with id {}", patientId);
        } else {
            log.warn("Patient with id {} does not exist", patientId);
        }
    }

    // get all patients
    public List<PatientDTO> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        if (patients.isEmpty()) {
            log.warn("No patients found");
            return Collections.emptyList();
        }

        log.info("Retrieved {} patients", patients.size());

        return patients.stream()
                .map(patient -> PatientDTO.builder()
                        .patientId(patient.getPatientId())
                        .patientName(patient.getPatientName())
                        .patientAge(patient.getPatientAge())
                        .build())
                .collect(Collectors.toList());
    }


    // get patient by id
    public PatientDTO getPatientById(Long patientId) {
        return patientRepo.findById(patientId)
                .map(patient -> {
                    log.info("Get patient with id {}", patientId);
                    return PatientDTO.builder()
                            .patientId(patient.getPatientId())
                            .patientName(patient.getPatientName())
                            .patientAge(patient.getPatientAge())
                            .build();
                })
                .orElseThrow(() -> {
                    log.warn("Patient with id {} does not exist", patientId);
                    return new EntityNotFoundException("Patient not found with id: " + patientId);
                });
    }

}