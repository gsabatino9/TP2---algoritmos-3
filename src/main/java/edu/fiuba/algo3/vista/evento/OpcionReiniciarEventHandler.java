package edu.fiuba.algo3.vista.evento;

import edu.fiuba.algo3.vista.pantallaPrincipal.PantallaPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionReiniciarEventHandler implements EventHandler<ActionEvent>{
    private Stage stage;
    private Scene scene;
    private PantallaPrincipal pantallaPrincipal;

    public OpcionReiniciarEventHandler(Stage stage, Scene scene, PantallaPrincipal pantallaPrincipal){
        this.stage = stage;
        this.scene = scene;
        this.pantallaPrincipal = pantallaPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pantallaPrincipal.inicializar(stage);
        stage.setScene(scene);
        stage.setFullScreen(true);
    }
}
