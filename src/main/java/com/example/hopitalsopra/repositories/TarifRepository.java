package com.example.hopitalsopra.repositories;

import com.example.hopitalsopra.entities.TarifEntiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface TarifRepository extends JpaRepository<TarifEntiy, Integer> {

    @Query(value = "select max(tarif) from Tarifs where date_debut between ?1 and ?2 and medecin_id = ?3", nativeQuery = true)
    Long getTarifBetween(LocalDate debut, LocalDate fin, Integer id_medecin);
}
