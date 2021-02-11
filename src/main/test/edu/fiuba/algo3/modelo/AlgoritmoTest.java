package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.desktop.SystemEventListener;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {


    @Test
    public void seCreaUnAlgoritmoPeroSinBloquesElPersonajeNoSeMueve(){
            Algoritmo algoritmo = new Algoritmo(1);
            Posicion posicionInicio = new Posicion(0, 0);
            Dibujo dibujo = new Dibujo();
            Lapiz lapiz = new Lapiz(dibujo);
            Personaje personaje = new Personaje(posicionInicio, lapiz);
            algoritmo.ejecutar(personaje);

            assertEquals(posicionInicio, personaje.devolverPosicion());
        }

    @Test
    public void seCreaUnAlgoritmoPeroSinBloquesElPersonajeNoSeBajaElLapiz(){
        Algoritmo algoritmo = new Algoritmo(1);
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);
        algoritmo.ejecutar(personaje);

        assertFalse(dibujo.posicionEstaPintada(personaje.devolverPosicion()));
    }

    @Test
     public void agregarUnBloqueMoverMueveAlPersonajeEnLaDireccionCorrecta(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Posicion posicionDerecha = new Posicion(1, 0);

        algoritmo.agregarBloque(bloqueDerecha);
        algoritmo.ejecutar(personaje);

        assertTrue(posicionDerecha.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverMueveAlPersonajePeroNoPintaLaPosicionAnterior(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);

        algoritmo.agregarBloque(bloqueDerecha);
        algoritmo.ejecutar(personaje);

        assertFalse(dibujo.posicionEstaPintada(posicionInicio));
    }

    @Test
    public void agregarUnBloqueMoverMueveAlPersonajePeroNoPintaLaPosicionActual(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);

        algoritmo.agregarBloque(bloqueDerecha);
        algoritmo.ejecutar(personaje);

        assertFalse(dibujo.posicionEstaPintada(personaje.devolverPosicion()));
    }

    @Test
    public void bajarElLapizNoPintaElBloque(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);


        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);
        algoritmo.ejecutar(personaje);

        assertFalse(dibujo.posicionEstaPintada(personaje.devolverPosicion()));
    }

    @Test
    public void bajarElLapizYMoversePintaElBloqueAnterior(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());
        algoritmo.agregarBloque(bloqueDerecha);

        algoritmo.ejecutar(personaje);

        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
    }

    @Test
    public void agregarUnBloqueMoverConRepeticion2MueveAlPersonajeCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Algoritmo bloqueRepetir = new Algoritmo(2);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionFinal = new Posicion(0, 2);
        assertTrue(posicionFinal.equals(personaje.devolverPosicion()));
    }

    @Test
    public void bajarElLapizYMoverConRepeticion2PintaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Algoritmo bloqueRepetir = new Algoritmo(2);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionFinal = new Posicion(0, 1);
        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
        assertTrue(dibujo.posicionEstaPintada(posicionFinal));
    }

    @Test
    public void agregarUnBloqueMoverConRepeticion3MueveAlPersonajeCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Algoritmo bloqueRepetir = new Algoritmo(3);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionFinal = new Posicion(0, 3);
        assertTrue(posicionFinal.equals(personaje.devolverPosicion()));
    }

    @Test
    public void bajarElLapizYMoverConRepeticion3PintaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Algoritmo bloqueRepetir = new Algoritmo(3);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionFinal = new Posicion(0, 2);
        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
        assertTrue(dibujo.posicionEstaPintada(posicionIntermedia));
        assertTrue(dibujo.posicionEstaPintada(posicionFinal));
    }

    @Test
    public void bajarConRepeticionYDespuesSubirFuncionaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Algoritmo bloqueRepetir = new Algoritmo(3);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueAbajo = new BloqueMover(Direccion.obtenerAbajo());
        algoritmo.agregarBloque(bloqueAbajo);
        algoritmo.ejecutar(personaje);

        Posicion posicionFinal = new Posicion(0, 2);
        assertTrue(posicionFinal.equals(personaje.devolverPosicion()));
    }

    @Test
    public void bajarElLapizConRepeticion2YDespuesMoversePintaCorrecta(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        Algoritmo bloqueRepetir = new Algoritmo(2);
        bloqueRepetir.agregarBloque(bloqueBajarLapiz);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.ejecutar(personaje);

        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
    }

    @Test
    public void bajarElLapizConRepeticion3YDespuesMoversePintaCorrecta(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        Algoritmo bloqueRepetir = new Algoritmo(3);
        bloqueRepetir.agregarBloque(bloqueBajarLapiz);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.ejecutar(personaje);

        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
    }



    //Pruebas de integración
    @Test
    public void bajarElLapizYMoverseVariasVecesPintaLasPosicionesCorrectas(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Posicion posicionArribaDerecha = new Posicion(1, 1);
        Posicion posicionArribaIzquierda = new Posicion(0, 1);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());
        algoritmo.agregarBloque(bloqueDerecha);

        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());
        algoritmo.agregarBloque(bloqueSubirLapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueIzquierda = new BloqueMover(Direccion.obtenerIzquierda());
        algoritmo.agregarBloque(bloqueIzquierda);

        algoritmo.ejecutar(personaje);


        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
        assertTrue(dibujo.posicionEstaPintada(posicionArribaDerecha));
        assertTrue(posicionArribaIzquierda.equals(personaje.devolverPosicion()));
    }

    @Test
    public void pintarConRepeticionYDespuesVolverPintaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueIzquierda = new BloqueMover(Direccion.obtenerIzquierda());

        Algoritmo bloqueRepetir = new Algoritmo(2);
        bloqueRepetir.agregarBloque(bloqueIzquierda);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());
        algoritmo.agregarBloque(bloqueDerecha);

        algoritmo.ejecutar(personaje);

        Posicion posicionIntermedia = new Posicion(-2, 0);
        Posicion posicionFinal = new Posicion(-1, 0);
        assertTrue(dibujo.posicionEstaPintada(posicionInicio));
        assertTrue(dibujo.posicionEstaPintada(posicionIntermedia));
        assertTrue(dibujo.posicionEstaPintada(posicionFinal));
        assertTrue(posicionFinal.equals(personaje.devolverPosicion()));
    }

    @Test
    public void UnAlgoritmoConCantidadNegativaLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Algoritmo(-1));
    }

    @Test
    public void UnAlgoritmoConCantidadCeroLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Algoritmo(0));
    }

}
