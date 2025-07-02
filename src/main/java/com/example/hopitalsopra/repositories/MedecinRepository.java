package com.example.hopitalsopra.repositories;

import com.example.hopitalsopra.dto.CountBySpecialiteDto;
import com.example.hopitalsopra.entities.MedecinEntity;
import com.example.hopitalsopra.enumeration.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MedecinRepository extends JpaRepository<MedecinEntity, Integer> {


    Integer countBySpecialiteIs(String specialite);

    List<MedecinEntity> findAllBySpecialite(String specialite);

    @Query(value = "select count(*) as 'nb', specialite from Medecins group by specialite", nativeQuery = true)
    List<CountBySpecialiteDto> countspecialite();
}
