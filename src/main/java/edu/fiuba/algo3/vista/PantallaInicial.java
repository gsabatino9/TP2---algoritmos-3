package edu.fiuba.algo3.vista;

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
import javafx.stage.Stage;

public class PantallaInicial extends VBox {
    private Stage stage;
    private Scene escenaInicial;

    public PantallaInicial(Stage stage){
        super();
        this.stage = stage;
        escenaInicial = new Scene(this, 640, 480);


        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("Ash.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Entrar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

        etiqueta.setText("Bienvenidos a la aplicación MVC con JAVA FX de algoritmos y programación III. Haga click en entrar");
        etiqueta.setTextFill(Color.web("#66A7C5"));

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        //BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        //botonEntrar.setOnAction(botonEntrarHandler);


        //PantallaPrincipal principal = new PantallaPrincipal(stage);
        //Scene escenaJuego = new Scene(principal, 640, 480);


        this.getChildren().addAll(etiqueta, botonEntrar, botonSalir);
    }

    public void inicializar(){
        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
    }
}
