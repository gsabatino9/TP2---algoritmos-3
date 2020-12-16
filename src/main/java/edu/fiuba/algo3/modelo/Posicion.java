package edu.fiuba.algo3.modelo;

public class Posicion{
    private Ocupacion estado;
    private Posicion arriba;
    private Posicion abajo;
    private Posicion izquierda;
    private Posicion derecha;

    Posicion(){
        this.estado = new DesocupadoSinPintar();
    }

    public void cambiarEstado(){
        this.estado = estado.cambiarEstado();
    }

    public void agregarIzquierda(Posicion posicion){
        this.izquierda = posicion;
    }

    public void agregarDerecha(Posicion posicion){
        this.derecha = posicion;
    }

    public void agregarArriba(Posicion posicion){
        this.arriba = posicion;
    }

    public void agregarAbajo(Posicion posicion){
        this.abajo = posicion;
    }

    public Posicion izquierda(){
        return this.izquierda;
    }

    public Posicion derecha(){
        return this.derecha;
    }

    public Posicion arriba(){
        return this.arriba;
    }

    public Posicion abajo(){
        return this.abajo;
    }

    public void pintar(){
        this.estado = this.estado.pintar();
    }

    public boolean estaPintada(){
        return this.estado.estaPintada();
    }

    public boolean estaOcupada(){
        return this.estado.estaOcupada();
    }
}



