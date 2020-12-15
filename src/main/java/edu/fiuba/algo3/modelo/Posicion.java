package edu.fiuba.algo3.modelo;

public class Posicion {
    private Posicion derecha;
    private Posicion izquierda;
    private Posicion arriba;
    private Posicion abajo;
    private int id;

    public Posicion obtenerDerecha() {
        return derecha;
    }

    public void asignarDerecha(Posicion derecha) {
        this.derecha = derecha;
    }

    public Posicion obtenerIzquierda() {
        return izquierda;
    }

    public void asignarIzquierda(Posicion izquierda) {
        this.izquierda = izquierda;
    }

    public Posicion obtenerArriba() {
        return arriba;
    }

    public void asignarArriba(Posicion arriba) {
        this.arriba = arriba;
    }

    public Posicion obtenerAbajo() {
        return abajo;
    }

    public void asignarAbajo(Posicion abajo) {
        this.abajo = abajo;
    }

    Posicion(int nuevoId) {
        this.id = nuevoId;
    }

    public int obtenerID() {
        return id;
    }

}
