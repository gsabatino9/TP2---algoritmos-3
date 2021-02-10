package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void alAgregarUnaSolaPosicionEstaSeEncuentraPintada(){
        Posicion posicion = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();

        dibujo.agregarPosicion(posicion);
        assertTrue(dibujo.posicionEstaPintada(posicion));
    }

    @Test
    public void unaPosicionNoAgregadaNoSeEncuentraPintada(){
        Posicion posicion1 = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(1, 0);
        Dibujo dibujo = new Dibujo();

        dibujo.agregarPosicion(posicion1);
        assertFalse(dibujo.posicionEstaPintada(posicion2));
    }

    @Test
    public void todasLasPosicionesAgregadasSeEncuentranPintadas(){
        Posicion posicion1 = new Posicion(0, 0);
        Posicion posicion2 = new Posicion(1, 0);
        List<Posicion> posiciones = new ArrayList<Posicion>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);

        Dibujo dibujo = new Dibujo();

        dibujo.agregarPosicion(posicion1);
        dibujo.agregarPosicion(posicion2);
        assertTrue(dibujo.posicionesEstanPintadas(posiciones));
    }
}
