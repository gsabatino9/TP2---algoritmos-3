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
        Posicion posicionAbajo = new Posicion(0, -1);

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
        Posicion posicionArriba = new Posicion(0, 1);

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
        Posicion posicionArribaIzquierda = new Posicion(-1, 1);

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
        Posicion posicionAbajoDerecha = new Posicion(1, -1);

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

    //sobre Algoritmo

    /*
    * Para poder observar el orden en que ejecuta los bloques utilizamos al lapiz.
    * */
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
        Posicion posicionAbajoDerecha = new Posicion(1, -1);


        Algoritmo algoritmo = new Algoritmo();

        algoritmo.agregarBloque(bloqueArriba);
        algoritmo.agregarBloque(bloqueApoyarLapiz);
        algoritmo.agregarBloque(bloqueIzquierda);
        bloqueInvertir.agregarBloque(algoritmo);
        //al ejecutar hara: (0,0) -> (-1,0) -> BAJA LAPIZ -> (-1,1)
        bloqueInvertir.ejecutar(personaje);

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(-1,0))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,0), new Posicion(-1,1))));
    }


    /*
     * EXPLICACION DEL TEST:
     * Un bloqueInvertirAnidado que contiene: 1) Derecha, 2) SubirLapiz, 3) Arriba dentro de otro bloque Invertir.
     * Entonces, en primer lugar: Invertir invierte al bloqueInvertirAnidado -> 1) Arriba, 2) SubirLapiz, 3) Derecha
     * Luego al ejecutar el bloqueInvertirAnidado: 1) Abajo, 2) ApoyarLapiz, 3) Izquierda
     * Entonces si el personaje estaba en la posicion (0,0) ->(0,-1)-> BAJA LAPIZ -> (-1,-1)
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

        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-1), new Posicion(-1,-1))));
        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,-1))));

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
        // debe hacer: (0,0) -> (0,-1) -> BAJAR LAPIZ -> (-1,-1) -> (-2,-1)

        assertFalse(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,0), new Posicion(0,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(0,-1), new Posicion(-1,-1))));
        assertTrue(dibujo.segmentoEstaPintado(new Segmento(new Posicion(-1,-1), new Posicion(-2,-1))));

    }


}