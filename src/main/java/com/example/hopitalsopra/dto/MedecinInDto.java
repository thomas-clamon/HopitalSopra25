package com.example.hopitalsopra.dto;

import com.example.hopitalsopra.enumeration.Specialite;

import java.time.LocalDate;

public class MedecinInDto {

    private String nom;
    private String prenom;

    private LocalDate date_naissance;

    private Specialite specialite;

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
