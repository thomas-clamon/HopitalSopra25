package com.example.hopitalsopra.repositories;

import com.example.hopitalsopra.entities.RdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RdvRepository extends JpaRepository<RdvEntity, Integer> {

    @Query(value = "select * from Rdvs where date_debut between ?1 and ?2 and medecin_id = ?3", nativeQuery = true)
    List<RdvEntity> getRdvBetweenDate(LocalDate debut, LocalDate fin, Integer id_medecin);

}
