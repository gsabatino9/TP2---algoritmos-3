package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.creadorDeBloque.CreadorDeBloque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloqueSimple implements EventHandler<ActionEvent> {
    private ControladorModelo controlador;
    private CreadorDeBloque creador;

    public ControladorBloqueSimple(ControladorModelo controlador, CreadorDeBloque creador){
        this.creador = creador;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.agregarBloque(creador.crearBloque());
    }
}
