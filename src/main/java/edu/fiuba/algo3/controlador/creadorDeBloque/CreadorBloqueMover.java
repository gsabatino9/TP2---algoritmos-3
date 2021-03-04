package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueMover;
import edu.fiuba.algo3.modelo.Direccion;

public class CreadorBloqueMover implements CreadorDeBloque{
    private Direccion direccion;
    private String nombre;

    public CreadorBloqueMover(Direccion direccion, String nombre){
        this.direccion = direccion;
        this.nombre = nombre;
    }

    @Override
    public Bloque crearBloque() {
        BloqueMover bloque = new BloqueMover(direccion);
        bloque.agregarNombre(nombre);
        return bloque;
    }
}
