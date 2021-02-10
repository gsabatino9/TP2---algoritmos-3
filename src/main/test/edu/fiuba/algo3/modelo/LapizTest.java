package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LapizTest {

    @Test
    public void unLapizSeCreaLevantado(){
        Lapiz lapiz = new Lapiz(new Dibujo());
        assertTrue(lapiz.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void lapizSeCreaLevantadoAsiQueAlCambiarElEstadoElLapizBaja(){
        Lapiz lapiz = new Lapiz(new Dibujo());
        lapiz.cambiarEstado(new LapizApoyado());
        assertTrue(lapiz.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void lapizSeCreaLevantadoLeCambioElEstadoDosVecesDebeEstarLevantado() {
        Lapiz lapiz = new Lapiz(new Dibujo());
        lapiz.cambiarEstado(new LapizApoyado());
        lapiz.cambiarEstado(new LapizLevantado());
        assertTrue(lapiz.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void elLapizApoyadoPinta() {
        Dibujo dibujo = new Dibujo();
        Posicion pos = new Posicion(0, 0);
        Lapiz lapiz = new Lapiz(dibujo);
        lapiz.cambiarEstado(new LapizApoyado());
        lapiz.pintar(pos);
        assertTrue(dibujo.posicionEstaPintada(pos));
    }

    @Test
    public void elLapizLevantadoNoPinta() {
        Dibujo dibujo = new Dibujo();
        Posicion pos = new Posicion(0, 0);
        Lapiz lapiz = new Lapiz(dibujo);
        lapiz.pintar(pos);
        assertFalse(dibujo.posicionEstaPintada(pos));
    }

}

