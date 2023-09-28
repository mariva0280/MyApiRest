package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import com.concesionario1.Domain.Propietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PropietariosController {
    private Map<Integer,Propietario> cochePropietario = new HashMap<>();
    public PropietariosController(){
        Propietario propietario1 = new Propietario("12345678A","JUAN","Calle NY");
        Propietario propietario2 = new Propietario("12345678B","Ana","Calle DC");

        Coche coche1 = new Coche(1,"7250ABC","SEAT-LEON");
        Coche coche2 = new Coche(2,"7251ABB","BMW-X1");
        Coche coche3 = new Coche(3,"7252BBB","OPEL-CORSA");
        Coche coche4 = new Coche(4,"7253JKF","LEXUS-UX");

        cochePropietario.put(1,propietario1);
        cochePropietario.put(2,propietario2);
        cochePropietario.put(3,propietario1);
        cochePropietario.put(4,propietario2);

    }
    @GetMapping("/coches/{cocheId}/propietarios")
    public List<Propietario> propietarioCoche(@PathVariable int cocheId) {
        List<Propietario> propietariosCoches = new ArrayList<>();
        if (cochePropietario.containsKey(cocheId)){
            propietariosCoches.add(cochePropietario.get(cocheId));
        }
        return propietariosCoches;
    }
}
