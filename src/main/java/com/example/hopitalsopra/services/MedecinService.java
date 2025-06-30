package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.MedecinInDto;
import com.example.hopitalsopra.entities.MedecinEntity;
import com.example.hopitalsopra.repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinService implements  IMedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Boolean existe(Integer id) {
        return medecinRepository.existsById(id);
    }

    @Override
    public Integer add(MedecinInDto dto) {
        MedecinEntity entity = toEntity(dto);

        // on sauvegarde l'element
        medecinRepository.saveAndFlush(entity);
        return entity.getID();
    }

    private MedecinEntity toEntity(MedecinInDto dto){

        MedecinEntity entity = new MedecinEntity();
        entity.setNom(dto.getNom());
        entity.setPrenom(dto.getPrenom());
        entity.setDate_naissance(dto.getDate_naissance());
        entity.setSpecialite(dto.getSpecialite().name());

        return entity;
    }
}
