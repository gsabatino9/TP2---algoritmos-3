package edu.fiuba.algo3.modelo;

public class LapizApoyado implements EstadoLapiz{

    private static final String nombre = "LapizApoyado";
    public String obtenerNombre(){
        return nombre;
    }

    @Override
    public EstadoLapiz obtenerEstado(){
        return new LapizApoyado();
    }

    @Override
    public EstadoLapiz obtenerEstadoInverso(){
        return new LapizLevantado();
    }

    @Override
    public EstadoLapiz cambiarEstado(EstadoLapiz nuevoEstado){
        return nuevoEstado;
    }

    @Override
    public void pintar(Segmento segmento, Dibujo dibujo)
    {
        dibujo.agregarSegmento(segmento);
    }
}
