package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Invertido;
import edu.fiuba.algo3.modelo.SecuenciaBloques;

public class CreadorBloqueInvertir implements CreadorBloqueComplejo{

    @Override
    public SecuenciaBloques crearBloque() {
        Invertido invertido = new Invertido();
        invertido.agregarNombre("Invertido");
        return invertido;
    }
}
