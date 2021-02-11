package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueMoverTest {

    @Test
    public void seCreaUnBloqueMoverConDireccionADerechaYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion(0,0);
        Lapiz lapiz = new Lapiz(new Dibujo());
        Personaje personaje = new Personaje(posicionActual, lapiz);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        bloque.ejecutar(personaje);
        Posicion derecha = new Posicion(1,0);
        assertTrue(personaje.devolverPosicion().equals(derecha));
    }

    @Test
    public void seCreaUnBloqueMoverConDireccionAIzquierdaYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion(0,0);
        Lapiz lapiz = new Lapiz(new Dibujo());
        Personaje personaje = new Personaje(posicionActual, lapiz);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerIzquierda());

        bloque.ejecutar(personaje);
        Posicion izquierda = new Posicion(-1,0);
        assertTrue(personaje.devolverPosicion().equals(izquierda));
    }

    @Test
    public void seCreaUnBloqueMoverConDireccionArribaYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion(0,0);
        Lapiz lapiz = new Lapiz(new Dibujo());
        Personaje personaje = new Personaje(posicionActual, lapiz);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerArriba());

        bloque.ejecutar(personaje);
        Posicion arriba = new Posicion(0,1);
        assertTrue(personaje.devolverPosicion().equals(arriba));
    }

    @Test
    public void seCreaUnBloqueMoverConDireccionAbajoYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion(0,0);
        Lapiz lapiz = new Lapiz(new Dibujo());
        Personaje personaje = new Personaje(posicionActual, lapiz);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerAbajo());

        bloque.ejecutar(personaje);
        Posicion abajo = new Posicion(0,-1);
        assertTrue(personaje.devolverPosicion().equals(abajo));
    }

}
