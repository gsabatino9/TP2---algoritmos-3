package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.BloqueEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaPrincipal extends BorderPane {

    private VBox botoneras;
    private GridPane dibujo;
    private VBox secuencia;
    private ScrollPane secuenciaBloques;
    private VBox contenedor;
    private BarraMenu barraMenu;
    private Scene escenaJuego;



    public void inicializar(Stage stage){
        this.setMenu(stage);
        this.setContenedor();
        this.setDibujo();
        this.setBotonera();
    }

    public void setScene(Scene escenaJuego){
        this.escenaJuego = escenaJuego;
    }

    public void setMenu(Stage stage){
        barraMenu = new BarraMenu(stage, escenaJuego, this);
        this.setTop(barraMenu);
    }

    public void setBotonera(){
        VBox bottomControl1 = agregarBotonesSimples();

        botoneras = new VBox(bottomControl1);
        botoneras.setPadding(new Insets(20));
        this.setLeft(botoneras);
    }

    public void setDibujo(){
        ImageView view = new ImageView();
        view.setFitWidth(50);
        view.setFitHeight(50);

        Image img = new Image("Ash.jpeg");
        view.setImage(img);

        ImageView view2 = new ImageView();

        this.dibujo = new GridPane();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(view, 8, 6);
        dibujo.add(view2, 15, 10);
        dibujo.setGridLinesVisible(true);
        dibujo.setAlignment(Pos.CENTER);


        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1000, 800, false, false, false, false));
        dibujo.setBackground(new Background(imagenDeFondo));
        this.setCenter(dibujo);
    }

    public void setContenedor(){
        Button ejecutar = new Button("Ejecutar");
        ejecutar.setStyle("-fx-background-color: #F7FD81; ");
        ejecutar.setMinSize(90, 25);
        Button guardar = new Button("Guardar");
        guardar.setStyle("-fx-background-color: #C8FD81; ");
        guardar.setMinSize(90, 25);

        contenedor = new VBox(ejecutar, guardar, new Label("Secuencia de Bloques"));
        contenedor.setSpacing(5);
        contenedor.setPadding(new Insets(20));
        this.setRight(contenedor);

        this.secuencia = new VBox();
        this.secuenciaBloques = new ScrollPane(this.secuencia);
        contenedor.getChildren().add(this.secuenciaBloques);
    }

    private Button crearBoton(Button boton, int minWidth, int minHeight, String color){
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
        boton.setOnAction(new BloqueEventHandler(boton.getText().toString(), minWidth, minHeight, color, secuencia));
        return boton;
    }

    private VBox agregarBotonesSimples(){
        Button bloqueDerecha = crearBoton(new Button("Mover Derecha"), 150, 30, "-fx-background-color: #95B2F9; ");
        Button bloqueIzquierda = crearBoton(new Button("Mover Izquierda"), 150, 30, "-fx-background-color: #95B2F9; ");
        Button bloqueArriba = crearBoton(new Button("Mover Arriba"), 150, 30, "-fx-background-color: #95B2F9; ");
        Button bloqueAbajo = crearBoton(new Button("Mover Abajo"), 150, 30, "-fx-background-color: #95B2F9; ");
        Button bloqueLevantar = crearBoton(new Button("Levantar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ");
        Button bloqueApoyar = crearBoton(new Button("Apoyar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ");

        Button bloqueInvertir = crearBoton(new Button("Invertir"), 150, 30, "-fx-background-color: #C781FD; ");
        Button bloqueRepetir = crearBoton(new Button("Repetir"), 150, 30, "-fx-background-color: #C781FD; ");

        VBox bottomControl = new VBox(new Label("Bloques disponibles"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo, bloqueLevantar, bloqueApoyar, bloqueInvertir, bloqueRepetir);
        bottomControl.setSpacing(5);

        return bottomControl;
    }

}
