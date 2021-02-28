package edu.fiuba.algo3.modelo;

public class BloqueMover extends Bloque {

    private Direccion direccion;

    public BloqueMover(Direccion direccion) {
        this.direccion = direccion;
    }

    public void ejecutar(Personaje personaje) {
        personaje.mover(direccion);
    }

    @Override
    public void invertir(){
        direccion = direccion.obtenerDireccionInversa();
    }
}
