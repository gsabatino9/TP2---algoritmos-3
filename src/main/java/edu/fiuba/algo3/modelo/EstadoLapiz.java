package edu.fiuba.algo3.modelo;

public interface EstadoLapiz {
        EstadoLapiz obtenerEstado();

        EstadoLapiz cambiarEstado(EstadoLapiz nuevoEstado);
        
        void pintar(Segmento segmento, Dibujo dibujo);

}
