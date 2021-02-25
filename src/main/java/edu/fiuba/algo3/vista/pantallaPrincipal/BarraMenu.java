package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BarraMenu extends HBox {

    public BarraMenu(Stage stage, Scene escenaJuego, PantallaPrincipal pantallaPrincipal){
        //Menu menu = new Menu("Opciones");

        Button opcionSalir = new Button("Salir");
        opcionSalir.setOnAction(new OpcionSalirEventHandler());
        opcionSalir.setStyle("-fx-background-color: #CECFC3; ");
        opcionSalir.setMinSize(90, 25);

        Button opcionComoJugar = new Button("Como Jugar");
        opcionComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaJuego));
        opcionComoJugar.setStyle("-fx-background-color: #CECFC3; ");
        opcionComoJugar.setMinSize(90, 25);

        Button opcionReiniciar = new Button("Reiniciar");
        opcionReiniciar.setStyle("-fx-background-color: #CECFC3; ");
        opcionReiniciar.setMinSize(90, 25);
        opcionReiniciar.setOnAction(new OpcionReiniciarEventHandler(stage, escenaJuego, pantallaPrincipal));
        //FALTA EVENTHANDLER PARA OPCION REINICIAR


        this.getChildren().addAll(opcionComoJugar, opcionReiniciar, opcionSalir);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }


}
