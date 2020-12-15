package edu.fiuba.algo3.modelo;

public class Levantado implements EstadoLapiz {
    public void pintar(Posicion posicion) { //no puede pintar, el lapiz esta levantado.
    }
    public boolean estaLevantado() {
        return true;
    }
}
