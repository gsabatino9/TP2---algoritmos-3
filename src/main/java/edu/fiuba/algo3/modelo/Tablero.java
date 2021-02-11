package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private Personaje personaje;
    private Algoritmo algoritmo;

    Tablero(){
        //this.personaje = new Personaje(new Posicion(0, 0));
        //this.algoritmo = new Algoritmo(1);
    }

    public void agregarBloque(Bloque bloque){
        this.algoritmo.agregarBloque(bloque);
    }

    public void realizarSecuencia(){
        this.algoritmo.ejecutar(this.personaje);
    }

    public boolean personajeSeEncuentraEnPosicion(int columna, int fila){
        return (this.posicionDelPersonaje().esIgualA(columna, fila));
    }

    private Posicion posicionDelPersonaje(){ return this.personaje.devolverPosicion(); }

}
