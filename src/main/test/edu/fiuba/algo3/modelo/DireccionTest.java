package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DireccionTest {

    @Test
    public void moverConDireccionDerechaRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion(0, 0);
        Direccion derecha = Direccion.obtenerDerecha();
        assertTrue(derecha.siguientePosicion(posicionActual).equals(new Posicion(1, 0)));
    }

    @Test
    public void moverConDireccionIzquierdaRetornaLaPosicionCorrecta(){
        Posicion posicionActual = new Posicion(0, 0);
        Direccion izquierda = Direccion.obtenerIzquierda();
        assertTrue(izquierda.siguientePosicion(posicionActual).equals(new Posicion(8, 0)));
    }

    @Test
    public void moverConDireccionArribaRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion(0, 0);
        Direccion arriba = Direccion.obtenerArriba();
        assertTrue(arriba.siguientePosicion(posicionActual).equals(new Posicion(0, 1)));
    }

    @Test
    public void moverConDireccionAbajoRetornaLaPosicionCorrecta(){
        Posicion posicionActual = new Posicion(0, 0);
        Direccion abajo = Direccion.obtenerAbajo();
        assertTrue(abajo.siguientePosicion(posicionActual).equals(new Posicion(0, 8)));
    }
}
