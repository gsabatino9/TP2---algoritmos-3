package edu.fiuba.algo3.modelo;

public class Lapiz {
    private EstadoLapiz estado;

    public void dibujar(){
        estado.pintar();
    }
    public void subirLapiz(){
         estado = new Levantado();
    }
    public void bajarLapiz(){
         estado = new Apoyado();
    }
}


