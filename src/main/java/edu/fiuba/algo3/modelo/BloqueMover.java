package edu.fiuba.algo3.modelo;

public class BloqueMover implements Bloque {

    private Direccion direccion;

    BloqueMover(Direccion direccion) {
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
