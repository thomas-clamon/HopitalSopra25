package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.CountBySpecialiteDto;
import com.example.hopitalsopra.dto.MedecinInDto;

import java.time.LocalDate;
import java.util.List;

public interface IMedecinService {

    Boolean existe(Integer id);
    Integer add (MedecinInDto dto);

    Integer coutBySpecialite(String specialite);

    List<CountBySpecialiteDto> coutBySpecialite();

    Long NbRdvPeriod (LocalDate debut, LocalDate fin, Integer id_medecin);

    Long nbPatientPeriod(LocalDate debut, LocalDate fin, Integer id_medecin);

    Long getPrixRdv(Integer id_rdv);

    Integer CAPeriod(LocalDate debut, LocalDate fin, Integer id_medecin);
}
