package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {

    @Test
    public void seAgregaBloqueDerechaBloqueDerechaSeOcupa(){
        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertTrue(personaje.devolverPosicion().estaOcupada());

    }

    @Test
    public void seAgregaBloqueDerechaBloqueActualSeDesocupa(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertFalse(actual.estaOcupada());

    }

    @Test
    public void unPersonajeQueSeMueveParaLaDerechaYLuegoArribaEntoncesArribaEstaOcupado(){
        Posicion actual = new Posicion(0,0 );

        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());
        BloqueMover bloque2 = new BloqueMover(Direccion.obtenerArriba());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.realizarSecuencia(personaje);
        assertTrue(personaje.devolverPosicion().estaOcupada());
    }


    @Test
    public void sinAgregarBloquesElPersonajeNoHaceNada(){
        Posicion actual = new Posicion(0,0 );
        Personaje personaje = new Personaje(actual);

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.realizarSecuencia(personaje);

        assertTrue(actual.estaOcupada());
        assertTrue(personaje.lapizEstaLevantado());
    }

    /*@Test
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
    }*/
}
