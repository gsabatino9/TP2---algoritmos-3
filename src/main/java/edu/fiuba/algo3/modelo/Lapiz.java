package edu.fiuba.algo3.modelo;

public class Lapiz {
    private EstadoLapiz estado;

    public void dibujar(Posicion posicion){
        this.estado.pintar(posicion);
    }
    public void subirLapiz(){
         this.estado = new Levantado();
    }
    public void bajarLapiz(){
         this.estado = new Apoyado();
    }

    Lapiz() {
        this.estado = new Levantado();
    }

    public boolean estaLevantado() {
        return this.estado.estaLevantado();
    }
}


