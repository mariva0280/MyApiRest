package com.concesionario1.Service;

import com.concesionario1.Controller.CarInput;
import com.concesionario1.Controller.CarOutput;
import com.concesionario1.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class CarService {
    private List<Coche> coches = new ArrayList<>();

    public void addCar(CarInput input) throws CarExistsException{
        //Coche coche = new Coche(input.getMatricula(),input.getModelo());
        Coche coche = new Coche(input.getMatricula(), input.getModelo(),input.getMarca(),input.getAnyo());
        for(Coche item : coches) {
            if(item.getMatricula().equalsIgnoreCase(coche.getMatricula())) throw new CarExistsException("The car already exists.");
        }
        coches.add(coche);
    }

    public List<CarOutput> getCoches() {
        List<CarOutput> carOutput = new ArrayList<>();
        for(Coche coche : coches) {
            carOutput.add(new CarOutput(coche.getMatricula(),coche.getMarca(),coche.getModelo(),coche.getAnyo()));
        }
        return carOutput;
    }
}
