package edu.fiuba.algo3.modelo;

public class Posicion{
    private Ocupacion estado;
    private int fila;
    private int columna;


    Posicion(int x, int y){
        this.estado = new DesocupadoSinPintar();
        this.columna = x;
        this.fila = y;
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() { return columna; }

    public boolean esIgualA(int x, int y) { return (this.columna == x && this.fila == y) ; }

    public void cambiarEstado(){
        this.estado = estado.cambiarEstado();
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



