package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public abstract class SecuenciaBloques extends Bloque {

    protected ArrayList<Bloque> bloques;

    public SecuenciaBloques() {
        super();
        bloques = new ArrayList<>();
    }

    public void agregarBloque(Bloque bloque) {
        bloques.add(bloque);
    }

    public void agregarBloquePersonalizado(String nombreAlgoritmo, Personaje personaje) {
        Bloque bloque = personaje.obtenerAlgoritmo(nombreAlgoritmo);
        agregarBloque(bloque);
    }

    @Override
    public void ejecutar(Personaje personaje) throws AlgoritmoVacioException {
        esEjecutable();
        bloques.forEach(bloque -> bloque.ejecutar(personaje));
    }

    @Override
    public void invertir(){
        Collections.reverse(bloques);
    }

    @Override
    public ArrayList<Bloque> obtenerHijos(){
        return bloques;
    }

    public SecuenciaBloques clonarSecuencia(SecuenciaBloques secuenciaClonada) {
        bloques.forEach(b -> {
            secuenciaClonada.agregarBloque(b.clonar());
        });
        secuenciaClonada.agregarNombre(obtenerNombre());
        return secuenciaClonada;
    }


    public void esEjecutable() throws AlgoritmoVacioException{
        if (bloques.isEmpty()) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
        bloques.forEach(bloque -> bloque.esEjecutable());
    }


}
