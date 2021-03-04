package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.creadorDeBloque.CreadorBloquePersonalizado;
import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloquePersonalizado implements EventHandler<ActionEvent> {
    private ControladorModelo modelo;
    private CreadorBloquePersonalizado creador;

    public ControladorBloquePersonalizado(CreadorBloquePersonalizado creador, ControladorModelo modelo)
    {
        this.modelo = modelo;
        this.creador = creador;
    }

    @Override
    public void handle(ActionEvent event) {
        modelo.agregarBloque(creador.crearBloque());
    }
}
