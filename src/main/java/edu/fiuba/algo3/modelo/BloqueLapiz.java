package edu.fiuba.algo3.modelo;

public class BloqueLapiz implements Bloque{
    private final EstadoLapiz estadoDelLapiz;

    public BloqueLapiz(EstadoLapiz estadoLapiz){
        this.estadoDelLapiz = estadoLapiz;
    }

    @Override
    public void ejecutar(Personaje personaje) {
        personaje.cambiarEstadoDelLapiz(estadoDelLapiz);
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        EstadoLapiz estadoInverso = estadoDelLapiz.obtenerEstadoInverso();
        personaje.cambiarEstadoDelLapiz(estadoInverso);
    }
}
