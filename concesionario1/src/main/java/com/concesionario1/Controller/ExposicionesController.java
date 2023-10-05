package com.concesionario1.Controller;

import com.concesionario1.Service.CarNotFoundException;
import com.concesionario1.Service.ExpositionExistsException;
import com.concesionario1.Service.ExpositionNotFoundException;
import com.concesionario1.Service.ExpositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class ExposicionesController {
    @Autowired
    private ExpositionService expositionService;

    @PostMapping("/exposiciones")
    public ResponseEntity<String>addExposition(@RequestBody ExpositionInput exposicion) {

        try{
            expositionService.addExposition(exposicion);

        }catch (ExpositionExistsException e){
            String errorMessage = "Exposition with the same code already exists";
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(errorMessage);
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("exposiciones/{codExpo}/coches/{cocheId}")
    public ResponseEntity<String>addCocheToExposicion(@PathVariable int codExpo,@PathVariable int cocheId,@RequestBody CarInput coche){
        try{
            expositionService.addCocheToExposicion(codExpo,cocheId,coche);
            return ResponseEntity.ok().build();
        }catch (ExpositionNotFoundException e){
            String errorMessage = "Exposition not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }
    @GetMapping("/exposiciones")
    public ResponseEntity<List<ExpositionOutput>>getExposiciones() {
        List<ExpositionOutput> exposiciones = expositionService.getExposiciones();
        return ResponseEntity.ok(exposiciones);
    }
    @GetMapping("/exposiciones/{codExpo}/coches/{cocheId}")
    public ResponseEntity<CarOutput> getCarFromExposicion(@PathVariable int codExpo,@PathVariable int cocheId){
        try{
            CarOutput carOutput = expositionService.getCarFromExposicion(codExpo,cocheId);
            return ResponseEntity.ok(carOutput);
        }catch (ExpositionNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (CarNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}


