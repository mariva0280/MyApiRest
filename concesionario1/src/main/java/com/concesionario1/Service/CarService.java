package com.concesionario1.Service;

import com.concesionario1.Controller.CarInput;
import com.concesionario1.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class CarService {
    private List<Coche> coches = new ArrayList<>();

    public void addCar(CarInput input) throws CarExistsException{
        Coche coche = new Coche(input.getMatricula(),input.getModelo());
        for(Coche item : coches) {
            if(item.getMatricula().equalsIgnoreCase(coche.getMatricula())) throw new CarExistsException("The car already exists.");
        }
        coches.add(coche);
    }
}
