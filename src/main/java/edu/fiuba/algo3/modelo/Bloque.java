package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Bloque {

    private String nombre;

    public abstract void ejecutar(Personaje personaje);

    public abstract void invertir();

    public String obtenerNombre(){
        return nombre;
    }

    public void agregarNombre(String nombre){
        this.nombre = nombre;
    }

    public ArrayList<Bloque> obtenerHijos(){
        return new ArrayList<>();
    }
}
