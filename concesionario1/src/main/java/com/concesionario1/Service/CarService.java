package com.concesionario1.Service;

import com.concesionario1.Controller.CarInput;
import com.concesionario1.Controller.CarOutput;
import com.concesionario1.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class CarService {
    private List<Coche> coches = new ArrayList<>();
    private Map<Integer,String> idMatricula = new HashMap<>();

    public void addCar(CarInput input) throws CarExistsException{
        //Coche coche = new Coche(input.getMatricula(),input.getModelo());
        Coche coche = new Coche(input.getMatricula(), input.getModelo(),input.getMarca(),input.getAnyo());
        for(Coche item : coches) {
            if(item.getMatricula().equalsIgnoreCase(coche.getMatricula())) throw new CarExistsException("The car already exists.");
        }
        coches.add(coche);
        idMatricula.put(coches.size(),coche.getMatricula());
    }

    public List<CarOutput> getCoches() {
        List<CarOutput> carOutput = new ArrayList<>();
        for(Coche coche : coches) {
            carOutput.add(new CarOutput(coche.getMatricula(),coche.getMarca(),coche.getModelo(),coche.getAnyo()));
        }
        return carOutput;
    }
    public CarOutput getIdCoches(int id){
        String matricula = idMatricula.get(id);
        if(matricula != null){
            for(Coche coche : coches) {
                if (coche.getMatricula().equals(matricula)) {
                    return new CarOutput(coche.getMatricula());
                }
            }
        }
        return null;
    }
}