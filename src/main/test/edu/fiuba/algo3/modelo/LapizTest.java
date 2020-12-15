package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Lapiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}

