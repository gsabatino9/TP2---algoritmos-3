package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dibujo {
    private List<Posicion> posicionesPintadas = new ArrayList<Posicion>();

    public void agregarPosicion(Posicion posicion) {
        posicionesPintadas.add(posicion);
    }

    public boolean posicionEstaPintada(Posicion posicion){
        return posicionesPintadas.stream().anyMatch(pos -> pos.equals(posicion));
    }

    public boolean posicionesEstanPintadas(List<Posicion> posiciones){
        return posiciones.stream().allMatch(pos -> posicionEstaPintada(pos));
    }

}
