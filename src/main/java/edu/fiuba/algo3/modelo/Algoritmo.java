package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoritmo extends SecuenciaBloques implements Observado{

    private ArrayList<Observador> observadores;

    public Algoritmo(){
        observadores = new ArrayList<>();
    }

    public void guardar(String nombreAlgoritmo, Personaje personaje) throws AlgoritmoVacioException, BloquePersonalizadoYaExisteException {
        if (bloques.size() == 0){
            throw new AlgoritmoVacioException(
                    "El bloque personalizado debe contener al menos un bloque.");
        }
        personaje.agregarBloque(this, nombreAlgoritmo);
    }

    public void vaciar(){ this.bloques.clear(); }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores() { observadores.forEach(Observador::actualizar); }
}
