package edu.fiuba.algo3.vista.pantallaPrincipal;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import javafx.scene.layout.BorderPane;

public class PantallaPrincipal extends BorderPane {

    private VBox botoneras;
    private VBox dibujo;
    private VBox secuencia;
    private MenuBar barraMenu;
    private Scene escenaJuego;

    public void inicializar(Stage stage){
        this.setMenu(stage);
        this.setSecuencia();
        this.setDibujo();
        this.setBotonera();
    }

    public void setScene(Scene escenaJuego){
        this.escenaJuego = escenaJuego;
    }

    public void setMenu(Stage stage){
        barraMenu = new BarraMenu(stage, escenaJuego);
        this.setTop(barraMenu);
    }

    public void setBotonera(){
        VBox bottomControl1 = agregarBotonesSimples();
        VBox bottomControl2 = agregarBotonesCompuestos();

        botoneras = new VBox(bottomControl1, bottomControl2);
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
        });*/
    }

    private Button crearBoton(Button boton, int minWidth, int minHeight){
        boton.setMinSize(minWidth, minHeight);
        return boton;
    }

    private VBox agregarBotonesSimples(){
        Button bloqueDerecha = crearBoton(new Button("Mover Derecha"), 150, 30);
        Button bloqueIzquierda = crearBoton(new Button("Mover Izquierda"), 150, 30);
        Button bloqueArriba = crearBoton(new Button("Mover Arriba"), 150, 30);
        Button bloqueAbajo = crearBoton(new Button("Mover Abajo"), 150, 30);
        Button bloqueLevantar = crearBoton(new Button("Levantar lapiz"), 150, 30);
        Button bloqueApoyar = crearBoton(new Button("Apoyar lapiz"), 150, 30);
        VBox bottomControl = new VBox(new Label("Bloques disponibles"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo, bloqueLevantar, bloqueApoyar);
        bottomControl.setSpacing(5);

        return bottomControl;
    }

    private VBox agregarBotonesCompuestos(){
        Button bloqueInvertir = crearBoton(new Button("Invertir"), 150, 30);
        Button bloqueRepetir = crearBoton(new Button("Repetir"), 150, 30);
        VBox bottomControl = new VBox(bloqueInvertir, bloqueRepetir);
        bottomControl.setSpacing(5);

        return bottomControl;
    }

}
