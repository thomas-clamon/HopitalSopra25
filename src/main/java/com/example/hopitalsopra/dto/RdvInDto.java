package com.example.hopitalsopra.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RdvInDto {

    private LocalDateTime date_debut;
    private LocalDateTime date_fin;

    private Integer id_medecin;

    private Integer id_patient;

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

    public Integer getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(Integer id_medecin) {
        this.id_medecin = id_medecin;
    }

    public Integer getId_patient() {
        return id_patient;
    }

    public void setId_patient(Integer id_patient) {
        this.id_patient = id_patient;
    }
}
