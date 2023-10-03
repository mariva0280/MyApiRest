package com.concesionario1.Domain;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private int codExpo;
    private String nombre;
    private String localidad;

    public Exposicion(int codExpo, String nombre, String localidad) {
        this.codExpo = codExpo;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Exposicion(int codExpo, String nombre) {
        this.codExpo = codExpo;
        this.nombre = nombre;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
