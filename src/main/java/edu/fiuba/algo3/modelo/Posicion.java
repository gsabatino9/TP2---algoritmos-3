package edu.fiuba.algo3.modelo;

import static java.lang.Math.abs;

public class Posicion{
    private int fila;
    private int columna;
    private static int filaMax = 9;
    private static int columnaMax = 9;

    public Posicion(int x, int y){
        this.columna = (x + columnaMax) % columnaMax;
        this.fila = (y + filaMax) % filaMax;
    }

    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() { return columna; }

    private boolean esIgualA(int x, int y) { return (abs(this.columna - x) % columnaMax == 0 && abs(this.fila - y) % filaMax == 0) ; }

    public boolean equals(Posicion posicion){
        return posicion.esIgualA(columna,fila);
    }

    public Segmento crearSegmento(Direccion direccion){
        return new Segmento(this, direccion.siguientePosicion(this));
    }

}



