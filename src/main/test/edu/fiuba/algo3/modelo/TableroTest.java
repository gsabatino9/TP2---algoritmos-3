package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TableroTest {

    @Test
    public void unPersonajeSeCreaEnElCentroDelTablero(){
        Tablero tablero = new Tablero();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(1, 1));
    }

    @Test
    public void unPersonajeQueSeMueveALaDerechaSeEncuentraAlLadoDelCentro(){
        Tablero tablero = new Tablero();

        Derecha direccion = new Derecha();
        BloqueMover bloque = new BloqueMover(direccion);

        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(1, 2));
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

        assertTrue(tablero.personajeSeEncuentraEnPosicion(0, 2));
    }

    @Test
    public void unPersonajeQueSeMueveDosVecesALaDerechaApareceDelOtroLadoDelTablero(){
        Tablero tablero = new Tablero();

        Derecha direccion = new Derecha();
        BloqueMover bloque = new BloqueMover(direccion);


        tablero.agregarBloque(bloque);
        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(1, 0));
    }

    @Test
    public void unPersonajeQueSeMueveDosVecesArribaApareceDelOtroLadoDelTablero(){
        Tablero tablero = new Tablero();

        Arriba direccion = new Arriba();
        BloqueMover bloque = new BloqueMover(direccion);


        tablero.agregarBloque(bloque);
        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(2, 1));
    }
}
