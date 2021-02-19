package edu.fiuba.algo3.modelo;

public class BloqueLapiz implements Bloque{
    private EstadoLapiz estadoDelLapiz;

    public BloqueLapiz(EstadoLapiz estadoLapiz){
        this.estadoDelLapiz = estadoLapiz;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.cambiarEstadoDelLapiz(estadoDelLapiz);
    }

    @Override
    public void invertir(){
        this.estadoDelLapiz = estadoDelLapiz.obtenerEstadoInverso();
    }
}
