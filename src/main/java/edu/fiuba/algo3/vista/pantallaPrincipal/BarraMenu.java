package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BarraMenu extends HBox {

    public BarraMenu(Stage stage, Scene escenaJuego, PantallaPrincipal pantallaPrincipal){

        Button opcionSalir = crearBoton("Salir", 90, 25, "-fx-background-color: #CECFC3; ");
        opcionSalir.setOnAction(new OpcionSalirEventHandler());

        Button opcionComoJugar = crearBoton("Como jugar", 90, 25, "-fx-background-color: #CECFC3; ");
        opcionComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaJuego));

        Button opcionReiniciar = crearBoton("Reiniciar", 90, 25, "-fx-background-color: #CECFC3; ");
        opcionReiniciar.setOnAction(new OpcionReiniciarEventHandler(stage, escenaJuego, pantallaPrincipal));

        this.getChildren().addAll(opcionComoJugar, opcionReiniciar, opcionSalir);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    public Button crearBoton(String text, int minWidth, int minHeight, String color){
        Button boton = new Button(text);
        boton.setStyle(color);
        boton.setMinSize(minWidth, minHeight);
        return boton;
    }

}
