package edu.fiuba.algo3.modelo;

public interface EstadoLapiz {
        EstadoLapiz obtenerEstado();

        EstadoLapiz cambiarEstado(EstadoLapiz nuevoEstado);
        
        void pintar(Posicion posicion, Dibujo dibujo);

}
