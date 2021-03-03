package edu.fiuba.algo3.controlador.creadorDeBloque;

import edu.fiuba.algo3.modelo.*;

public class CreadorBloquePersonalizado implements CreadorDeBloque{

    private Algoritmo algoritmo;
    public CreadorBloquePersonalizado(Algoritmo algoritmo){
        this.algoritmo = algoritmo;
    }

    @Override
    public Algoritmo crearBloque()
    {
         return algoritmo.crearCopia();
    }
}