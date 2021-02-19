package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException{
        SplitPane splitPane = new SplitPane();

        Button bloqueDerecha = new Button("Mover Derecha");
        bloqueDerecha.setMinSize(150, 30);
        Button bloqueIzquierda = new Button("Mover Izquierda");
        bloqueIzquierda.setMinSize(150, 30);
        Button bloqueArriba = new Button("Mover Arriba");
        bloqueArriba.setMinSize(150, 30);
        Button bloqueAbajo = new Button("Mover Abajo");
        bloqueAbajo.setMinSize(150, 30);
        Button bloqueLevantar = new Button("Levantar Lapiz");
        bloqueLevantar.setMinSize(150, 30);
        Button bloqueApoyar = new Button("Apoyar Lapiz");
        bloqueApoyar.setMinSize(150, 30);
        VBox bottomControl = new VBox(new Label("Bloques disponibles"), new Label("Bloques simples"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo, bloqueLevantar, bloqueApoyar);

        Button bloqueInvertir = new Button("Bloque Invertir");
        bloqueInvertir.setMinSize(150, 30);
        Button bloqueRepetir = new Button("Bloque Repetir");
        bloqueRepetir.setMinSize(150, 30);
        VBox bottomControl2 = new VBox( new Label("Bloques compuestos"), bloqueInvertir, bloqueRepetir);


        Button ejecutar = new Button("Ejecutar");
        Button guardar = new Button("Guardar");
        VBox secuencia = new VBox();
        bloqueDerecha.setOnAction(actionEvent -> {Button derecha = new Button("Mover Derecha");
        derecha.setMinSize(150, 30);
        secuencia.getChildren().add(derecha);
        });

        ScrollPane scrollPane = new ScrollPane(secuencia);
        VBox centerControl = new VBox(new Label("Secuencia de Bloques"), ejecutar, guardar, scrollPane);
        VBox leftControl  = new VBox(bottomControl,bottomControl2);

        Image imagen = new Image("Ash.jpeg");
        ImageView imageView = new ImageView(imagen);

        VBox rightControl = new VBox(imageView);

        splitPane.getItems().addAll(leftControl, centerControl,  rightControl);
        splitPane.setDividerPositions(0.1f, 0.25f, 0.6f);

        Scene scene = new Scene(splitPane, 1200, 600);

        stage.setScene(scene);
        stage.setTitle("DibujAR");

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}