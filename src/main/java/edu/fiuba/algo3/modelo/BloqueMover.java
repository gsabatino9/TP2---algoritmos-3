package edu.fiuba.algo3.modelo;

public class BloqueMover implements Bloque {

    private Direccion direccion;

    BloqueMover(Direccion direccion){
        this.direccion = direccion;
    }

    public void ejecutar(Personaje personaje){
        personaje.mover(direccion);
    }

    public void ejecutarInvertido(Personaje personaje){
        Direccion direccionInversa = direccion.obtenerDireccionInversa();
        personaje.mover(direccionInversa);
    }

}
