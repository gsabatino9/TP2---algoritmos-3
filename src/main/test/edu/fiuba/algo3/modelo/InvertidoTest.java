package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvertidoTest {

    @Test
    public void ejecutarInvertidoVacioLanzaExcepcion() {
        Invertido bloque = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        assertThrows(AlgoritmoVacioException.class, () ->  bloque.ejecutar(personaje));
    }

    // sobre bloqueMover

    @Test
    public void agregarUnBloqueMoverDerechaMueveAlPersonajeEnLaDireccionIzquierda(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Posicion posicionIzquierda = new Posicion(-1, 0);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionIzquierda.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverIzquierdaMueveAlPersonajeEnLaDireccionDerecha(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);
        Posicion posicionDerecha = new Posicion(1, 0);

        bloqueInvertir.agregarBloque(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionDerecha.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverArribaMueveAlPersonajeEnLaDireccionDebajo(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        Posicion posicionAbajo = new Posicion(0, 1);

        bloqueInvertir.agregarBloque(bloqueArriba);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionAbajo.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverAbajoMueveAlPersonajeEnLaDireccionArriba(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion abajo = Direccion.obtenerAbajo();
        BloqueMover bloqueAbajo = new BloqueMover(abajo);
        Posicion posicionArriba = new Posicion(0, -1);

        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionArriba.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverAbajoYMoverDerechaMueveAlPersonajeEnLaDireccionArribaIzquierda(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion abajo = Direccion.obtenerAbajo();
        BloqueMover bloqueAbajo = new BloqueMover(abajo);
        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Posicion posicionArribaIzquierda = new Posicion(-1, -1);

        bloqueInvertir.agregarBloque(bloqueAbajo);
        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionArribaIzquierda.equals(personaje.devolverPosicion()));
    }

    @Test
    public void agregarUnBloqueMoverArribaEIzquierdaMueveAlPersonajeEnLaDireccionAbajoDerecha(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);
        Posicion posicionAbajoDerecha = new Posicion(1, 1);

        bloqueInvertir.agregarBloque(bloqueArriba);
        bloqueInvertir.agregarBloque(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionAbajoDerecha.equals(personaje.devolverPosicion()));
    }

    //termina bloqueMover

    //sobre Lapiz

    @Test
    public void agregarUnBloqueSubirLapizBajaElLapizYPintaElSegmentoQueUneALaPosicionAnterior(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);

        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());
        bloqueInvertir.agregarBloque(bloqueSubirLapiz);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(izquierda);
        assertTrue(dibujo.segmentoEstaPintado(segmento));
    }

    @Test
    public void agregarUnBloqueBajarLapizSubeElLapizYNoPintaElSegmentoQueUneALaPosicionAnterior(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        bloqueInvertir.agregarBloque(bloqueBajarLapiz);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutar(personaje);

        Segmento segmento = posicionInicio.crearSegmento(izquierda);
        assertFalse(dibujo.segmentoEstaPintado(segmento));
    }


    @Test
    public void invertidoConArribaSubirLapizEIzquierdaHaceAbajoBajaLapizDerecha(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);

        bloqueInvertir.agregarBloque(bloqueArriba);
        bloqueInvertir.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        bloqueInvertir.agregarBloque(bloqueIzquierda);
        bloqueInvertir.ejecutar(personaje);
        // Secuencia: (0,0) -> (0,1) -> BAJA LAPIZ -> (1,1)
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(1,1))));


    }
    //sobre Algoritmo


    @Test
    public void InvertirUnAlgoritmoConUnSoloElementoNoModificaLaSecuencia(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        Posicion posicionArriba = new Posicion(0,-1);
        Algoritmo algoritmo = new Algoritmo();
        algoritmo.agregarBloque(bloqueArriba);

        bloqueInvertir.agregarBloque(algoritmo);
        //al ejecutar hara: (0,0) -> (0,1)
        bloqueInvertir.ejecutar(personaje);

        assertTrue(posicionArriba.equals(personaje.devolverPosicion()));
    }



    /*
    * Para poder observar el orden en que ejecuta los bloques utilizamos al lapiz.
    */
    @Test
    public void InvertirUnAlgoritmoConArribaIzquierdaHaceQueSeRecorraLaListaDeAtrasParaAdelanteIzquierdaYLuegoArriba(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);

        BloqueLapiz bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());

        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);

        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueApoyarLapiz);
        algoritmo.agregarBloque(bloqueIzquierda);
        bloqueInvertir.agregarBloque(algoritmo);
        //al ejecutar hara: (0,0) -> (-1,0) -> BAJA LAPIZ -> (-1,-1)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(-1,0))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,-1))));
    }

    @Test
    public void InvertirUnAlgoritmoConSubirLapizIzquierdaBajarLapizArribaDaVueltaLaListaYEjecuta(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));
        algoritmo.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerIzquierda()));
        algoritmo.agregarBloque(new BloqueLapiz(new LapizApoyado()));
        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerAbajo()));

        bloqueInvertir.agregarBloque(algoritmo);
        //al ejecutar hara: (0,0) -> (0,1) -> BAJA LAPIZ -> (-1,1) -> SUBE LAPIZ -> (-1,0)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(-1,1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,1), new Posicion(-1,0))));

    }

    @Test
    public void CombinarAlgoritmoPersonalizadoConBloquesSimples(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));
        algoritmo.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerIzquierda()));
        algoritmo.agregarBloque(new BloqueLapiz(new LapizApoyado()));
        algoritmo.agregarBloque(new BloqueMover(Direccion.obtenerAbajo()));

        bloqueInvertir.agregarBloque(algoritmo);
        bloqueInvertir.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));
        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerIzquierda()));

        //al ejecutar hara: (0,0) -> (0,1) -> BAJA LAPIZ -> (-1,1) -> SUBE LAPIZ -> (-1,0) -> BAJA LAPIZ -> (-1,1) -> (0,1)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(-1,1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,1), new Posicion(-1,0))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,1), new Posicion(0,1))));


    }


    // bloque Repetir


    @Test
    public void bloqueRepeticionDeTresIteracionesAlInvertirDaVueltaSuListaYSeEjecuta(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Repeticion repetir = new Repeticion(3);

        repetir.agregarBloque(new BloqueMover(Direccion.obtenerAbajo()));
        repetir.agregarBloque(new BloqueMover(Direccion.obtenerAbajo()));
        repetir.agregarBloque(new BloqueLapiz(new LapizApoyado()));

        bloqueInvertir.agregarBloque(repetir);
        //al ejecutar hara: (0,0) ->BAJA LAPIZ -> (0,-1) -> (0,-2) -> BAJA LAPIZ -> (0,-3)-> (0,-4)
        bloqueInvertir.ejecutar(personaje);

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(0,2))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,2), new Posicion(0,3))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,3), new Posicion(0,4))));

    }


    @Test
    public void bloqueRepeticionAlInvertirDaVueltaSuListaYSeEjecuta(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);

        BloqueLapiz bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());

        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);

        Repeticion repetir = new Repeticion(2);

        repetir.agregarBloque(bloqueArriba);
        repetir.agregarBloque(bloqueApoyarLapiz);
        repetir.agregarBloque(bloqueIzquierda);
        repetir.agregarBloque(bloqueSubirLapiz);
        bloqueInvertir.agregarBloque(repetir);
        //al ejecutar hara: (0,0) -> SUBE LAPIZ -> (-1,0) -> BAJA LAPIZ -> (-1,-1) -> SUBE LAPIZ -> (-2,-1) -> BAJA LAPIZ -> (-2,-2)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(-1,0))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,-1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-1), new Posicion(-2,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-2,-1), new Posicion(-2,-2))));
    }


    @Test
    public void bloqueInvertirConBloqueRepeticionYBloquesSueltosDaVueltaListaDeInvertirYEjecutaInvertidoLosDemasBloques(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);

        BloqueLapiz bloqueApoyarLapiz = new BloqueLapiz(new LapizApoyado());
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());

        Direccion izquierda = Direccion.obtenerIzquierda();
        BloqueMover bloqueIzquierda = new BloqueMover(izquierda);

        Repeticion repetir = new Repeticion(2);

        repetir.agregarBloque(bloqueArriba);
        repetir.agregarBloque(bloqueApoyarLapiz);
        repetir.agregarBloque(bloqueIzquierda);
        repetir.agregarBloque(bloqueSubirLapiz);


        bloqueInvertir.agregarBloque(repetir);
        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerDerecha()));
        bloqueInvertir.agregarBloque(new BloqueLapiz(new LapizApoyado()));
        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerAbajo()));
        bloqueInvertir.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerDerecha()));


        //al ejecutar hara: (0,0) -> SUBE LAPIZ -> (-1,0) -> BAJA LAPIZ -> (-1,-1) -> SUBE LAPIZ -> (-2,-1) -> BAJA LAPIZ -> (-2,-2)
        //                        -> (-3,-2) -> SUBIR LAPIZ -> (-3,-3) -> BAJAR LAPIZ ->   (-4,-3)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(-1,0))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,-1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-1), new Posicion(-2,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-2,-1), new Posicion(-2,-2))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-2,-2), new Posicion(-3,-2))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-3,-2), new Posicion(-3,-3))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-3,-3), new Posicion(-4,-3))));
    }

    @Test
    public void invertirConMoverDerechaYBloqueRepeticion(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Repeticion repetir = new Repeticion(2);

        repetir.agregarBloque(new BloqueLapiz(new LapizApoyado()));
        repetir.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));
        repetir.agregarBloque(new BloqueLapiz(new LapizLevantado()));
        repetir.agregarBloque(new BloqueMover(Direccion.obtenerArriba()));

        bloqueInvertir.agregarBloque(new BloqueMover(Direccion.obtenerDerecha()));
        bloqueInvertir.agregarBloque(repetir);
        //al ejecutar hara: (0,0) -> (-1,0) -> (-1,-1) -> SUBE LAPIZ -> (-1,-2) -> BAJA LAPIZ -> (-1,-3) -> SUBE LAPIZ -> (-1, -4)-> BAJA LAPIZ
        bloqueInvertir.ejecutar(personaje);


        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(-1,0))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,-1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-1), new Posicion(-1,-2))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-2), new Posicion(-1,-3))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-3), new Posicion(-1,-4))));

    }


    /*
     * EXPLICACION DEL TEST:
     * Un bloqueInvertirAnidado que contiene: 1) Derecha, 2) SubirLapiz, 3) Arriba dentro de otro bloque Invertir.
     * Entonces, en primer lugar: Invertir invierte al bloqueInvertirAnidado -> 1) Arriba, 2) SubirLapiz, 3) Derecha
     * Luego al ejecutar el bloqueInvertirAnidado: 1) Abajo, 2) ApoyarLapiz, 3) Izquierda
     * Entonces si el personaje estaba en la posicion (0,0) ->(0,1)-> BAJA LAPIZ -> (-1,1)
     * */
    @Test
    public void invertirBloqueInvertidoDaVueltaLaListaDeInvertido(){

        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());

        Invertido bloqueInvertir = new Invertido();
        Invertido invertidoAnidado = new Invertido();
        invertidoAnidado.agregarBloque(bloqueDerecha);
        invertidoAnidado.agregarBloque(bloqueSubirLapiz);
        invertidoAnidado.agregarBloque(bloqueArriba);
        bloqueInvertir.agregarBloque(invertidoAnidado);

        bloqueInvertir.ejecutar(personaje);

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(-1,1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));

    }


    @Test
    public void bloqueInvertirConBloqueInvertidoAnidadoYUnBloqueDerechaInvierteLaListaDelAnidadoLaEjecutaInvertidaEInvierteElBloqueDerecha(){

        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());

        Invertido bloqueInvertir = new Invertido();
        Invertido invertidoAnidado = new Invertido();
        invertidoAnidado.agregarBloque(bloqueDerecha);
        invertidoAnidado.agregarBloque(bloqueSubirLapiz);
        invertidoAnidado.agregarBloque(bloqueArriba);

        Direccion derecha2 = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha2 = new BloqueMover(derecha2);


        bloqueInvertir.agregarBloque(invertidoAnidado);
        bloqueInvertir.agregarBloque(bloqueDerecha2);

        bloqueInvertir.ejecutar(personaje);
        // debe hacer: (0,0) -> (0,-1) -> BAJAR LAPIZ -> (-1,1) -> (-2,1)

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(-1,1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,1), new Posicion(-2,1))));

    }


    @Test
    public void tresBloquesInvertidosUnoDentroDelOtroElMasGrandeNoTieneEfectoAlTenerUnaListaDeUnSoloElemento(){

        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Direccion arriba = Direccion.obtenerArriba();
        BloqueMover bloqueArriba = new BloqueMover(arriba);
        BloqueLapiz bloqueSubirLapiz = new BloqueLapiz(new LapizLevantado());

        Invertido bloqueInvertir = new Invertido();
        Invertido invertidoAnidado = new Invertido();
        invertidoAnidado.agregarBloque(bloqueDerecha);
        invertidoAnidado.agregarBloque(bloqueSubirLapiz);
        invertidoAnidado.agregarBloque(bloqueArriba);
        bloqueInvertir.agregarBloque(invertidoAnidado);

        Invertido bloqueInvertirPrincipal = new Invertido();
        bloqueInvertirPrincipal.agregarBloque(bloqueInvertir);
        bloqueInvertirPrincipal.ejecutar(personaje);

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,1), new Posicion(-1,1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,1))));

    }


    @Test
    public void unBloqueInvertirConUnRepeticionVacioNoSePuedeEjecutar(){

        Invertido invertido = new Invertido();
        invertido.agregarBloque(new Repeticion(2));
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        assertThrows(AlgoritmoVacioException.class, () ->  invertido.ejecutar(personaje));
    }

    @Test
    public void unBloqueInvertirSeClonaBien(){
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);
        Invertido invertido = new Invertido();

        BloqueLapiz bloqueBajarLapiz = new BloqueLapiz(new LapizApoyado());
        invertido.agregarBloque(bloqueBajarLapiz);

        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());
        invertido.agregarBloque(bloqueDerecha);

        Invertido clonInvertido = invertido.clonar();

        BloqueMover bloqueDerecha2 = new BloqueMover(Direccion.obtenerDerecha());
        clonInvertido.agregarBloque(bloqueDerecha2);


        Posicion posicionInicioClonado = new Posicion(0, 0);
        Dibujo dibujoClonado = new Dibujo();
        Lapiz lapizClonado = new Lapiz(dibujoClonado);
        Personaje personajeClonado = new Personaje(posicionInicioClonado, lapizClonado);

        clonInvertido.ejecutar(personajeClonado);
        invertido.ejecutar(personaje);

        assertTrue(personaje.devolverPosicion().equals(new Posicion(-1,0)));
        assertTrue(personajeClonado.devolverPosicion().equals(new Posicion(-2,0)));

    }

}