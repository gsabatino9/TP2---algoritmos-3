package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

    @Override
    public void ejecutarInvertido(Personaje personaje) throws AlgoritmoVacioException{
        if (bloques.size() == 0) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
        List<Bloque> copia = new ArrayList<Bloque>(bloques);
        Collections.reverse(copia);
        copia.forEach(bloque->bloque.ejecutar(personaje));
    }

}
