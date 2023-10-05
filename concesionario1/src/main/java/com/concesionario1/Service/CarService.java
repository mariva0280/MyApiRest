package com.concesionario1.Service;

import com.concesionario1.Controller.CarInput;
import com.concesionario1.Controller.CarOutput;
import com.concesionario1.Controller.CarUpdate;
import com.concesionario1.Domain.Coche;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class CarService {
    private List<Coche> coches = new ArrayList<>();
    private Map<Integer,String>idMatricula = new HashMap<>();
    private int nextId = 1;

    public void addCar(CarInput input) throws CarExistsException{
        Coche coche = new Coche(input.getMatricula(), input.getModelo(),input.getMarca(),input.getAnyo());
        for(Coche item : coches) {
            if(item.getMatricula().equalsIgnoreCase(coche.getMatricula())) throw new CarExistsException("The car already exists.");
        }
        coches.add(coche);
        idMatricula.put(nextId, coche.getMatricula());
        nextId++;
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
    public CarOutput changeCar(String matricula, CarUpdate car) throws CarNotFoundException,CarExistsException {
        for(Coche coche : coches) {
            if(coche.getMatricula().equalsIgnoreCase(matricula)){
                for (Coche existsCoche : coches) {
                    if (existsCoche.getMatricula().equalsIgnoreCase(car.getMatricula())) {
                        throw new CarExistsException("Car with the same matricula already exists.");
                    }
                }
                coche.setMatricula(car.getMatricula());

                for (Integer key : idMatricula.keySet()) {
                    String value = idMatricula.get(key);
                    if (value.equalsIgnoreCase(matricula)) {
                        idMatricula.put(key, car.getMatricula());
                        break;
                    }
                }

                return new CarOutput(coche.getMatricula(), coche.getMarca(),coche.getModelo(),coche.getAnyo());
            }
        }
        throw new CarNotFoundException("Car not exists");
    }
}