package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.PatientInDto;
import com.example.hopitalsopra.entities.PatientEntity;
import com.example.hopitalsopra.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatientService{

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Boolean existe(Integer id) {
        return patientRepository.existsById(id);
    }

    @Override
    public Integer add(PatientInDto dto) {
        PatientEntity entity = toEntity(dto);
        patientRepository.saveAndFlush(entity);
        return entity.getID();
    }

    PatientEntity toEntity(PatientInDto dto){
        PatientEntity entity = new PatientEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom((dto.getPrenom()));
        entity.setDate_naissance(dto.getDate_naissance());
        return entity;
    }
}
