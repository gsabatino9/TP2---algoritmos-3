package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Repeticion;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

public class CreadorBloqueRepeticion implements CreadorBloqueComplejo{

    private int cantidadRepeticiones;
    public CreadorBloqueRepeticion(int cantidadRepeticiones){
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    @Override
    public SecuenciaBloques crearBloque() {
        Repeticion repeticion =  new Repeticion(cantidadRepeticiones);
        repeticion.agregarNombre("Repeticion x" + cantidadRepeticiones);
        return repeticion;
    }
}
