package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.PantallaInicial;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoBlocks");
        PantallaInicial pantalla = new PantallaInicial(stage);
        pantalla.inicializar();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}