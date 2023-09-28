package com.concesionario1.Domain;

public class Coche {
    private int id;
    private String matricula;
    private String modelo;

    public Coche(int id,String matricula, String modelo) {
        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
