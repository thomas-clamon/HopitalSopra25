package com.example.hopitalsopra.controller;

import com.example.hopitalsopra.dto.RdvInDto;
import com.example.hopitalsopra.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rdv")
public class RdvController {

    @Autowired
    private IMedecinService medecinService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private IRdvService  rdvService;

    @PostMapping("add")
    public ResponseEntity add(@RequestBody RdvInDto dto)
    {
        // on verifie que le patient existe
        if(!patientService.existe(dto.getId_patient()))
            return new ResponseEntity("le patient n'existe pas ", HttpStatusCode.valueOf(400));

        if (!medecinService.existe(dto.getId_medecin()))
            return new ResponseEntity("le medecin n'existe pas ", HttpStatusCode.valueOf(400));

        if(dto.getDate_debut().isAfter(dto.getDate_fin()))
            return new ResponseEntity("la date de debut est suprieur à la date de fin", HttpStatusCode.valueOf(400));

        return new ResponseEntity(rdvService.ajouter(dto), HttpStatusCode.valueOf(200));
    }
}
