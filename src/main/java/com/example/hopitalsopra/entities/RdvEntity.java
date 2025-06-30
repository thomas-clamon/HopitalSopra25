package com.example.hopitalsopra.entities;

import jakarta.persistence.*;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDateTime;

@Entity
@Table(name="Rdvs")
public class RdvEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "date_debut")
    private LocalDateTime date_debut;

    @Column(name = "date_fin")
    private LocalDateTime date_fin;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    private MedecinEntity medecin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_patient")
    private PatientEntity patient;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public MedecinEntity getMedecin() {
        return medecin;
    }

    public void setMedecin(MedecinEntity medecin) {
        this.medecin = medecin;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}
