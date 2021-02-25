package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaCompletaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaMinimizadaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BarraMenu extends HBox {

    public BarraMenu(Stage stage, Scene escenaJuego){
        //Menu menu = new Menu("Opciones");

        Button opcionSalir = new Button("Salir");
        opcionSalir.setOnAction(new OpcionSalirEventHandler());

        Button opcionComoJugar = new Button("Como Jugar");
        opcionComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaJuego));

        Button opcionReiniciar = new Button("Reiniciar");
        //FALTA EVENTHANDLER PARA OPCION REINICIAR


        this.getChildren().addAll(opcionComoJugar, opcionReiniciar, opcionSalir);
    }


}
