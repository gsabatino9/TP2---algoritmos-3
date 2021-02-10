package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;


public class Algoritmo {

    private List<Bloque> bloques = new ArrayList<Bloque>();


    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }

    public void realizarSecuencia(Personaje personaje) {
        bloques.stream().forEach(bloque -> bloque.ejecutar(personaje));
    }
}
