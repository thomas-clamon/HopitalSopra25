package com.example.hopitalsopra.services;

import com.example.hopitalsopra.dto.CountBySpecialiteDto;
import com.example.hopitalsopra.dto.MedecinInDto;
import com.example.hopitalsopra.entities.MedecinEntity;
import com.example.hopitalsopra.entities.RdvEntity;
import com.example.hopitalsopra.repositories.MedecinRepository;
import com.example.hopitalsopra.repositories.RdvRepository;
import com.example.hopitalsopra.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedecinService implements  IMedecinService {

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private RdvRepository rdvRepository;

    @Autowired
    private TarifRepository tarifRepository;

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

    @Override
    public Integer coutBySpecialite(String specialite) {
        return medecinRepository.countBySpecialiteIs(specialite);
    }

    @Override
    public List<CountBySpecialiteDto> coutBySpecialite() {
        return medecinRepository.countspecialite();
    }

    @Override
    public Long NbRdvPeriod(LocalDate debut, LocalDate fin, Integer id_medecin) {
        return rdvRepository.getRdvBetweenDate(debut, fin, id_medecin).stream().count();
    }

    @Override
    public Long nbPatientPeriod(LocalDate debut, LocalDate fin, Integer id_medecin) {
        return rdvRepository.getRdvBetweenDate(debut, fin, id_medecin).stream().map(entity -> entity.getPatient().getID()).distinct().count();
    }


    @Override
    public Long getPrixRdv(Integer id_rdv) {

        // on recupere le rdv
        RdvEntity rdv = rdvRepository.findById(id_rdv).get();

        // on calcule la duree en minute
        long duree = Duration.between(rdv.getDate_debut(), rdv.getDate_fin()).toMinutes();

        // on recupere le tarifs
        long tarif = tarifRepository.getTarifBetween(rdv.getDate_debut().toLocalDate(), rdv.getDate_fin().toLocalDate(),rdv.getMedecin().getID());

        return tarif * duree;
    }

    @Override
    public Integer CAPeriod(LocalDate debut, LocalDate fin, Integer id_medecin) {
        List<Integer> lit_ids = rdvRepository.getRdvBetweenDate(debut, fin, id_medecin).stream().map(entity -> entity.getID()).collect(Collectors.toList());

        return lit_ids.stream().mapToInt(elem -> Math.toIntExact(getPrixRdv(elem))).sum();
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
