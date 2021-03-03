package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.*;

public class CreadorBloqueApoyarLapiz implements CreadorDeBloque{
    @Override
    public Bloque crearBloque() {
        BloqueLapiz bloque = new BloqueLapiz(new LapizApoyado());
        bloque.agregarNombre("Apoyar Lapiz");
        return bloque;
    }
}
