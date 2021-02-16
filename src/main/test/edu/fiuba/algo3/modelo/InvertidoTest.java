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
    public void ejecutarInvertidoDeInvertidoNoInvierte(){
        Invertido bloqueInvertir = new Invertido();
        Posicion posicionInicio = new Posicion(0, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(posicionInicio, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        BloqueMover bloqueDerecha = new BloqueMover(derecha);
        Posicion posicionDerecha = new Posicion(1, 0);

        bloqueInvertir.agregarBloque(bloqueDerecha);
        bloqueInvertir.ejecutarInvertido(personaje);

        assertTrue(posicionDerecha.equals(personaje.devolverPosicion()));
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
}