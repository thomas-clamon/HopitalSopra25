package com.example.hopitalsopra.controller;

import com.example.hopitalsopra.dto.PatientInDto;
import com.example.hopitalsopra.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("add")
    public ResponseEntity ajouter(@RequestBody PatientInDto dto){

        return new ResponseEntity(patientService.add(dto), HttpStatusCode.valueOf(200));

    }
}
