package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Personaje;

public class ControladorPersonaje {
    private Personaje personaje;

    public ControladorPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public int obtenerX()
    {
        return personaje.devolverPosicion().obtenerColumna();
    }

    public int obtenerY(){
        return personaje.devolverPosicion().obtenerFila();
    }
}
