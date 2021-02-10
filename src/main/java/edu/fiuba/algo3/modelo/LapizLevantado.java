package edu.fiuba.algo3.modelo;

public class LapizLevantado implements EstadoLapiz{

    @Override
    public EstadoLapiz obtenerEstado(){
        return new LapizLevantado();
    }

    @Override
    public EstadoLapiz cambiarEstado(EstadoLapiz nuevoEstado){
        return nuevoEstado;
    }

    @Override
    public void pintar(Posicion posicion, Dibujo dibujo){

    }
}
