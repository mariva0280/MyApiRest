package com.concesionario1.Controller;

public class CarInput {
    private String matricula;
    private String modelo;
    private String marca;
    private int anyo;

    public CarInput(String matricula, String modelo) throws InvalidCarFieldException {
        if(matricula == null) throw new InvalidCarFieldException("The car identification cannot be null");
        if(matricula.trim().isEmpty()) throw new InvalidCarFieldException("The car identification cannot be empty");
        if(matricula.trim().length() != 7 ) throw new InvalidCarFieldException("The car identification must be 7 characters long");
        this.matricula = matricula;
        if(modelo == null) throw new InvalidCarFieldException("The car model cannot be null");
        if(modelo.trim().isEmpty()) throw new InvalidCarFieldException("The car model cannot be empty");
        this.modelo = modelo;
    }
    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnyo() {
        return anyo;
    }
}
