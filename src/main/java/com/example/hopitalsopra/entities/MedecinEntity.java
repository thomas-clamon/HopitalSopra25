package com.example.hopitalsopra.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Medecins")
public class MedecinEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate date_naissance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    List<RdvEntity> list_rdv;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medecin")
    List<TarifEntiy> tarifs;

    public List<RdvEntity> getList_rdv() {
        return list_rdv;
    }

    public void setList_rdv(List<RdvEntity> list_rdv) {
        this.list_rdv = list_rdv;
    }

    @Column(name = "specialite")
    private String specialite;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDate date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
