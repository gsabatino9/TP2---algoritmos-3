package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Bloque;

public class CreadorAlgoritmo implements CreadorDeBloque{

    private Algoritmo algoritmo;
    public CreadorAlgoritmo(Algoritmo algoritmo){
        this.algoritmo = algoritmo;
    }

    @Override
    public Bloque crearBloque() {
        return algoritmo; //deberia devolver una copia del algoritmo
    }
}
