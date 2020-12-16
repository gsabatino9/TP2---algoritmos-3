package edu.fiuba.algo3.modelo;

public class Abajo implements Direccion{
    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.abajo();
    }
}
