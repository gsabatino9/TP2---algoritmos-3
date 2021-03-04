package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

        Posicion posicionFinal = new Posicion(0, -2);
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

        Posicion posicionFinal = new Posicion(0, -1);

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

        Posicion posicionFinal = new Posicion(0, -3);
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

        Posicion posicionIntermedia = new Posicion(0, -1);
        Posicion posicionFinal = new Posicion(0, -2);

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

        Posicion posicionFinal = new Posicion(0, -2);
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


    @Test
    public void unBloqueRepetirSeClonaBien(){
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);
        Repeticion repeticion = new Repeticion(2);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        repeticion.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());
        repeticion.agregarBloque(bloqueDerecha);

        Repeticion clonRepeticion = repeticion.clonar();

        BloqueMover bloqueDerecha2 = new BloqueMover(Direccion.obtenerDerecha());
        clonRepeticion.agregarBloque(bloqueDerecha2);


        Posicion posicionInicioClonado = new Posicion(0, 0);
        Dibujo dibujoClonado = new Dibujo();
        Lapiz lapizClonado = new Lapiz(dibujoClonado);
        Personaje personajeClonado = new Personaje(posicionInicioClonado, lapizClonado);

        clonRepeticion.ejecutar(personajeClonado);
        repeticion.ejecutar(personaje);

        assertTrue(personaje.devolverPosicion().equals(new Posicion(2,0)));
        assertTrue(personajeClonado.devolverPosicion().equals(new Posicion(4,0)));

    }

    @Test
    public void unBloqueRepeticionConUnBloqueRepeticionVacioNoEsEjecutable(){
        Repeticion repeticion = new Repeticion(2);
        Repeticion bloqueRepetir = new Repeticion(2);
        repeticion.agregarBloque(bloqueRepetir);

        assertThrows(AlgoritmoVacioException.class, () ->  repeticion.esEjecutable());
    }

    @Test
    public void unBloqueRepeticionAlInvertirSeEjecutaLaListaDadaVuelta(){
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Repeticion repetir = new Repeticion(2);

        repetir.agregarBloque(new BloqueLapiz(new LapizApoyado()));
        repetir.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));
        repetir.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        repetir.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));

        //al ejecutar hara: (0,0) -> (0,-1) -> LEVANTA LAPIZ -> (0,-2) -> APOYA LAPIZ -> (0,-3) -> LEVANTA LAPIZ -> (0,-4) -> APOYA LAPIZ
        repetir.invertir();
        repetir.ejecutar(personaje);


        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,-1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-1), new Posicion(0,-2))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-2), new Posicion(0,-3))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-3), new Posicion(0,-4))));

    }

    @Test
    public void agregarBloquePersonalizadoABloqueRepeticion() throws BloquePersonalizadoYaExisteException {

        Repeticion repetir = new Repeticion(2);
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());

        Algoritmo algoritmoPersonalizado = new Algoritmo();
        algoritmoPersonalizado.agregarBloque(bloqueBajarLapiz);
        algoritmoPersonalizado.agregarBloque(bloqueArriba);

        algoritmoPersonalizado.guardar("Pintar y subir", personaje);
        repetir.agregarBloquePersonalizado("Pintar y subir", personaje);

        repetir.ejecutar(personaje);

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-1), new Posicion(0,-2))));
        
    }

}
