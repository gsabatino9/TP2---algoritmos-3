package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void seAgregaUnSegmentoYSeEncuentraPintado(){
        Posicion posicion = new Posicion(0, 0);
        Direccion direccion = Direccion.obtenerArriba();
        Dibujo dibujo = new Dibujo();

        Segmento segmento = posicion.crearSegmento(direccion);

        dibujo.agregarSegmento(segmento);
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

}
