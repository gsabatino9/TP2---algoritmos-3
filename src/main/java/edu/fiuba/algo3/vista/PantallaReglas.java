package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.evento.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PantallaReglas extends VBox {

    private Stage stage;
    private Scene escenaAnterior;

    public PantallaReglas(Stage stage, Scene escenaAnterior){
        this.stage = stage;
        this.escenaAnterior = escenaAnterior;


        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label ponerBloques = crearEtiqueta("Por cada bloque que se inserte, el personaje realizará una acción");
        Label mover = crearEtiqueta("Los bloques mover sirven para desplazar al personaje por la pizarra");
        Label lapiz = crearEtiqueta("Si te moves con el lápiz apoyado, el personaje pintará");
        Label especiales = crearEtiqueta("Podes invertir el recorrido de los bloques, o repetir toda la secuencia");

        Button botonVolver = new Button();
        botonVolver.setText("Atras");
        BotonEntrarEventHandler botonVolverHandler = new BotonEntrarEventHandler(stage, escenaAnterior);
        botonVolver.setOnAction(botonVolverHandler);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);

        HBox botones = new HBox();
        botones.getChildren().addAll(botonVolver, botonSalir);
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(10);

        this.getChildren().addAll(ponerBloques, mover, lapiz, especiales, botones);


    }
    private Label crearEtiqueta(String texto){
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        etiqueta.setText(texto);
        etiqueta.setTextFill(Color.web("#FDB281"));
        return etiqueta;
    }
}
