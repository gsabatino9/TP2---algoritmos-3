package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.awt.desktop.SystemEventListener;

import static org.junit.jupiter.api.Assertions.*;


public class AlgoritmoTest {



    @Test
    public void seCreaUnAlgoritmoQuePorDefectoSeRepiteUnaVez(){
        Algoritmo algoritmo = new Algoritmo(1);

        assertEquals(algoritmo.obtenerCantidadReproducciones(), 1);
    }

    @Test
        public void seCreaUnAlgoritmoPeroSinBloquesElPersonajeNoSeMueveNiBajaElLapiz(){
            Algoritmo algoritmo = new Algoritmo(1);
            Posicion posicionInicio = new Posicion(0, 0);
            Dibujo dibujo = new Dibujo();
            Lapiz lapiz = new Lapiz(dibujo);
            Personaje personaje = new Personaje(posicionInicio, lapiz);
            algoritmo.ejecutar(personaje);

            assertEquals(posicionInicio, personaje.devolverPosicion());
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


   // Algoritmo bloqueRepetir = new Algoritmo(2);
    //    bloqueRepetir.agregarBloque(bloqueDerecha);

//        algoritmo.agregarBloque(bloqueRepetir);

    /*
    @Test
    public void seAgregaBloqueDerechaBloqueDerechaSeOcupa(){
        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.agregarBloque(bloque);
        algoritmo.ejecutar(personaje);

        assertTrue(personaje.devolverPosicion().estaOcupada());

    }

    @Test
    public void seAgregaBloqueDerechaBloqueActualSeDesocupa(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.agregarBloque(bloque);
        algoritmo.ejecutar(personaje);

        assertTrue(actual.estaOcupada());

    }

    @Test
    public void unPersonajeQueSeMueveParaLaDerechaYLuegoArribaEntoncesArribaEstaOcupado(){
        Posicion actual = new Posicion(0,0 );

        Personaje personaje = new Personaje(actual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());
        BloqueMover bloque2 = new BloqueMover(Direccion.obtenerArriba());

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.ejecutar(personaje);
        assertTrue(personaje.devolverPosicion().estaOcupada());
    }


    @Test
    public void sinAgregarBloquesElPersonajeNoHaceNada(){
        Posicion actual = new Posicion(0,0 );
        Personaje personaje = new Personaje(actual);

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.ejecutar(personaje);

        assertTrue(actual.estaOcupada());
        assertTrue(personaje.obtenerEstado() instanceof LapizLevantado);
    }

    @Test
    public void agregarSoloUnBloqueDeBajarLapizHaceQueElPersonajeTengaElLapizApoyado(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Bloque bloque = new BloqueLapiz(new LapizApoyado());

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.agregarBloque(bloque);
        algoritmo.ejecutar(personaje);

        assertTrue(actual.estaOcupada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }

    @Test
    public void bajarElLapizYMoverAlPersonajeALaDerechaHaceQueLaPosicionEstePintada(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Bloque bloque = new BloqueLapiz(new LapizApoyado());
        BloqueMover bloque2 = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmo = new Algoritmo(1);
        algoritmo.agregarBloque(bloque);
        algoritmo.agregarBloque(bloque2);
        algoritmo.ejecutar(personaje);

        //assertTrue(actual.estaPintada());
        assertTrue(personaje.devolverPosicion().estaOcupada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);
    }
    */
   /* @Test
    public void personajeSeMueveADerechaYLuegoAIzquierdaPintandoPosicionDeberiaEstarPintada(){
        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);

        Algoritmo algoritmo = new Algoritmo(1);
        Bloque apoyado = new BloqueLapiz(new LapizApoyado());
        BloqueMover derecha = new BloqueMover(Direccion.obtenerDerecha());
        BloqueMover izquierda = new BloqueMover(Direccion.obtenerIzquierda());


        algoritmo.agregarBloque(apoyado);
        algoritmo.agregarBloque(derecha);
        algoritmo.agregarBloque(izquierda);
        algoritmo.ejecutar(personaje);

        //assertTrue(personaje.devolverPosicion().estaPintada());
        assertTrue(personaje.obtenerEstado() instanceof LapizApoyado);

    }*/

}
