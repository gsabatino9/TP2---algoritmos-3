package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Algoritmo implements Bloque {

    private List<Bloque> bloques;
    private int cantidadReproducciones;

    public Algoritmo() {
        cantidadReproducciones = 1;
        bloques = new ArrayList<Bloque>();
    }

    public Algoritmo(int cantidad) {
        if (cantidad <= 0) {
            //tiene que saltarme una excepcion, no puedo repetir un código 0 o menos de 0 veces
        }
        cantidadReproducciones = cantidad;
        bloques = new ArrayList<Bloque>();
    }

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }


    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < cantidadReproducciones; i++) {
            bloques.forEach(bloque -> bloque.ejecutar(personaje));
        }
    }


    @Override
    public void ejecutarInvertido(Personaje personaje) {
    //el bloque ejecutar invertir podría dar vuelta la lista y ejecutarla dada vuelta.
        List<Bloque> copia = new ArrayList<Bloque>(bloques);
        Collections.reverse(copia);
        for (int i = 0; i < cantidadReproducciones; i++)
            copia.forEach(bloque->bloque.ejecutar(personaje));
    }

    /*
    public void ejecutarInvertido(Personaje personaje) {
        //el bloque ejecutar invertir podría dar vuelta la lista y ejecutarla dada vuelta.
        //puedo sino dar vuelta dos veces la lista en el lugar, sin necesidad de crearme otra

        Collections.reverse(bloques);
        for (int i = 0; i < cantidadReproducciones; i++)
            bloques.forEach(bloque->bloque.ejecutar(personaje));
        Collections.reverse(bloques);
    }*/
}
