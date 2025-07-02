package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.CountBySpecialiteDto;
import com.example.hopitalsopra.dto.MedecinInDto;

import java.util.List;

public interface IMedecinService {

    Boolean existe(Integer id);
    Integer add (MedecinInDto dto);

    Integer coutBySpecialite(String specialite);

    List<CountBySpecialiteDto> coutBySpecialite();
}
