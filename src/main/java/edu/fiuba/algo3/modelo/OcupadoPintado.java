package edu.fiuba.algo3.modelo;

public class OcupadoPintado implements Ocupacion{
    public boolean estaOcupada(){
        return true;
    }

    public Ocupacion cambiarEstado(){
        return new DesocupadoPintado();
    }

    public Ocupacion pintar(){
        return this;
    }

    public boolean estaPintada(){
        return true;
    }
}
