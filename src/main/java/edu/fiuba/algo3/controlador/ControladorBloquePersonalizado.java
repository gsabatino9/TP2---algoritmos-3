package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloquePersonalizado implements EventHandler<ActionEvent> {
    private ControladorModelo modelo;
    private Algoritmo algoritmo;

    public ControladorBloquePersonalizado(Algoritmo algoritmo, ControladorModelo modelo)
    {
        this.modelo = modelo;
        this.algoritmo = algoritmo;
    }

    @Override
    public void handle(ActionEvent event) {
        modelo.agregarBloque(algoritmo);
    }
}
