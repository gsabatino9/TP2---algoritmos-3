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
        Direccion direccion = Direccion.obtenerArriba();

        Lapiz lapiz = new Lapiz(dibujo);
        lapiz.cambiarEstado(new LapizApoyado());

        Segmento segmento = pos.crearSegmento(direccion);
        lapiz.pintar(segmento);
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

    @Test
    public void elLapizLevantadoNoPinta() {
        Dibujo dibujo = new Dibujo();
        Posicion pos = new Posicion(0, 0);
        Direccion direccion = Direccion.obtenerArriba();
        Segmento segmento = pos.crearSegmento(direccion);

        Lapiz lapiz = new Lapiz(dibujo);
        lapiz.pintar(segmento);
        assertFalse(dibujo.segmentoEstaPintado(segmento));
    }

}

