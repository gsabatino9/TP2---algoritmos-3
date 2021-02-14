package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {

    @Test
    public void UnAlgoritmoConCantidadNegativaLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Algoritmo(-1));
    }

    @Test
    public void UnAlgoritmoConCantidadCeroLanzaUnaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> new Algoritmo(0));
    }

    @Test
    public void crearUnAlgoritmoVacioLanzaExcepcion() {
            Algoritmo algoritmo = new Algoritmo(1);
            Posicion posicionInicio = new Posicion(0, 0);
            Dibujo dibujo = new Dibujo();
            Lapiz lapiz = new Lapiz(dibujo);
            Personaje personaje = new Personaje(posicionInicio, lapiz);

            assertThrows(AlgoritmoVacioException.class, () ->  algoritmo.ejecutar(personaje));
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

        Segmento segmento = posicionInicio.crearSegmento(derecha);
        assertFalse(dibujo.segmentoEstaPintado(segmento));
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

        Segmento segmento = posicionInicio.crearSegmento(derecha);
        assertFalse(dibujo.segmentoEstaPintado(segmento));
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

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerDerecha());
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }


    //Pruebas BloqueRepetir

    @Test
    public void agregarUnBloqueRepetirVacioLanzaExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Algoritmo bloqueRepetir = new Algoritmo(2);
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
        Algoritmo bloqueRepetir = new Algoritmo(3);
        bloqueRepetir.agregarBloque(bloqueBajarLapiz);
        algoritmo.agregarBloque(bloqueRepetir);

        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        algoritmo.agregarBloque(bloqueArriba);

        algoritmo.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerArriba());
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }


    //Pruebas BloquePersonalizado

    @Test
    public void agregarUnBloqueRepetirVacioEnUnoPersonalizadoLanzaExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Algoritmo bloqueRepetir = new Algoritmo(2);
        Algoritmo bloquePersonalizado = new Algoritmo();
        bloquePersonalizado.agregarBloque(bloqueRepetir);

        algoritmo.agregarBloque(bloquePersonalizado);
        assertThrows(AlgoritmoVacioException.class, () ->  algoritmo.ejecutar(personaje));
    }

    @Test
    public void seGuardaUnAlgoritmoPersonalizado() {
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());

        Algoritmo bloquePersonalizado = new Algoritmo();

        bloquePersonalizado.agregarBloque(bloqueBajarLapiz);
        bloquePersonalizado.agregarBloque(bloqueArriba);

        bloquePersonalizado.guardar("Pintar y subir", personaje);
        assertTrue(bloquePersonalizado.algoritmoEstaGuardado("Pintar y subir", personaje));
    }

    @Test
    public void seGuardaUnAlgoritmoPersonalizadoPeroNoSeEjecutaAutomaticamente() {
        Algoritmo algoritmo = new Algoritmo();
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

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerArriba());
        assertFalse(dibujo.segmentoEstaPintado(segmento));
        assertTrue(posicionInicio.equals(personaje.devolverPosicion()));
    }

    @Test
    public void guardarUnAlgoritmoPersonalizadoVacioLanzaUnaExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        assertThrows(AlgoritmoVacioException.class, () ->  algoritmo.guardar("Pintar y subir", personaje));
    }

    @Test
    public void puedoGuardarUnAlgoritmoPersonalizadoYCargarloAMiAlgoritmo() {
        Algoritmo algoritmo = new Algoritmo();
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
        algoritmo.agregarBloquePersonalizado("Pintar y subir", personaje);

        algoritmo.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(Direccion.obtenerArriba());
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

    @Test
    public void noPuedoCargarUnAlgoritmoQueNoGuarde() {
        Algoritmo algoritmo = new Algoritmo();
        Algoritmo algoritmoPersonalizado = new Algoritmo();

        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());

        algoritmoPersonalizado.agregarBloque(bloqueBajarLapiz);
        algoritmoPersonalizado.agregarBloque(bloqueArriba);

        assertThrows(BloquePersonalizadoNoExisteException.class, () ->  algoritmo.agregarBloquePersonalizado("Pintar y subir", personaje));
    }


    //Pruebas de integración
    @Test
    public void bajarElLapizYMoverseVariasVecesPintaLasPosicionesCorrectas(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Posicion posicion2 = new Posicion(1, 1);
        Posicion posicionMedia = new Posicion(1, 0);

        Segmento segmento1 = posicionInicio.crearSegmento(Direccion.obtenerDerecha());
        Segmento segmento2 = posicion2.crearSegmento(Direccion.obtenerIzquierda());

        Segmento segmentoMedio = posicionMedia.crearSegmento(Direccion.obtenerArriba());

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


        assertTrue(dibujo.segmentoEstaPintado(segmento1));
        assertTrue(dibujo.segmentoEstaPintado(segmento2));
        assertFalse(dibujo.segmentoEstaPintado(segmentoMedio));
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

        Posicion posicionIntermedia = new Posicion(-1, 0);

        Segmento segmento1 = posicionInicio.crearSegmento(Direccion.obtenerIzquierda());
        Segmento segmento2 = posicionIntermedia.crearSegmento(Direccion.obtenerIzquierda());


        assertTrue(dibujo.segmentoEstaPintado(segmento1));
        assertTrue(dibujo.segmentoEstaPintado(segmento2));
    }

    @Test
    public void mezclarBloquesRepeticionConBloquesPersonalizadosYBloquesSimpleFuncionaCorrectamente(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        //bloque simple
        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        algoritmo.agregarBloque(bloqueBajarLapiz);

        //bloque que combina BloqueRepetir y BloquePersonalizado
        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo bloquePersonalizado1 = new Algoritmo(3);
        bloquePersonalizado1.agregarBloque(bloqueArriba);
        bloquePersonalizado1.agregarBloque(bloqueDerecha);
        bloquePersonalizado1.guardar("Arriba y a la derecha", personaje);

        algoritmo.agregarBloquePersonalizado("Arriba y a la derecha", personaje);

        //bloqueRepetir
        Algoritmo bloqueRepetir = new Algoritmo(2);
        bloqueRepetir.agregarBloque(bloqueArriba);

        algoritmo.agregarBloque(bloqueRepetir);

        //bloquePersonalizado
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());
        Algoritmo bloquePersonalizado2 = new Algoritmo();
        bloquePersonalizado2.agregarBloque(bloqueDerecha);
        bloquePersonalizado2.agregarBloque(bloqueSubirLapiz);

        bloquePersonalizado2.guardar("Mover a derecha y levantar lapiz", personaje);
        algoritmo.agregarBloquePersonalizado("Mover a derecha y levantar lapiz", personaje);


        algoritmo.ejecutar(personaje);

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(posicionInicio, new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(1,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(1,1), new Posicion(1,2))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(2,2), new Posicion(2,3))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(2,3), new Posicion(3,3))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(3,3), new Posicion(3,4))));
    }

}
