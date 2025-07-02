package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.RdvInDto;
import com.example.hopitalsopra.dto.RdvOutDto;
import com.example.hopitalsopra.entities.MedecinEntity;
import com.example.hopitalsopra.entities.PatientEntity;
import com.example.hopitalsopra.entities.RdvEntity;
import com.example.hopitalsopra.repositories.MedecinRepository;
import com.example.hopitalsopra.repositories.PatientRepository;
import com.example.hopitalsopra.repositories.RdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class RdvService implements IRdvService{

    @Autowired
    private RdvRepository rdvRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Integer ajouter(RdvInDto dto) {
        RdvEntity entity = toEntity(dto);
        rdvRepository.saveAndFlush(entity);
        return entity.getID();
    }

    @Override
    public RdvOutDto toDto(RdvEntity entity) {
        RdvOutDto dto = new RdvOutDto();
        // on calcule le nom prenom
        dto.setPatient(entity.getPatient().getPrenom() + " " + entity.getPatient().getNom());
        // on calcule l'age
        dto.setAge(Period.between(entity.getPatient().getDate_naissance(), LocalDate.now()).getYears());
        // on ajoute la date
        dto.setDebut(entity.getDate_debut());
        // on calcule la duree
        dto.setDuree(Duration.between(entity.getDate_debut(), entity.getDate_fin()).toMinutes());
        return dto;
    }

    @Override
    public List<RdvOutDto> getallBetweenDate(LocalDate debut, LocalDate fin, Integer id_medecin) {

        List<RdvEntity> entities = rdvRepository.getRdvBetweenDate(debut, fin, id_medecin);
        return entities.stream().map(entity -> toDto(entity)).toList();

    }

    private RdvEntity toEntity(RdvInDto dto)
    {
        RdvEntity entity = new RdvEntity();
        entity.setDate_debut(dto.getDate_debut());
        entity.setDate_fin(dto.getDate_fin());

        // on recupere le medecin qui correspond à l'ID
        MedecinEntity medecinEntity = medecinRepository.findById(dto.getId_medecin()).get();
        PatientEntity patientEntity = patientRepository.findById(dto.getId_patient()).get();

        entity.setMedecin(medecinEntity);
        entity.setPatient(patientEntity);
        return entity;
    }
}
