package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {

    @Test
    public void unaPosicionSeCreaConEstadoDesocupado(){
        Posicion unaPosicion = new Posicion();
        assertFalse(unaPosicion.estaOcupada());
    }

    @Test
    public void unaPosicionQueSeCambiaDeEstadoTieneEstadoOcupado(){
        Posicion unaPosicion = new Posicion();
        unaPosicion.cambiarEstado();

        assertTrue(unaPosicion.estaOcupada());
    }

    @Test
    public void cambiarDosVecesDeEstadoNoProduceCambios(){
        Posicion unaPosicion = new Posicion();
        unaPosicion.cambiarEstado();
        unaPosicion.cambiarEstado();

        assertFalse(unaPosicion.estaOcupada());
    }

    @Test
    public void unaPosicionConEstadoDesocupadoNoSePinta(){
        Posicion unaPosicion = new Posicion();

        unaPosicion.pintar();

        assertFalse(unaPosicion.estaPintada());
    }

    @Test
    public void unaPosicionConEstadoOcupadoSePinta(){
        Posicion unaPosicion = new Posicion();
        unaPosicion.cambiarEstado();

        unaPosicion.pintar();

        assertTrue(unaPosicion.estaPintada());
    }

    @Test
    public void seAgregaUnaPosicionADerechaCorrectamente(){
        Posicion unaPosicion = new Posicion();
        Posicion posicionDerecha = new Posicion();
        unaPosicion.agregarDerecha(posicionDerecha);

        assertSame(unaPosicion.derecha(), posicionDerecha);
    }

    @Test
    public void seAgregaUnaPosicionAIzquierdaCorrectamente(){
        Posicion unaPosicion = new Posicion();
        Posicion posicionIzquierda = new Posicion();
        unaPosicion.agregarIzquierda(posicionIzquierda);

        assertSame(unaPosicion.izquierda(), posicionIzquierda);

    }

}
