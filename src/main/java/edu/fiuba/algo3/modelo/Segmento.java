package edu.fiuba.algo3.modelo;

import static java.lang.Math.abs;

public class Segmento {
    private Posicion posicionInicio;
    private Posicion posicionFin;

    Segmento(Posicion posicion1, Posicion posicion2){
        if(abs(posicion1.obtenerColumna() - posicion2.obtenerColumna()) > 1 || abs(posicion1.obtenerFila() - posicion2.obtenerFila()) > 1){
            posicionInicio = posicion2;
        }else{
            posicionInicio = posicion1;
        }
        posicionFin = posicion2;
    }

    public Posicion obtenerInicio(){
        return posicionInicio;
    }

    public Posicion obtenerFin(){
        return posicionFin;
    }

    public boolean equals(Segmento segmento){
        return (posicionInicio.equals(segmento.obtenerInicio()) && posicionFin.equals(segmento.obtenerFin()));
    }
}