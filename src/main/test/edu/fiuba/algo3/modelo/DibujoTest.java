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

    @Test
    public void seAgreganMuchosSegmentosYSeEncuentranPintados(){
        Dibujo dibujo = new Dibujo();

        dibujo.agregarSegmento(new Segmento(new Posicion(0,0), new Posicion(0,-1)));
        dibujo.agregarSegmento(new Segmento(new Posicion(1,0), new Posicion(1,-1)));
        dibujo.agregarSegmento(new Segmento(new Posicion(0,4), new Posicion(0,5)));
        dibujo.agregarSegmento(new Segmento(new Posicion(3,5), new Posicion(3,6)));
        dibujo.agregarSegmento(new Segmento(new Posicion(3,4), new Posicion(3,5)));


        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(1,0), new Posicion(1,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,4), new Posicion(0,5))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(3,5), new Posicion(3,6))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(3,4), new Posicion(3,5))));

    }

}
