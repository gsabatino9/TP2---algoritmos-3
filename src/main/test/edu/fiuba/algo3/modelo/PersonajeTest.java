package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {


    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaNoSePinta() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);

        Derecha direccion = new Derecha();
        personaje.mover(direccion);
        assertFalse(actual.estaPintada());
    }

    @Test
    public void PersonajeBajaElLapizSePintaLaPosicionEnLaQueEstabaAlMoverDerecha() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Derecha direccion = new Derecha();
        personaje.mover(direccion);
        assertTrue(actual.estaPintada());
    }


    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        Derecha direccion = new Derecha();
        personaje.mover(direccion);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        Derecha direccion = new Derecha();
        personaje.mover(direccion);

        assertTrue(derecha.estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Derecha direccion = new Derecha();
        personaje.mover(direccion);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion();
        Posicion derecha = new Posicion();
        actual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Derecha direccion = new Derecha();
        personaje.mover(direccion);

        assertTrue(derecha.estaOcupada());
    }



}
