package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LapizTest {

    @Test
    public void unLapizSeCreaLevantado(){
        Lapiz unLapiz = new Lapiz();
        assertTrue(unLapiz.estaLevantado());
    }

    @Test
    public void puedoBajarElLapiz(){
        Lapiz unLapiz = new Lapiz();
        unLapiz.bajarLapiz();

        assertFalse(unLapiz.estaLevantado());
    }

    @Test
    public void puedoBajarYDespuesSubirElLapiz(){
        Lapiz unLapiz = new Lapiz();
        unLapiz.bajarLapiz();
        unLapiz.subirLapiz();

        assertTrue(unLapiz.estaLevantado());
    }

    @Test
    public void elLapizApoyadoPinta() {
        Posicion posicionMock = mock(Posicion.class);

        //necesito que empiece en false
        when(posicionMock.estaPintada()).thenReturn(true);

        Lapiz unLapiz = new Lapiz();
        unLapiz.bajarLapiz();

        //necesito que cuando llame a esta cosa, el false cambie a true
        unLapiz.dibujar(posicionMock);

        //necesito verificar que devolvio true
        assertTrue(posicionMock.estaPintada());
    }

    @Test
    public void elLapizLevantadoNoPinta() {
        Posicion posicionMock = mock(Posicion.class);

        //necesito que empiece en false
        when(posicionMock.estaPintada()).thenReturn(false);

        Lapiz unLapiz = new Lapiz();

        //necesito que cuando llame a esta cosa, el false cambie a true
        unLapiz.dibujar(posicionMock);

        //necesito verificar que devolvio true
        assertFalse(posicionMock.estaPintada());
    }

}

