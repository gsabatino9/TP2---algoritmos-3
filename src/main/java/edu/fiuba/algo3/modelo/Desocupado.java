package edu.fiuba.algo3.modelo;

public class Desocupado implements Ocupacion{
    public boolean estaOcupada(){
        return false;
    }

    public Ocupacion cambiarEstado(){
        return new Ocupado();
    }

    public boolean pintar(){
        return false;
    }
}
