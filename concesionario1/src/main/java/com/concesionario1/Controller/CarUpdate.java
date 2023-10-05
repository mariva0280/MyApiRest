package com.concesionario1.Controller;

import com.concesionario1.Service.CarNotFoundException;

public class CarUpdate {
    private String matricula;

    public CarUpdate(){

    }

    public CarUpdate(String matricula) throws CarNotFoundException {
        if(matricula == null) throw new CarNotFoundException("The car identification cannot be null");
        if(matricula.trim().length() < 7 || matricula.trim().length() > 7 ) throw new CarNotFoundException("The car identification cannot be less than 7 or greater than 7");
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
