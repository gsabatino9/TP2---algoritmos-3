package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SecuenciaBloques implements Bloque {


    protected List<Bloque> bloques;

    public SecuenciaBloques() {
        bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }

    public void agregarBloquePersonalizado(String nombreAlgoritmo, Personaje personaje) throws BloquePersonalizadoNoExisteException {
        Bloque bloque = personaje.obtenerAlgoritmo(nombreAlgoritmo);
        if (bloque == null) {
            throw new BloquePersonalizadoNoExisteException(
                    "El bloque personalizado buscado no fue encontrado.");
        }
        agregarBloque(bloque);
    }

    @Override
    public void ejecutar(Personaje personaje) throws AlgoritmoVacioException {
        if (bloques.size() == 0) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
        bloques.forEach(bloque -> bloque.ejecutar(personaje));
    }

    @Override
    public void invertir(){
        Collections.reverse(bloques);
    }

}
