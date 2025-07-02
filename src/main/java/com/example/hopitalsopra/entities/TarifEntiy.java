package com.example.hopitalsopra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tarifs")
public class TarifEntiy {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tarif")
    private Integer tarif;

    @Column(name="date_debut")
    private LocalDate date_debut;


    @Column(name="date_fin")
    private LocalDate date_fin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private MedecinEntity medecin;
}
