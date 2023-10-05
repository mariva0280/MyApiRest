package com.concesionario1.Controller;

public class ExpositionUpdate {
    private int codExpo;
    private String nombre;

    public ExpositionUpdate() {
    }

    public ExpositionUpdate(int codExpo, String nombre) throws InvalidExpositionFieldException {
        if(nombre == null) throw new InvalidExpositionFieldException("The exposition name cannot be null");
        if(nombre == "") throw new InvalidExpositionFieldException("The exposition name cannot be empty");
        if(nombre.trim().length() < 1) throw new InvalidExpositionFieldException("The exposition name cannot have less than 1 of length");
        this.nombre = nombre;

        if(codExpo < 1 || codExpo > 999) throw new InvalidExpositionFieldException("The exposition code cannot be null");
        this.codExpo = codExpo;

    }

    public int getCodExpo() {
        return codExpo;
    }

    public void setCodExpo(int codExpo) {
        this.codExpo = codExpo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
