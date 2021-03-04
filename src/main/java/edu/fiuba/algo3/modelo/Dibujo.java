package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Dibujo implements Observado {
    private List<Segmento> segmentosPintados = new ArrayList<Segmento>();
    private ArrayList<Observador> observadores;

    public Dibujo(){
        observadores = new ArrayList<Observador>();
    }

    public void agregarSegmento(Segmento segmento) {
        segmentosPintados.add(segmento);
        notificarObservadores();
    }

    public boolean segmentoEstaPintado(Segmento segmento){
        return segmentosPintados.stream().anyMatch(seg -> seg.equals(segmento));
    }

    public List<Segmento> obtenerSegmentos(){
        return segmentosPintados;
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(Observador::actualizar);
    }
}
