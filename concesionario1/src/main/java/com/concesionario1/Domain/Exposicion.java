package com.concesionario1.Domain;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {
    private int numExpo;
    private String localidad;
    private List<Coche> cochesExpo = new ArrayList<>();


    public Exposicion(int numExpo, String localidad) {
        this.numExpo = numExpo;
        this.localidad = localidad;
    }

    public int getNumExpo() {
        return numExpo;
    }

    public void setNumExpo(int numExpo) {
        this.numExpo = numExpo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Coche> getCochesExpo() {
        return cochesExpo;
    }
    public void agregarCoche(Coche coche) {
        cochesExpo.add(coche);
    }
}
