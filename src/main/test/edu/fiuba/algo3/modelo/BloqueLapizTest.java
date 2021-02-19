package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BloqueLapizTest {
    @Test
    public void seCreaUnBloqueApoyarLapizYAlUsarseDebeCambiarElEstadoDelLapizDelPersonajeAApoyado()
    {
        Bloque bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueApoyarLapiz.ejecutar(personaje);
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void utilizoUnaSecuenciaDeLaFormaLevantarApoyarApoyarYElLapizDebeEstarApoyado()
    {
        Bloque bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        Bloque bloqueLevantarLapiz = new BloqueLapiz(new LapizLevantado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueLevantarLapiz.ejecutar(personaje);
        bloqueApoyarLapiz.ejecutar(personaje);
        bloqueApoyarLapiz.ejecutar(personaje);
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void bloqueApoyarLapizDejaElLapizLevantadoAlEjecutarInvertido() {
        Bloque bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueApoyarLapiz.invertir();
        bloqueApoyarLapiz.ejecutar(personaje);

        assertTrue(personaje.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void bloqueLevantarLapizDejaElLapizApoyadoAlEjecutarInvertido() {
        Bloque bloqueLevantarLapiz = new BloqueLapiz(new LapizLevantado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueLevantarLapiz.invertir();
        bloqueLevantarLapiz.ejecutar(personaje);
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void bloqueLevantarLapizDejaElLapizLevantadoAlInvertirDosVeces() {
        Bloque bloqueLevantarLapiz = new BloqueLapiz(new LapizLevantado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueLevantarLapiz.invertir();
        bloqueLevantarLapiz.invertir();
        bloqueLevantarLapiz.ejecutar(personaje);
        assertTrue(personaje.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void bloqueApoyarLapizDejaElLapizApoyadoAlInvertirDosVeces() {
        Bloque bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(new Posicion(0, 0), lapiz);
        bloqueApoyarLapiz.invertir();
        bloqueApoyarLapiz.invertir();
        bloqueApoyarLapiz.ejecutar(personaje);
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }
}
