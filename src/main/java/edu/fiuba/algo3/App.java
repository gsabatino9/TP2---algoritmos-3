package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        SplitPane splitPane = new SplitPane();

        Button ejecutar = new Button("Ejecutar");
        Button guardar = new Button("Guardar");
        HBox bottomControl = new HBox(ejecutar, guardar);

        Button bloqueDerecha = new Button("Mover Derecha");
        Button bloqueIzqueirda = new Button("Mover Izquierda");
        Button bloqueArriba = new Button("Mover Arriba");
        Button bloqueAbajo = new Button("Mover Abajo");
        Button bloqueLevantar = new Button("Levantar Lapiz");
        Button bloqueApoyar = new Button("Apoyar Lapiz");
        HBox bottomControl2 = new HBox(bloqueDerecha, bloqueIzqueirda, bloqueArriba, bloqueAbajo, bloqueLevantar, bloqueApoyar);

        Button bloqueInvertir = new Button("Bloque Invertir");
        Button bloqueRepetir = new Button("Bloque Repetir");
        HBox bottomControl3 = new HBox(bloqueInvertir, bloqueRepetir);

        VBox leftControl  = new VBox(new Label("Secuencia de Bloques"), bottomControl, new Label("Bloques disponibles"), new Label("Bloques simples"), bottomControl2, new Label("Bloques compuestos"), bottomControl3);
        VBox rightControl = new VBox(new Label("Donde se mueve el personaje"));

//      leftControl.setSpacing(300);

        splitPane.getItems().addAll(leftControl, rightControl);

        Scene scene = new Scene(splitPane, 800, 700);

        stage.setScene(scene);
        stage.setTitle("JavaFX App");

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}