package edu.fiuba.algo3.modelo;

public interface Observado {

    void agregarObservador(Observador observador);

    void notificarObservadores();
}
