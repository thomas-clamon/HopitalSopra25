package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.MedecinInDto;

public interface IMedecinService {

    Boolean existe(Integer id);
    Integer add (MedecinInDto dto);
}
