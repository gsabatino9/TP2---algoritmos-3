package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {


    @Test
    public void seAgregaBloqueDerechaBloqueDerechaSeOcupa(){
        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(new Derecha());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertTrue(derecha.estaOcupada());

    }

    @Test
    public void seAgregaBloqueDerechaBloqueActualSeDesocupa(){
        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(new Derecha());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertFalse(actual.estaOcupada());

    }


}
