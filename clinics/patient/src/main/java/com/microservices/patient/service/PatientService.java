package com.microservices.patient.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PatientService {

    private List<String> names = Arrays.asList("yasin", "thomas", "tom");

    public String getPatientName(String name) {
        return names.stream().filter(n -> n.equals(name)).findAny().orElse("No patient found");
    }
}
