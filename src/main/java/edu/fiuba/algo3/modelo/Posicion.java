package edu.fiuba.algo3.modelo;

public class Posicion{
    private int fila;
    private int columna;


    Posicion(int x, int y){
        this.columna = x;
        this.fila = y;
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() { return columna; }

    public boolean esIgualA(int x, int y) { return (this.columna == x && this.fila == y) ; }

    public boolean equals(Posicion posicion){
        return this.esIgualA(posicion.obtenerColumna(), posicion.obtenerFila());
    }

    public Segmento crearSegmento(Direccion direccion){
        return new Segmento(this, direccion.siguientePosicion(this));
    }

}



