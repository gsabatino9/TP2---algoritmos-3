package edu.fiuba.algo3.modelo;

public class BloqueLapiz extends Bloque{
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

    public BloqueLapiz clonar()
    {
        BloqueLapiz bloque =  new BloqueLapiz(estadoDelLapiz);
        bloque.agregarNombre(this.obtenerNombre());
        return bloque;
    }
}
