package edu.fiuba.algo3.vista.evento;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {
    public OpcionSalirEventHandler() {

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
