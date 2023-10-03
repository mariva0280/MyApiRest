package com.concesionario1.Controller;

public class CarOutput {
    private String matricula;
    private String marca;
    private String modelo;
    private int anyo;

    public CarOutput(String matricula, String marca, String modelo, int anyo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnyo() {
        return anyo;
    }
}
