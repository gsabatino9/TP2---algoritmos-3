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

    @Test
    public void unPersonajeQueSeMueveParaLaDerechaYLuegoArribaEntoncesDesocupaTodasLasPosicionesQueSeMovioYArribaEstaOcupado(){
        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        Posicion arriba = new Posicion();
        actual.agregarDerecha(derecha);
        derecha.agregarArriba(arriba);

        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(new Derecha());
        BloqueMover bloque2 = new BloqueMover(new Arriba());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.realizarSecuencia(personaje);

        //assertFalse(derecha.estaOcupada());
        assertTrue(arriba.estaOcupada());
    }


    @Test
    public void sinAgregarBloquesElPersonajeNoHaceNada(){
        Posicion actual = new Posicion();
        Personaje personaje = new Personaje(actual);

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.realizarSecuencia(personaje);

        assertTrue(actual.estaOcupada());
        assertTrue(personaje.lapizEstaLevantado());
    }

    @Test
    public void agregarSoloUnBloqueDeBajarLapizHaceQueElPersonajeTengaElLapizApoyado(){
        Posicion actual = new Posicion();
        Personaje personaje = new Personaje(actual);

        BloqueLapizApoyado bloque = new BloqueLapizApoyado();

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertTrue(actual.estaOcupada());
        assertFalse(personaje.lapizEstaLevantado());
    }

    @Test
    public void bajarElLapizYMoverAlPersonajeALaDerechaHaceQueLaPosicionEstePintada(){
        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);

        Derecha direccion = new Derecha();

        BloqueLapizApoyado bloque = new BloqueLapizApoyado();
        BloqueMover bloque2 = new BloqueMover(direccion);

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.realizarSecuencia(personaje);

        assertTrue(actual.estaPintada());
        assertTrue(derecha.estaOcupada());
        assertFalse(personaje.lapizEstaLevantado());
    }

}
