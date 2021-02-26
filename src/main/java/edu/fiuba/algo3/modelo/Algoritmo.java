package edu.fiuba.algo3.modelo;

public class Algoritmo extends SecuenciaBloques{

    public void guardar(String nombreAlgoritmo, Personaje personaje) throws AlgoritmoVacioException, BloquePersonalizadoYaExisteException {
        if (bloques.size() == 0){
            throw new AlgoritmoVacioException(
                    "El bloque personalizado debe contener al menos un bloque.");
        }
        personaje.agregarBloque(this, nombreAlgoritmo);
    }

}
