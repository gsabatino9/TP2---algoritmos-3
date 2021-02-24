package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.evento.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
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

public class PantallaInicial extends VBox {
    private Stage stage;
    private Scene escenaInicial;

    public PantallaInicial(Stage stage){
        super();
        this.stage = stage;
        escenaInicial = new Scene(this, 640, 480);

        Scene escenaJuego = crearEscenaPrincipal();
        acomodarParametros();
        agregarEtiqueta();
        agregarBotones(escenaJuego);
    }

    public void inicializar(){
        stage.setScene(escenaInicial);
        stage.setFullScreen(false);
    }

    private Scene crearEscenaPrincipal(){
        PantallaPrincipal principal = new PantallaPrincipal();
        Scene escenaJuego = new Scene(principal, 640, 480);
        principal.setScene(escenaJuego);
        principal.inicializar(stage);
        return escenaJuego;
    }

    private void acomodarParametros(){
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("Nubes.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    private void agregarEtiqueta(){
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText("Bienvenidos a la aplicación MVC con JAVA FX de algoritmos y programación III. Haga click en entrar");
        etiqueta.setTextFill(Color.web("#424242"));
        this.getChildren().addAll(etiqueta);
    }

    private void agregarBotones(Scene escenaJuego){

        Button botonEntrar = new Button("Jugar");
        botonEntrar.setOnAction(new BotonEntrarEventHandler(stage, escenaJuego));

        Button botonComoJugar = new Button("Como Jugar");
        botonComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaInicial));

        Button botonSalir = new Button("Salir");
        botonSalir.setOnAction(new OpcionSalirEventHandler());

        this.getChildren().addAll(botonEntrar, botonComoJugar, botonSalir);
    }
}

