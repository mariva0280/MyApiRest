package com.concesionario1.Controller;

import com.concesionario1.Service.CarNotFoundException;

public class CarUpdate {
    private String matricula;

    public CarUpdate(){

    }

    public CarUpdate(String matricula) throws CarNotFoundException,InvalidCarFieldException {
        if(matricula == null) throw new CarNotFoundException("The car identification cannot be null");
        if(matricula.trim().isEmpty()) throw new InvalidCarFieldException("The car identification cannot be empty");
        if(matricula.trim().length() != 7 ) throw new CarNotFoundException("The car identification must be 7 characters long");
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
