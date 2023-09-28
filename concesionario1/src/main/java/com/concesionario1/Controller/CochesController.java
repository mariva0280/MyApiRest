package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CochesController {
    private List<Coche> coches = new ArrayList<>();

    public CochesController() {
        coches.add(new Coche(1,"7250ABC","SEAT-LEON"));
        coches.add(new Coche(2,"7251ABB","BMW-X1"));
        coches.add(new Coche(3,"7252BBB","OPEL-CORSA"));
        coches.add(new Coche(4,"7253JKF","LEXUS-UX"));

    }
    @GetMapping("/coches")
    public List<Coche>listarCoches(){
        return coches;
    }
    @GetMapping("/coches/{id}")
    public Coche obtenerCochePorId(@PathVariable int id) throws Exception {
        for(Coche coche : coches) {
            if(coche.getId() == id) {
                return coche;
            }
        }
        throw new Exception("Coche no encontrado");
    }


}
