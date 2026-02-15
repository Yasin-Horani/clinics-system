package com.microservices.patient.service;

import com.microservices.patient.model.dto.AddPatientDTO;
import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import com.microservices.patient.model.mapper.PatientMapper;
import com.microservices.patient.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientMapper patientMapper;

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
    public PatientDTO updatePatient(UpdatePatientDTO dto) {
        Patient existingPatient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> {
                    log.warn("Patient with id {} not found", dto.getPatientId());
                    return new EntityNotFoundException(
                            "Patient with id " + dto.getPatientId() + " not found");
                });
        existingPatient.setPatientName(dto.getPatientName());
        existingPatient.setPatientAge(dto.getPatientAge());
        Patient updatedPatient = patientRepo.save(existingPatient);
        log.info("Patient updated: {}", updatedPatient);
        return patientMapper.toDTO(updatedPatient);
    }


    // delete patient
    public void deletePatient(Long patientId) {
        if (patientRepo.existsById(patientId)) {
            patientRepo.deleteById(patientId);
            log.info("Deleted patient with id {}", patientId);
        } else {
            log.warn("Patient with id {} does not exist ", patientId);
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
        return patientMapper.toDTOList(patients);
    }


    // get patient by id
    public PatientDTO getPatientById(Long patientId) {
        return patientRepo.findById(patientId)
                .map(patientMapper::toDTO)
                .orElseThrow(() -> {
                    log.warn("Patient with id {} does not exist", patientId);
                    return new EntityNotFoundException(
                            "Patient with id " + patientId + " not found");
                });
    }


}