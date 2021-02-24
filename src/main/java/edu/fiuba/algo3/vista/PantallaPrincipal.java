package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.PantallaInicial;
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

import javafx.scene.layout.BorderPane;

public class PantallaPrincipal extends BorderPane {

    private VBox botoneras;
    private VBox dibujo;
    private VBox secuencia;
    private Scene escena;

    public PantallaPrincipal(Stage stage){
        //this.setMenu(stage);
        this.setSecuencia();
        this.setDibujo();
        this.setBotonera();
        escena = new Scene(this, 1200, 600);
        stage.setScene(escena);
    }


    public void setBotonera(){

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
        botoneras = new VBox(bottomControl, bottomControl2);
        this.setLeft(botoneras);

    }

    public void setDibujo(){
        Image imagen = new Image("Ash.jpeg");
        ImageView imageView = new ImageView(imagen);

        dibujo = new VBox(imageView);
        this.setRight(dibujo);
    }

    public void setSecuencia(){

        Button ejecutar = new Button("Ejecutar");
        Button guardar = new Button("Guardar");
        VBox bloques = new VBox();
        ScrollPane scrollPane = new ScrollPane(bloques);
        secuencia = new VBox(new Label("Secuencia de Bloques"), ejecutar, guardar, scrollPane);
        this.setCenter(secuencia);
    }
    public void inicializar(){

       /* bloqueDerecha.setOnAction(actionEvent -> {Button derecha = new Button("Mover Derecha");
            derecha.setMinSize(150, 30);
            secuencia.getChildren().add(derecha);
        });
*/


    }

}
