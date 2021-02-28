package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.BloqueLapiz;
import edu.fiuba.algo3.modelo.LapizLevantado;

public class CreadorBloqueLevantarLapiz implements CreadorDeBloque {

    @Override
    public Bloque crearBloque() {
        BloqueLapiz bloque = new BloqueLapiz(new LapizLevantado());
        bloque.agregarNombre("Levantar Lapiz");
        return bloque;
    }
}
