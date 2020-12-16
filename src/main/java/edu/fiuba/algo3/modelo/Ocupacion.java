package edu.fiuba.algo3.modelo;

public interface Ocupacion {
    boolean estaOcupada();

    Ocupacion cambiarEstado();

    Ocupacion pintar();

    boolean estaPintada();
}
