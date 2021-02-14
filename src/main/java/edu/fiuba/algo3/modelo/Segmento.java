package edu.fiuba.algo3.modelo;

public class Segmento {
    private Posicion posicionInicio;
    private Posicion posicionFin;

    Segmento(Posicion posicion1, Posicion posicion2){
        posicionInicio = posicion1;
        posicionFin = posicion2;
    }

    public void pintar(){
      //pinta visualmente
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
