package edu.fiuba.algo3.modelo;

public class DesocupadoPintado implements Ocupacion{

    public boolean estaOcupada(){
        return false;
    }

    public Ocupacion cambiarEstado(){
        return new OcupadoPintado();
    }

    public Ocupacion pintar(){
        return this;
    }

    public boolean estaPintada(){
        return true;
    }
}
