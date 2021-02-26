package edu.fiuba.algo3.vista.evento;

import edu.fiuba.algo3.vista.PantallaReglas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionComoJugarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Scene escenaAnterior;

    public OpcionComoJugarEventHandler(Stage stage, Scene escenaAnterior){
        this.stage = stage;
        this.escenaAnterior = escenaAnterior;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        PantallaReglas pantallaReglas = new PantallaReglas(stage, escenaAnterior);
        Scene escenaReglas = new Scene(pantallaReglas, 640, 480);

        stage.setScene(escenaReglas);
        stage.setFullScreen(true);
    }
}