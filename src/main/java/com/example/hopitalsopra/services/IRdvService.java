package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.RdvInDto;
import com.example.hopitalsopra.dto.RdvOutDto;
import com.example.hopitalsopra.entities.RdvEntity;

import java.time.LocalDate;
import java.util.List;

public interface IRdvService {
    Integer ajouter(RdvInDto dto);

    RdvOutDto toDto(RdvEntity entity);

    List<RdvOutDto> getallBetweenDate(LocalDate debut, LocalDate fin, Integer id_medecin);

}
