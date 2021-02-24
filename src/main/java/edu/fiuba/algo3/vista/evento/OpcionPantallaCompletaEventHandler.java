package edu.fiuba.algo3.vista.evento;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    MenuItem opcionPantallaCompleta;
    MenuItem opcionPantallaMinimizada;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta, MenuItem opcionPantallaMinimizada) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
        this.opcionPantallaMinimizada = opcionPantallaMinimizada;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            opcionPantallaMinimizada.setDisable(false);
            stage.show();
        }
    }
}