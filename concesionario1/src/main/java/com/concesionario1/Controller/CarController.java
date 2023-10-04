package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import com.concesionario1.Service.CarExistsException;
import com.concesionario1.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping("/coches")
    public ResponseEntity<String>addCar(@RequestBody CarInput coche){
        //CarService carService = new CarService();
        try{
            carService.addCar(coche);
        }catch (CarExistsException e) {
            String errorMessage = "Car with the same matricula already exists.";
            return ResponseEntity.status(HttpStatus.FOUND).body(errorMessage);
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/coches")
    public ResponseEntity<List<CarOutput>>getCoches() {
        List<CarOutput> coches = carService.getCoches();
        return ResponseEntity.ok(coches);
    }

    @GetMapping("/coches/{id}")
    public ResponseEntity<CarOutput> getIdCcoches (@PathVariable int id)  {
        CarOutput coche = carService.getIdCoches(id);
        if(coche != null) {
            return ResponseEntity.ok(coche);
        }else{
            return ResponseEntity.notFound().build();
        }

    }


}
