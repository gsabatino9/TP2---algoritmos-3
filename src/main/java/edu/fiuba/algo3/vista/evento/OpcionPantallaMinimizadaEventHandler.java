package edu.fiuba.algo3.vista.evento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaMinimizadaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem opcionPantallaMinimizada;
    MenuItem opcionPantallaCompleta;
    public OpcionPantallaMinimizadaEventHandler(Stage stage, MenuItem opcionPantallaMinimizada, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaMinimizada = opcionPantallaMinimizada;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(false);
            opcionPantallaMinimizada.setDisable(true);
            opcionPantallaCompleta.setDisable(false);
            stage.show();
        }
    }
}