package com.example.hopitalsopra.repositories;

import com.example.hopitalsopra.entities.MedecinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<MedecinEntity, Integer> {
}
