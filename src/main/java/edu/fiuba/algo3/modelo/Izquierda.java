package edu.fiuba.algo3.modelo;

public class Izquierda implements Direccion{
    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.izquierda();
    }
}
