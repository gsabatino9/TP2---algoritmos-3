package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;

public class ControladorBorrarAlgoritmo implements EventHandler<ActionEvent> {

    private ControladorModelo controlador;

    public ControladorBorrarAlgoritmo(ControladorModelo controladorModelo)
    {
        controlador = controladorModelo;
    }

    @Override
    public void handle(ActionEvent event) {
        controlador.vaciarAlgoritmo();
    }
}
