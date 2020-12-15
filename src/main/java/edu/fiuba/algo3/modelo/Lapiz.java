package edu.fiuba.algo3.modelo;

public abstract class Lapiz {
     private EstadoLapiz estado;

    public void subirLapiz(){
         estado = new Levantado();
    }
    public void bajarLapiz(){
         estado = new Apoyado();
    }
}


