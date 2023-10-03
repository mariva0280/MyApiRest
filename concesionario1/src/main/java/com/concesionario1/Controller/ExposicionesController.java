/*package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import com.concesionario1.Domain.Exposicion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class ExposicionesController {
    private Map<Integer, Exposicion> exposiciones = new HashMap<>();

    public ExposicionesController() {
        exposiciones.put(1, new Exposicion(1, "Madrid"));
        exposiciones.put(2, new Exposicion(2, "Talavera de la Reina"));
        exposiciones.put(3, new Exposicion(3, "Toledo"));
        exposiciones.put(4, new Exposicion(4, "Badajoz"));
        exposiciones.put(5, new Exposicion(5, "Avila"));
        exposiciones.put(6, new Exposicion(6, "Caceres"));
        exposiciones.put(7, new Exposicion(7, "Salamanca"));
        exposiciones.put(8, new Exposicion(8, "Granada"));

        exposiciones.get(1).agregarCoche(new Coche(5,"7253LLL", "TOYOTA-RAV4"));


        exposiciones.get(8).agregarCoche(new Coche(1, "7250ABC", "SEAT-LEON"));
        exposiciones.get(8).agregarCoche(new Coche(2, "7251ABB", "BMW-X1"));
        exposiciones.get(8).agregarCoche(new Coche(3,"7252BBB","OPEL-CORSA"));
        exposiciones.get(8).agregarCoche(new Coche(4,"7253JKF","LEXUS-UX"));
    }

    @GetMapping("/exposiciones")
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
    }
}*/


