package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.PatientInDto;

public interface IPatientService {

    Boolean existe(Integer id);
    Integer add (PatientInDto dto);
}
