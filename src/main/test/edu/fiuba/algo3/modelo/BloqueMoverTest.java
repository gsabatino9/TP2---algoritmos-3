package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueMoverTest {

    @Test
    public void seCreaUnBloqueMoverConDireccionADerechaYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion(0,0);
        Personaje personaje = new Personaje(posicionActual);
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());

        bloque.ejecutar(personaje);
        assertTrue(personaje.devolverPosicion().estaOcupada());
    }
}
