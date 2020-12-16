package edu.fiuba.algo3.modelo;

public class Personaje {
    private Posicion posicion;
    private Lapiz lapiz;

    Personaje(Posicion posicion){
        this.lapiz = new Lapiz();
        this.posicion = posicion;
        posicion.cambiarEstado();
        this.lapiz.subirLapiz();
    }

    public void subirLapiz(){
        this.lapiz.subirLapiz();
    }
    public void bajarLapiz(){
        this.lapiz.bajarLapiz();
    }

    public void mover(Direccion direccion){
        this.lapiz.dibujar(this.posicion);
        this.posicion.cambiarEstado();
        this.posicion = direccion.mover(this.posicion);
        this.posicion.cambiarEstado();
    }

    public Posicion posicion(){
        return this.posicion;
    }
}
