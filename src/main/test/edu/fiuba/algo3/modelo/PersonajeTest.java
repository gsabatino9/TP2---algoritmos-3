package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {

    @Test //REVISAR COMO COMPARAR CLASES
    public void PersonajeSeCreaPorDefectoConElLapizLevantado() {
        Posicion actual = new Posicion(0,0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);

        assertSame(personaje.obtenerEstado().getClass(), lapiz.obtenerEstado().getClass());
    }

    @Test //REVISAR COMO COMPARAR CLASES
    public void PersonajePuedeCambiarSuTipoDeLapiz() {
        Posicion actual = new Posicion(0,0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);
        Lapiz lapizNuevo = new Lapiz(dibujo);

        personaje.cambiarEstadoDelLapiz(new LapizApoyado());
        assertNotSame(personaje.obtenerEstado().getClass(), lapizNuevo.obtenerEstado().getClass());
    }


    @Test
    public void PersonajePuedeMoverseADerecha() {
        Posicion actual = new Posicion(0,0);
        Posicion posicionDerecha = new Posicion(1, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);

        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertTrue(posicionDerecha.equals(personaje.devolverPosicion()));
    }


    @Test
    public void PersonajePuedeAgregarBloquePersonalizado() throws BloquePersonalizadoYaExisteException {
        Posicion actual = new Posicion(0,0);
        Posicion posicionDerecha = new Posicion(1, 0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);


        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmoPersonalizado = new Algoritmo();
        algoritmoPersonalizado.agregarBloque(bloqueArriba);
        algoritmoPersonalizado.agregarBloque(bloqueDerecha);

        personaje.agregarBloque(algoritmoPersonalizado, "Arriba y a derecha");
        assertNotNull(personaje.obtenerAlgoritmo("Arriba y a derecha"));
    }

    @Test
    public void PersonajeNoPuedeAgregarUnBloqueQueYaEstaGuardado() throws BloquePersonalizadoYaExisteException {
        Posicion actual = new Posicion(0,0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);


        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmoPersonalizado = new Algoritmo();
        algoritmoPersonalizado.agregarBloque(bloqueArriba);
        algoritmoPersonalizado.agregarBloque(bloqueDerecha);

        personaje.agregarBloque(algoritmoPersonalizado, "Arriba y a derecha");
        assertThrows(BloquePersonalizadoYaExisteException.class, () ->  personaje.agregarBloque(algoritmoPersonalizado,"Arriba y a derecha"));

    }

    @Test
    public void PersonajeNoPuedeAgregarUnBloqueQueTieneNombreNoDisponible() throws BloquePersonalizadoYaExisteException {
        Posicion actual = new Posicion(0,0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);


        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmoPersonalizado = new Algoritmo();
        algoritmoPersonalizado.agregarBloque(bloqueArriba);
        algoritmoPersonalizado.agregarBloque(bloqueDerecha);

        Algoritmo algoritmoPersonalizado2 = new Algoritmo();
        algoritmoPersonalizado2.agregarBloque(bloqueArriba);
        algoritmoPersonalizado2.agregarBloque(bloqueDerecha);

        personaje.agregarBloque(algoritmoPersonalizado, "Arriba y a derecha");
        assertThrows(BloquePersonalizadoYaExisteException.class, () ->  personaje.agregarBloque(algoritmoPersonalizado2,"Arriba y a derecha"));
    }

    @Test
    public void PersonajeNoPuedeAgregarUnBloqueQueTieneNombreNoDisponibleAunqueTengaOtrosBloques() throws BloquePersonalizadoYaExisteException {
        Posicion actual = new Posicion(0,0);
        Dibujo dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        Personaje personaje = new Personaje(actual, lapiz);


        BloqueMover bloqueArriba = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmoPersonalizado = new Algoritmo();
        algoritmoPersonalizado.agregarBloque(bloqueArriba);
        algoritmoPersonalizado.agregarBloque(bloqueDerecha);

        BloqueMover bloqueArriba2 = new BloqueMover(Direccion.obtenerArriba());
        BloqueMover bloqueDerecha2 = new BloqueMover(Direccion.obtenerDerecha());

        Algoritmo algoritmoPersonalizado2 = new Algoritmo();
        algoritmoPersonalizado2.agregarBloque(bloqueArriba2);
        algoritmoPersonalizado2.agregarBloque(bloqueDerecha2);

        personaje.agregarBloque(algoritmoPersonalizado, "Arriba y a derecha");
        assertThrows(BloquePersonalizadoYaExisteException.class, () ->  personaje.agregarBloque(algoritmoPersonalizado2,"Arriba y a derecha"));
    }



    /*
    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion(0,0 );

        Personaje personaje = new Personaje(actual);
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeSeCreaPorDefectoConElLapizLevantadoAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion(0,0);

        Personaje personaje = new Personaje(actual);
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertTrue(personaje.devolverPosicion().estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaPosicionSeEncuentraDesocupada() {

        Posicion actual = new Posicion(0,0);
        Personaje personaje = new Personaje(actual);
        personaje.cambiarEstadoDelLapiz(new LapizApoyado());
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertFalse(actual.estaOcupada());
    }

    @Test
    public void PersonajeBajaElLapizAlMoverDerechaLaDerechaSeEncuentraOcupada() {

        Posicion actual = new Posicion(0, 0);
        Personaje personaje = new Personaje(actual);
        personaje.cambiarEstadoDelLapiz(new LapizApoyado());
        Direccion derecha = Direccion.obtenerDerecha();
        personaje.mover(derecha);

        assertTrue(personaje.devolverPosicion().estaOcupada());
    }
    */

}
