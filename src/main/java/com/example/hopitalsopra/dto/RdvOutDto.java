package com.example.hopitalsopra.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RdvOutDto {

    private  String patient;
    private Integer age;

    private LocalDateTime debut;

    private Long duree;

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }
}
