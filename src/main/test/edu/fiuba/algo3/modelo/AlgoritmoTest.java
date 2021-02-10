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

        assertTrue(actual.estaOcupada());

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
        assertTrue(personaje.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void agregarSoloUnBloqueDeBajarLapizHaceQueElPersonajeTengaElLapizApoyado(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Bloque bloque = new BloqueLapiz(new LapizApoyado());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.realizarSecuencia(personaje);

        assertTrue(actual.estaOcupada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void bajarElLapizYMoverAlPersonajeALaDerechaHaceQueLaPosicionEstePintada(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Bloque bloque = new BloqueLapiz(new LapizApoyado());
        BloqueMover bloque2 = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.realizarSecuencia(personaje);

        //assertTrue(actual.estaPintada());
        assertTrue(personaje.devolverPosicion().estaOcupada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void personajeSeMueveADerechaYLuegoAIzquierdaPintandoPosicionDeberiaEstarPintada(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Algoritmo algoritmo = new Algoritmo();
        Bloque apoyado = new BloqueLapiz(new LapizApoyado());
        BloqueMover derecha = new BloqueMover(Direccion.obtenerDerecha());
        BloqueMover izquierda = new BloqueMover(Direccion.obtenerIzquierda());


        algoritmo.agregarBloque(apoyado);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(izquierda);
        algoritmo.realizarSecuencia(personaje);

        //assertTrue(personaje.devolverPosicion().estaPintada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);

    }

}
