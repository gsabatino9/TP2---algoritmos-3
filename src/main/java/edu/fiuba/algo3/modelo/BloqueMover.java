package edu.fiuba.algo3.modelo;

public class BloqueMover implements Bloque {

    private Direccion direccion;

    BloqueMover(Direccion direccion){
        this.direccion = direccion;
    }
    public void ejecutar(Personaje personaje){}
    public void ejecutarInvertido(Personaje personaje){}

}
