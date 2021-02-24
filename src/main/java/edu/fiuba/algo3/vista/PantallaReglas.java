package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.evento.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaReglas extends VBox {

    private Stage stage;
    private Scene escenaAnterior;

    public PantallaReglas(Stage stage, Scene escenaAnterior){
        this.stage = stage;
        this.escenaAnterior = escenaAnterior;

        //las instrucciones

        Button botonVolver = new Button();
        botonVolver.setText("Atras");
        BotonEntrarEventHandler botonVolverHandler = new BotonEntrarEventHandler(stage, escenaAnterior);
        botonVolver.setOnAction(botonVolverHandler);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        this.getChildren().addAll(botonVolver, botonSalir);
    }

}
