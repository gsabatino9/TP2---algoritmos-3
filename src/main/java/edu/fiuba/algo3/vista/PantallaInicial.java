package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.evento.BotonEntrarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
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
import javafx.stage.Stage;

public class PantallaInicial extends VBox {
    private Stage stage;
    private Scene escenaInicial;

    public PantallaInicial(Stage stage){
        super();
        this.stage = stage;
        escenaInicial = new Scene(this, 640, 480);

        PantallaPrincipal principal = new PantallaPrincipal(stage);
        Scene escenaJuego = new Scene(principal, 640, 480);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image("Ash.jpeg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");
        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, escenaJuego);
        botonEntrar.setOnAction(botonEntrarHandler);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText("Bienvenidos a la aplicación MVC con JAVA FX de algoritmos y programación III. Haga click en entrar");
        etiqueta.setTextFill(Color.web("#424242"));

        Button botonComoJugar = new Button();
        botonComoJugar.setText("Como Jugar");
        OpcionComoJugarEventHandler opcionComoJugarHandler = new OpcionComoJugarEventHandler(stage, escenaInicial);
        botonComoJugar.setOnAction(opcionComoJugarHandler);

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
        botonSalir.setOnAction(botonSalirHandler);



        this.getChildren().addAll(etiqueta, botonEntrar, botonComoJugar, botonSalir);
    }

    public void inicializar(){
        stage.setScene(escenaInicial);
        stage.setFullScreen(false);
    }
}
