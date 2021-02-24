package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaCompletaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaMinimizadaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionPantallaMinimizada = new MenuItem("Minimizar pantalla");


    public BarraMenu(Stage stage, Scene escenaJuego){
        Menu menu = new Menu("Opciones");

        MenuItem opcionSalir = new MenuItem("Salir");
        opcionSalir.setOnAction(new OpcionSalirEventHandler());

        MenuItem opcionComoJugar = new MenuItem("Como Jugar");
        opcionComoJugar.setOnAction(new OpcionComoJugarEventHandler(stage, escenaJuego));

        MenuItem opcionReiniciar = new MenuItem("Reiniciar");
        //FALTA EVENTHANDLER PARA OPCION REINICIAR

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta, opcionPantallaMinimizada);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);
        opcionPantallaMinimizada.setOnAction(new OpcionPantallaMinimizadaEventHandler(stage, opcionPantallaMinimizada, opcionPantallaCompleta));
        opcionPantallaMinimizada.setDisable(true);

        menu.getItems().addAll(opcionSalir, opcionComoJugar, opcionReiniciar, opcionPantallaCompleta, opcionPantallaMinimizada);


        this.getMenus().addAll(menu);
    }


}
