package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.pantallaPrincipal.VistaAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControladorBotonEjecutar implements EventHandler<ActionEvent> {
    private ControladorModelo controladorModelo;
    public ControladorBotonEjecutar(ControladorModelo controladorModelo){
        this.controladorModelo = controladorModelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorModelo.ejecutar();
    }
}
