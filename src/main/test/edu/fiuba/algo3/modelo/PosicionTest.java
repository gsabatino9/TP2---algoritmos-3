package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PosicionTest {

    @Test
    public void unaPosicionSeCreaConEstadoDesocupado(){
        Posicion unaPosicion = new Posicion();
        assertEquals(false, unaPosicion.estaOcupada());
    }

    @Test
    public void unaPosicionQueSeCambiaDeEstadoTieneEstadoOcupado(){
        Posicion unaPosicion = new Posicion();
        unaPosicion.cambiarEstado();

        assertEquals(true, unaPosicion.estaOcupada());
    }

    @Test
    public void cambiarDosVecesDeEstadoNoProduceCambios(){
        Posicion unaPosicion = new Posicion();
        unaPosicion.cambiarEstado();
        unaPosicion.cambiarEstado();

        assertEquals(false, unaPosicion.estaOcupada());
    }
}
