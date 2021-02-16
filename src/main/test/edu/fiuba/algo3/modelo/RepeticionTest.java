package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeticionTest {


    @Test
    public void UnRepeticionConCantidadNegativaLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Repeticion(-1));
    }

    @Test
    public void UnRepeticionConCantidadCeroLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Repeticion(0));
    }

    @Test
    public void agregarUnBloqueRepetirVacioLanzaExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Repeticion bloqueRepetir = new Repeticion(2);
        algoritmo.agregarBloque(bloqueRepetir);

        assertThrows(AlgoritmoVacioException.class, () ->  algoritmo.ejecutar(personaje));
    }


    @Test
    public void agregarUnBloqueMoverConRepeticion2MueveAlPersonajeCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Repeticion bloqueRepetir = new Repeticion(2);
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
        Repeticion bloqueRepetir = new Repeticion(2);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionFinal = new Posicion(0, 1);

        Segmento segmento = new Segmento(posicionInicio, posicionFinal);
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

    @Test
    public void agregarUnBloqueMoverConRepeticion3MueveAlPersonajeCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Repeticion bloqueRepetir = new Repeticion(3);
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
        Repeticion bloqueRepetir = new Repeticion(3);
        bloqueRepetir.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueRepetir);
        algoritmo.ejecutar(personaje);

        Posicion posicionIntermedia = new Posicion(0, 1);
        Posicion posicionFinal = new Posicion(0, 2);

        Segmento segmento1 = new Segmento(posicionInicio, posicionIntermedia);
        assertTrue(dibujo.segmentoEstaPintado(segmento1));

        Segmento segmento2 = new Segmento(posicionIntermedia, posicionFinal);
        assertTrue(dibujo.segmentoEstaPintado(segmento2));
    }

    @Test
    public void bajarConRepeticionYDespuesSubirFuncionaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        Repeticion bloqueRepetir = new Repeticion(3);
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
        Repeticion bloqueRepetir = new Repeticion(3);
        bloqueRepetir.agregarBloque(bloqueBajarLapiz);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerArriba());
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

    @Test
    public void bajarElLapizConRepeticion3YDespuesMoversePintaCorrecta(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        Repeticion bloqueRepetir = new Repeticion(3);
        bloqueRepetir.agregarBloque(bloqueBajarLapiz);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerArriba());
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

}
