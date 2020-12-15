package edu.fiuba.algo3.modelo;

public class BloqueLapizApoyado {

    public void ejecutar(Personaje personaje){
        personaje.bajarLapiz();
    }

    public void ejecutarInvertido(Personaje personaje){
        personaje.subirLapiz();
    }
}
