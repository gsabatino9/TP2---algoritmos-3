package edu.fiuba.algo3.modelo;

public class BloqueMover implements Bloque{
    private Direccion direccion;

    public void ejecutar(Personaje personaje){
        personaje.mover(direccion);
    }

    public void ejecutarInvertido(Personaje personaje){
        personaje.mover(direccion.invertir());
    }
}
