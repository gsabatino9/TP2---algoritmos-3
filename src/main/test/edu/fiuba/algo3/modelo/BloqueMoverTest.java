package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BloqueMoverTest {

    @Test
    public void seCreaUnBloqueMoverConDireccionADerechaYElPersonajeDebeMoverse(){
        Posicion posicionActual = new Posicion();
        Posicion derecha = new Posicion();
        posicionActual.agregarDerecha(derecha);
        Personaje personaje = new Personaje(posicionActual);
        BloqueMover bloque = new BloqueMover(new Derecha());

        bloque.ejecutar(personaje);
        assertTrue(derecha.estaOcupada());
    }
}
