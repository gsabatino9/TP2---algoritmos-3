package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.PantallaInicial;
import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
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
    private MenuBar barraMenu;
    private Scene escenaJuego;

    public PantallaPrincipal(Stage stage){
        this.escenaJuego = stage.getScene();
        this.setMenu(stage);
        this.setSecuencia();
        this.setDibujo();
        this.setBotonera();
    }

    public void setMenu(Stage stage){
        //como jugar, reinicar, salir
        this.barraMenu = new MenuBar();

        Menu menu = new Menu("Opciones");

        MenuItem opcionSalir = new Menu("Salir");
        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);


        MenuItem opcionComoJugar = new Menu("Como Jugar");
        OpcionComoJugarEventHandler opcionComoJugarHandler = new OpcionComoJugarEventHandler(stage, escenaJuego);
        opcionComoJugar.setOnAction(opcionComoJugarHandler);


        MenuItem opcionReiniciar = new Menu("Reiniciar");


        menu.getItems().addAll(opcionSalir, opcionComoJugar, opcionReiniciar);


        //opcionPantallaCompleta.setDisable(true);

        this.barraMenu.getMenus().addAll(menu);

        this.setTop(barraMenu);

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
        bottomControl.setSpacing(5);

        Button bloqueInvertir = new Button("Bloque Invertir");
        bloqueInvertir.setMinSize(150, 30);
        Button bloqueRepetir = new Button("Bloque Repetir");
        bloqueRepetir.setMinSize(150, 30);
        VBox bottomControl2 = new VBox( new Label("Bloques compuestos"), bloqueInvertir, bloqueRepetir);
        bottomControl2.setSpacing(5);

        botoneras = new VBox(bottomControl, bottomControl2);
        botoneras.setPadding(new Insets(20));
        this.setLeft(botoneras);

    }

    public void setDibujo(){
        Image imagen = new Image("Ash.jpeg");
        ImageView imageView = new ImageView(imagen);

        dibujo = new VBox(imageView);
        dibujo.setPadding(new Insets(20));
        this.setCenter(dibujo);
    }

    public void setSecuencia(){
        Button ejecutar = new Button("Ejecutar");
        Button guardar = new Button("Guardar");
        VBox bloques = new VBox();
        ScrollPane scrollPane = new ScrollPane(bloques);
        secuencia = new VBox(new Label("Secuencia de Bloques"), ejecutar, guardar, scrollPane);
        secuencia.setSpacing(5);
        secuencia.setPadding(new Insets(20));
        this.setRight(secuencia);
    }
    public void inicializar(){

       /* bloqueDerecha.setOnAction(actionEvent -> {Button derecha = new Button("Mover Derecha");
            derecha.setMinSize(150, 30);
            secuencia.getChildren().add(derecha);
        });
*/


    }

}
