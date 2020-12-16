package edu.fiuba.algo3.modelo;

public class Arriba implements Direccion{
    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.arriba();
    }
}
