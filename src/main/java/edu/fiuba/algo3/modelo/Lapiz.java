package edu.fiuba.algo3.modelo;

public class Lapiz {

    private EstadoLapiz estado;
    private Dibujo dibujo;

    public Lapiz(Dibujo dibujo) {
        this.dibujo = dibujo;
        this.estado = new LapizLevantado();
    }

    public EstadoLapiz obtenerEstado()
    {
        return this.estado.obtenerEstado();
    }

    public void cambiarEstado(EstadoLapiz nuevoEstado) {
        this.estado = this.estado.cambiarEstado(nuevoEstado);
    }

    public void pintar(Segmento segmento)
    {
        this.estado.pintar(segmento, this.dibujo);
    }
}
