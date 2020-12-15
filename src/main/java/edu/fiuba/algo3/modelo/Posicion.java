package edu.fiuba.algo3.modelo;

public class Posicion{
    private Ocupacion estado;
    private Posicion arriba;
    private Posicion abajo;
    private Posicion izquierda;
    private Posicion derecha;

    Posicion(){
        this.estado = new Desocupado();
    }

    public boolean estaOcupada(){
        return this.estado.estaOcupada();
    }

    public void cambiarEstado(){
        this.estado = estado.cambiarEstado();
    }

    public Posicion izquierda(){
        return this.izquierda();
    }

    public Posicion derecha(){
        return this.derecha();
    }

    public Posicion arriba(){
        return this.arriba();
    }

    public Posicion abajo(){
        return this.abajo();
    }
}



