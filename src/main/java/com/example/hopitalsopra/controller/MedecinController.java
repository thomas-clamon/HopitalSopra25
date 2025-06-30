package com.example.hopitalsopra.controller;

import com.example.hopitalsopra.dto.MedecinInDto;
import com.example.hopitalsopra.services.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Medecin")
public class MedecinController {

    @Autowired
    private IMedecinService service;

    @PostMapping("add")
    ResponseEntity ajouter (@RequestBody MedecinInDto dto){
        return new ResponseEntity<>(service.add(dto), HttpStatusCode.valueOf(200));
    }

}
