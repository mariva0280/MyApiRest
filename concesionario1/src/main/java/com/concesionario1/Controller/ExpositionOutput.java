package com.concesionario1.Controller;

public class ExpositionOutput {
    private int codExpo;
    private String nombre;
    public ExpositionOutput(int codExpo, String nombre) {
        this.codExpo = codExpo;
        this.nombre = nombre;
    }

    public ExpositionOutput(int codExpo) {
        this.codExpo = codExpo;
        this.nombre="undefined";
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
