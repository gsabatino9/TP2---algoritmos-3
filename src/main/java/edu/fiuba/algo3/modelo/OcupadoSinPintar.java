package edu.fiuba.algo3.modelo;

public class OcupadoSinPintar implements Ocupacion{
    public boolean estaOcupada(){
        return true;
    }

    public Ocupacion cambiarEstado(){
        return new DesocupadoSinPintar();
    }

    public Ocupacion pintar(){
        return new OcupadoPintado();
    }

    public boolean estaPintada(){
        return false;
    }
}
