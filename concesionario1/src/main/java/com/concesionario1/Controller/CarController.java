package com.concesionario1.Controller;

import com.concesionario1.Domain.Coche;
import com.concesionario1.Service.CarExistsException;
import com.concesionario1.Service.CarNotFoundException;
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

   @PutMapping("/coches/{id}")
    public ResponseEntity<CarOutput>changeCar(@PathVariable int id,@RequestBody CarUpdate car){
        try{
            CarOutput cars = carService.getIdCoches(id);
           if(cars != null) {
               String matricula = cars.getMatricula();
               CarOutput result = carService.changeCar(matricula,car);
               return ResponseEntity.ok(result);
           }else{
               return ResponseEntity.notFound().build();
           }
        }catch (CarNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (CarExistsException e) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
    }

}
