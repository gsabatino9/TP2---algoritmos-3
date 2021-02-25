package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.evento.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaCompletaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import edu.fiuba.algo3.vista.pantallaPrincipal.PantallaPrincipal;
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

import java.util.Collections;

public class PantallaInicial extends VBox {
    private Stage stage;
    private Scene escenaInicial;

    public PantallaInicial(Stage stage){
        super();
        this.stage = stage;
        escenaInicial = new Scene(this);

        Scene escenaJuego = crearEscenaPrincipal();
        acomodarParametros();
        agregarEtiqueta();
        agregarBotones(escenaJuego);
    }

    public void inicializar(){
        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
    }

    private Scene crearEscenaPrincipal(){
        PantallaPrincipal principal = new PantallaPrincipal();
        Scene escenaJuego = new Scene(principal);
        principal.setScene(escenaJuego);
        principal.inicializar(stage);
        return escenaJuego;
    }

    private void acomodarParametros(){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1000, 800, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
    }

    private void agregarEtiqueta(){
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText("Bienvenido a AlgoBlocks");
        etiqueta.setTextFill(Color.web("#FDB281"));
        this.getChildren().addAll(etiqueta);
    }

    private void agregarBotones(Scene escenaJuego){

        Button botonEntrar = new Button("Jugar");
        botonEntrar.setOnAction(new BotonEntrarEventHandler(stage, escenaJuego));
        botonEntrar.setMinSize(90, 25);
        botonEntrar.setStyle("-fx-background-color: #fdb281; ");

        Button botonComoJugar = new Button("Como Jugar");
        botonComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaInicial));
        botonComoJugar.setMinSize(90, 25);
        botonComoJugar.setStyle("-fx-background-color: #FDB281; ");

        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(new OpcionSalirEventHandler());
        botonSalir.setMinSize(90, 25);
        botonSalir.setStyle("-fx-background-color: #FDB281; ");


        this.getChildren().addAll(botonEntrar, botonComoJugar, botonSalir);
    }

}

