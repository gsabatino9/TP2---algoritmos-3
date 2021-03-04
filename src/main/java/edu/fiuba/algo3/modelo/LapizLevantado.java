package edu.fiuba.algo3.modelo;

public class LapizLevantado implements EstadoLapiz{

    private static final String nombre = "LapizLevantado";
    public String obtenerNombre(){
        return nombre;
    }
    @Override
    public EstadoLapiz obtenerEstado(){
        return new LapizLevantado();
    }

    @Override
    public EstadoLapiz obtenerEstadoInverso(){
        return new LapizApoyado();
    }

    @Override
    public EstadoLapiz cambiarEstado(EstadoLapiz nuevoEstado){
        return nuevoEstado;
    }

    @Override
    public void pintar(Segmento segmento, Dibujo dibujo){

    }
}
