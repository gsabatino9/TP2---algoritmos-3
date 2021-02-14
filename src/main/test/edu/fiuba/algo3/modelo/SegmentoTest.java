package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SegmentoTest {
    @Test
    public void SeCreaUnSegmentoConDosPosicionesYLaInicialCoincideConLaOriginal(){
        Posicion pos = new Posicion(0, 0);
        Posicion pos2 = new Posicion(1, 0);

        Segmento segmento = new Segmento(pos, pos2);

        assertTrue(pos.equals(segmento.obtenerInicio()));
    }

    @Test
    public void SeCreaUnSegmentoConDosPosicionesYLaFinalCoincideConLaSegunda(){
        Posicion pos = new Posicion(0, 0);
        Posicion pos2 = new Posicion(1, 0);

        Segmento segmento = new Segmento(pos, pos2);

        assertTrue(pos2.equals(segmento.obtenerFin()));
    }
}
