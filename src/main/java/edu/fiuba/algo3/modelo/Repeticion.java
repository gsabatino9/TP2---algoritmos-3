package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Repeticion extends SecuenciaBloques{
    private int cantidadRepeticiones;

    public Repeticion(int cantidad){
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser positiva");
        }
        this.cantidadRepeticiones = cantidad;
    }
    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < cantidadRepeticiones; i++) {
            super.ejecutar(personaje);
        }
    }

    @Override
    public void ejecutarInvertido(Personaje personaje){
        if (bloques.size() == 0) {
            throw new AlgoritmoVacioException(
                    "no se puede ejecutar una secuencia sin bloques.");
        }
        List<Bloque> copia = new ArrayList<Bloque>(bloques);
        Collections.reverse(copia);
        for (int i = 0; i < cantidadRepeticiones; i++)
            copia.forEach(bloque->bloque.ejecutar(personaje));
    }
}
