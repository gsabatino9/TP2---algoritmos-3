package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TableroTest {

    @Test
    public void unPersonajeSeCreaEnElCentroDelTablero(){
        Tablero tablero = new Tablero();

        assertEquals(tablero.posicionDelPersonaje(), tablero.obtenerPosicion(1, 1));
    }

    @Test
    public void unPersonajeQueSeMueveALaDerechaSeEncuentraAlLadoDelCentro(){
        Tablero tablero = new Tablero();

        Derecha direccion = new Derecha();
        BloqueMover bloque = new BloqueMover(direccion);

        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertEquals(tablero.posicionDelPersonaje(), tablero.obtenerPosicion(1, 2));
    }

    @Test
    public void unPersonajeQueSeMueveALaDerechaYLuegoArribaSeEncuentraCorrectamente(){
        Tablero tablero = new Tablero();

        Derecha direccion1 = new Derecha();
        BloqueMover bloque1 = new BloqueMover(direccion1);

        Arriba direccion2 = new Arriba();
        BloqueMover bloque2 = new BloqueMover(direccion2);

        tablero.agregarBloque(bloque1);
        tablero.agregarBloque(bloque2);
        tablero.realizarSecuencia();

        assertEquals(tablero.posicionDelPersonaje(), tablero.obtenerPosicion(0, 2));
    }
}
