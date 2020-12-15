package edu.fiuba.algo3.modelo;

public class BloqueLapizLevantado implements Bloque{

    public void ejecutar(Personaje personaje){
        personaje.subirLapiz();
    }

    public void ejecutarInvertido(Personaje personaje){
        personaje.bajarLapiz();
    }

}
