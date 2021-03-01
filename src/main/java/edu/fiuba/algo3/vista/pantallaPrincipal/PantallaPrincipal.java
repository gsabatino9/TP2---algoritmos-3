package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.ControladorModelo;
import edu.fiuba.algo3.controlador.ControladorPersonaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaPrincipal extends BorderPane {

    private VistaAlgoritmo vistaAlgoritmo;
    private VistaPersonaje vistaPersonaje;
    private ScrollPane secuenciaBloques;
    private VBox contenedor;
    private BarraMenu barraMenu;
    private Scene escenaJuego;
    private ControladorModelo controladorModelo;
    private ControladorPersonaje controladorPersonaje;
    private VistaBloquesColocables botoneras;
    private Canvas tablero;
    private VistaDibujo vista;
    private StackPane contenedorDibujo;
    private GridPane dibujo;
    private ImageView view;


    public void inicializar(Stage stage) {
        controladorModelo = new ControladorModelo();
        controladorPersonaje = new ControladorPersonaje(controladorModelo.obtenerPersonaje());
        this.setMenu(stage);
        this.setBotonera();
        this.setContenedor();
        this.setDibujo();
    }

    public void setScene(Scene escenaJuego) {
        this.escenaJuego = escenaJuego;
    }

    public void setMenu(Stage stage) {
        barraMenu = new BarraMenu(stage, escenaJuego, this);
        this.setTop(barraMenu);
    }

    public void setBotonera() {
        botoneras = new VistaBloquesColocables(controladorModelo);
        this.setLeft(botoneras);
    }

    public void setContenedor() {
        Button ejecutar = new Button("Ejecutar");
        ejecutar.setStyle("-fx-background-color: #F7FD81; ");
        ejecutar.setMinSize(90, 25);
        ejecutar.setOnAction(accion -> {
            controladorModelo.ejecutar();
            controladorModelo.vaciarSecuencia();

            contenedor.getChildren().remove(this.secuenciaBloques);
            vistaAlgoritmo.actualizar();
            secuenciaBloques = new ScrollPane(vistaAlgoritmo);
            secuenciaBloques.setMinSize(170, 25);
            contenedor.getChildren().add(this.secuenciaBloques);
        });

        Button guardar = new Button("Guardar");
        guardar.setStyle("-fx-background-color: #C8FD81; ");
        guardar.setMinSize(90, 25);

        contenedor = new VBox(ejecutar, guardar, new Label("Secuencia de Bloques"));
        contenedor.setSpacing(5);
        contenedor.setPadding(new Insets(20));
        this.setRight(contenedor);

        vistaAlgoritmo = new VistaAlgoritmo(controladorModelo.obtenerAlgoritmo());
        controladorModelo.obtenerAlgoritmo().agregarObservador(vistaAlgoritmo);
        vistaAlgoritmo.actualizar();
        secuenciaBloques = new ScrollPane(vistaAlgoritmo);
        secuenciaBloques.setMinSize(170, 25);
        contenedor.getChildren().add(this.secuenciaBloques);
    }




    public void setDibujo(){
        this.view = new ImageView();
        view.setFitWidth(50);
        view.setFitHeight(50);
        Image img = new Image("Ash.jpeg");
        view.setImage(img);

        ImageView view2 = new ImageView();

        this.contenedorDibujo = new StackPane();
        this.dibujo = new GridPane();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(view, 8, 6);
        dibujo.add(view2, 15, 10);
        dibujo.setGridLinesVisible(true);
        dibujo.setAlignment(Pos.CENTER);

        tablero = new Canvas(800, 600);
        vista = new VistaDibujo(225, 150, tablero);
        vista.dibujar();

        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1000, 800, false, false, false, false));
        contenedorDibujo.setBackground(new Background(imagenDeFondo));
        contenedorDibujo.getChildren().addAll(tablero, dibujo);
        this.setCenter(contenedorDibujo);

        vistaPersonaje = new VistaPersonaje(controladorPersonaje, view, dibujo);
        controladorModelo.obtenerPersonaje().agregarObservador(vistaPersonaje);
    }
}
