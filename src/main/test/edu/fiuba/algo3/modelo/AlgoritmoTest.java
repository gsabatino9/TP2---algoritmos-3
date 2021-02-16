package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {



    @Test
    public void crearUnAlgoritmoVacioLanzaExcepcion() {
        Algoritmo algoritmo = new Algoritmo();
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





    //Pruebas BloquePersonalizado

    @Test
    public void agregarUnBloqueRepetirVacioEnUnoPersonalizadoLanzaExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Repeticion bloqueRepetir = new Repeticion(2);
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

        Repeticion bloqueRepetir = new Repeticion(2);
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

        Algoritmo bloquePersonalizado1 = new Algoritmo();
        Repeticion bloqueRepetir = new Repeticion(3);

        bloqueRepetir.agregarBloque(bloqueArriba);
        bloqueRepetir.agregarBloque(bloqueDerecha);
        bloquePersonalizado1.agregarBloque(bloqueRepetir);
        bloquePersonalizado1.guardar("Arriba y a la derecha", personaje);

        algoritmo.agregarBloquePersonalizado("Arriba y a la derecha", personaje);

        //bloqueRepetir
        Repeticion bloqueRepetir2 = new Repeticion(2);
        bloqueRepetir2.agregarBloque(bloqueArriba);

        algoritmo.agregarBloque(bloqueRepetir2);

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
