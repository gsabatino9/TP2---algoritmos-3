package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DireccionTest {

    @Test
    public void moverConDireccionDerechaRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion();
        Posicion derecha = new Posicion();
        posicionActual.agregarDerecha(derecha);

        Derecha direccionDerecha = new Derecha();

        assertSame(direccionDerecha.mover(posicionActual), derecha);
    }

    @Test
    public void moverConDireccionIzquierdaRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion();
        Posicion izquierda = new Posicion();
        posicionActual.agregarIzquierda(izquierda);

        Izquierda direccionIzquierda = new Izquierda();

        assertSame(direccionIzquierda.mover(posicionActual), izquierda);
    }

    @Test
    public void moverConDireccionArribaRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion();
        Posicion arriba = new Posicion();
        posicionActual.agregarArriba(arriba);

        Arriba direccionArriba = new Arriba();

        assertSame(direccionArriba.mover(posicionActual), arriba);
    }

    @Test
    public void moverConDireccionAbajoRetornaLaPosicionCorrecta(){

        Posicion posicionActual = new Posicion();
        Posicion abajo = new Posicion();
        posicionActual.agregarAbajo(abajo);

        Abajo direccionAbajo = new Abajo();

        assertSame(direccionAbajo.mover(posicionActual), abajo);
    }
}
