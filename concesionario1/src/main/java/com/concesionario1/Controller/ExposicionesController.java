package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import com.concesionario1.Domain.Exposicion;
import com.concesionario1.Service.ExpositionExistsException;
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
        //ExpositionService expositionService = new ExpositionService();
        try{
            expositionService.addExposition(exposicion);

        }catch (ExpositionExistsException e){
            String errorMessage = "Exposition with the same code already exists";
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(errorMessage);
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/exposiciones")
    public ResponseEntity<List<ExpositionOutput>>getExposiciones() {
        List<ExpositionOutput> exposiciones = expositionService.getExposiciones();
        return ResponseEntity.ok(exposiciones);
    }


    /*@GetMapping("/exposiciones")
    public List<Exposicion> listarExposiciones() {
        return new ArrayList<>(exposiciones.values());
    }

    @GetMapping("/exposiciones/{numExpo}")
    public Exposicion obtenerExposicionPorNumExpo(@PathVariable int numExpo) {
        return exposiciones.getOrDefault(numExpo, null);
    }

    @GetMapping("/exposiciones/{numExpo}/coches")
    public List<Coche> obtenerCochesExposicion(@PathVariable int numExpo) {
        Exposicion exposicion = exposiciones.get(numExpo);
        if(exposicion != null) {
            return exposicion.getCochesExpo();
        }else {
            return new ArrayList<>(); 
        }
    }

    @GetMapping("/exposiciones/{numExpo}/coches/{cocheId}")
    public Coche obtenerCocheDeExposicion(@PathVariable int numExpo, @PathVariable int cocheId) {
        Exposicion exposicion = exposiciones.get(numExpo);
        if (exposicion != null) {
            for (Coche coche : exposicion.getCochesExpo()) {
                if (coche.getId() == cocheId) {
                    return coche;
                }
            }
        }
        return null;
    }*/
}


