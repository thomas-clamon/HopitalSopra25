package com.example.hopitalsopra.controller;

import com.example.hopitalsopra.dto.MedecinInDto;
import com.example.hopitalsopra.enumeration.Specialite;
import com.example.hopitalsopra.services.IMedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Medecin")
public class MedecinController {

    @Autowired
    private IMedecinService service;

    @PostMapping("add")
    ResponseEntity ajouter (@RequestBody MedecinInDto dto){
        return new ResponseEntity<>(service.add(dto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("count")
    ResponseEntity getByspecialite(@RequestParam("specialite") String specialite){

        // on check le parametre
        try {
            Specialite.valueOf(specialite);
        }catch (IllegalArgumentException e)
        {
            return new ResponseEntity<>("la specialite n'est pas correct", HttpStatusCode.valueOf(200) );
        }
        return new ResponseEntity(service.coutBySpecialite(specialite), HttpStatusCode.valueOf(200));
    }

    @GetMapping("countSpecialite")
    ResponseEntity findAllBySpecialite()
    {
        return new ResponseEntity<>(service.coutBySpecialite(), HttpStatusCode.valueOf(200));
    }



}
