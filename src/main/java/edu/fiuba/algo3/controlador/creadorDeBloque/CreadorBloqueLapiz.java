package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapiz;
import edu.fiuba.algo3.modelo.EstadoLapiz;

public class CreadorBloqueLapiz implements CreadorDeBloque{

    private EstadoLapiz estadoLapiz;
    private String nombre;
    public CreadorBloqueLapiz(EstadoLapiz estado, String nombre){
        estadoLapiz = estado;
        this.nombre = nombre;
    }
    @Override
    public Bloque crearBloque() {
        BloqueLapiz bloque = new BloqueLapiz(estadoLapiz);
        bloque.agregarNombre(nombre);
        return bloque;
    }
}
