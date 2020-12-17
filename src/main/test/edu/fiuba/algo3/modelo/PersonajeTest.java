package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {


    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaNoSePinta() {
        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);
        assertFalse(actual.estaPintada());
    }

    @Test
    public void PersonajeBajaElLapizSePintaLaPosicionEnLaQueEstabaAlMoverDerecha() {

        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);
        assertTrue(actual.estaPintada());
    }


    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion(0,0 );

        Personaje personaje = new Personaje(actual);
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion(0,0);

        Personaje personaje = new Personaje(actual);
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertTrue(personaje.devolverPosicion().estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);
        personaje.bajarLapiz();
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertTrue(personaje.devolverPosicion().estaOcupada());
    }


}
