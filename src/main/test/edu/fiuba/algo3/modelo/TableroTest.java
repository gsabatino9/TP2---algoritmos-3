package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TableroTest {

    @Test
    public void unPersonajeSeCreaEnElOrigenDelTablero(){
        Tablero tablero = new Tablero();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(0, 0));
    }

   @Test
    public void unPersonajeQueSeMueveALaDerechaSeEncuentraAlLadoDelCentro(){
        Tablero tablero = new Tablero();

        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(1, 0));
    }

    @Test
    public void unPersonajeQueSeMueveALaDerechaYLuegoArribaSeEncuentraCorrectamente(){
        Tablero tablero = new Tablero();

        BloqueMover bloque1 = new BloqueMover(Direccion.obtenerDerecha());
        BloqueMover bloque2 = new BloqueMover(Direccion.obtenerArriba());

        tablero.agregarBloque(bloque1);
        tablero.agregarBloque(bloque2);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(1, 1));
    }

    @Test
    public void unPersonajeQueSeMueveDosVecesALaDerechaApareceDelOtroLadoDelTablero(){
        Tablero tablero = new Tablero();

        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());


        tablero.agregarBloque(bloque);
        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(2, 0));
    }

    @Test
    public void unPersonajeQueSeMueveDosVecesArribaApareceDelOtroLadoDelTablero(){
        Tablero tablero = new Tablero();

        BloqueMover bloque = new BloqueMover(Direccion.obtenerArriba());


        tablero.agregarBloque(bloque);
        tablero.agregarBloque(bloque);
        tablero.realizarSecuencia();

        assertTrue(tablero.personajeSeEncuentraEnPosicion(0, 2));
    }
}
