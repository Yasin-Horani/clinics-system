package com.microservices.patient.model.mapper;

import com.microservices.patient.model.dto.PatientDTO;
import com.microservices.patient.model.dto.UpdatePatientDTO;
import com.microservices.patient.model.entity.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDTO dto);

    PatientDTO toDTO(Patient entity);

    List<PatientDTO> toDTOList(List<Patient> patients);

    Patient toEntity(UpdatePatientDTO dto);
}

