package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoritmo extends SecuenciaBloques implements Observado{

    private ArrayList<Observador> observadores;

    public Algoritmo(){
        observadores = new ArrayList<>();
    }

    public void guardar(String nombreAlgoritmo, Personaje personaje) throws AlgoritmoVacioException, BloquePersonalizadoYaExisteException {
        super.esEjecutable();
        personaje.agregarBloque(this, nombreAlgoritmo);
    }

    public void vaciar() {
        this.bloques.clear();
    }

    public Algoritmo clonar() {
        Algoritmo algoritmoClonado = new Algoritmo();
        return (Algoritmo) super.clonarSecuencia(algoritmoClonado);
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores() { observadores.forEach(Observador::actualizar); }
}
