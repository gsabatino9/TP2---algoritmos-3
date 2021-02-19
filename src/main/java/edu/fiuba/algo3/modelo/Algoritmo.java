package edu.fiuba.algo3.modelo;

public class Algoritmo extends SecuenciaBloques{

    public Algoritmo() { }

    public void agregarBloquePersonalizado(String nombreAlgoritmo, Personaje personaje) throws BloquePersonalizadoNoExisteException {
        Bloque bloque = personaje.obtenerAlgoritmo(nombreAlgoritmo);
        if (bloque == null) {
            throw new BloquePersonalizadoNoExisteException(
                    "El bloque personalizado buscado no fue encontrado.");
        }
        agregarBloque(bloque);
    }

    public void guardar(String nombreAlgoritmo, Personaje personaje) throws AlgoritmoVacioException {
        if (bloques.size() == 0){
            throw new AlgoritmoVacioException(
                    "El bloque personalizado debe contener al menos un bloque.");
        }
        personaje.agregarBloque(this, nombreAlgoritmo);
    }

    public boolean algoritmoEstaGuardado(String nombreAlgoritmo, Personaje personaje){
        return personaje.algoritmoEstaGuardado(nombreAlgoritmo);
    }
}
