package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class BloqueInvertir implements Bloque {

    private List<Bloque> bloques;

    public BloqueInvertir(){
        bloques = new ArrayList<Bloque>();
    }

    public void agregarBloque(Bloque bloque) {

        bloques.add(bloque);
    }

    @Override
    public void ejecutar(Personaje personaje) throws AlgoritmoVacioException {
        if (bloques.size() == 0) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
            bloques.forEach(bloque -> bloque.ejecutarInvertido(personaje));
    }

    @Override
    public void ejecutarInvertido(Personaje personaje) {
        if (bloques.size() == 0) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
        bloques.forEach(bloque -> bloque.ejecutar(personaje));
    }


    //revisar este metodo. Repetimos codigo con Algoritmo. Creo que se podria resolver la clave del algortimo en una etapa anterior.

    public void agregarBloquePersonalizado(String nombreAlgoritmo, Personaje personaje) throws BloquePersonalizadoNoExisteException {
        Bloque bloque = personaje.obtenerAlgoritmo(nombreAlgoritmo);
        if (bloque == null) {
            throw new BloquePersonalizadoNoExisteException(
                    "El bloque personalizado buscado no fue encontrado.");
        }
        agregarBloque(bloque);
    }
}
