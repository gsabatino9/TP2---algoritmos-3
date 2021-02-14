package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    private List<Segmento> segmentosPintados = new ArrayList<Segmento>();

    public void agregarSegmento(Segmento segmento) {
        segmentosPintados.add(segmento);
    }

    public boolean segmentoEstaPintado(Segmento segmento){
        return segmentosPintados.stream().anyMatch(seg -> seg.equals(segmento));
    }

    public boolean segmentosEstanPintados(List<Segmento> segmentos){
        return segmentos.stream().allMatch(pos -> segmentoEstaPintado(pos));
    }

}
