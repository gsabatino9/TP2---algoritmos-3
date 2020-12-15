package edu.fiuba.algo3.modelo;

public class Ocupado implements Ocupacion{
    public boolean estaOcupada(){
        return true;
    }

    public Ocupacion cambiarEstado(){
        return new Desocupado();
    }
}
