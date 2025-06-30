package com.example.hopitalsopra.repositories;

import com.example.hopitalsopra.entities.RdvEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvRepository extends JpaRepository<RdvEntity, Integer> {
}
