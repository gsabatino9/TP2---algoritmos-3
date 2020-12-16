package edu.fiuba.algo3.modelo;

public class DesocupadoSinPintar implements Ocupacion{
    public boolean estaOcupada(){
        return false;
    }

    public Ocupacion cambiarEstado(){
        return new OcupadoSinPintar();
    }

    public Ocupacion pintar(){
        return this;
        //agregar excepcion
    }

    public boolean estaPintada(){
        return false;
    }
}
