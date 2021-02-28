package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueMover;
import edu.fiuba.algo3.modelo.Direccion;

public class CreadorBloqueMoverDerecha implements CreadorDeBloque {

    @Override
    public Bloque crearBloque() {
        BloqueMover bloque = new BloqueMover(Direccion.obtenerDerecha());
        bloque.agregarNombre("Mover Derecha");
        return bloque;
    }
}
