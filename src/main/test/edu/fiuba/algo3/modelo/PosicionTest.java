package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PosicionTest {
    @Test
    public void APartirDeUnaDireccionSeCreaUnSegmentoCorrectamente(){
        Posicion pos = new Posicion(0, 0);
        Direccion direccion = Direccion.obtenerDerecha();

        Segmento segmento = pos.crearSegmento(direccion);

        assertTrue(pos.equals(segmento.obtenerInicio()));
    }
}
