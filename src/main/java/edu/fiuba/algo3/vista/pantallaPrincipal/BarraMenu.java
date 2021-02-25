package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.vista.evento.OpcionComoJugarEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaCompletaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionPantallaMinimizadaEventHandler;
import edu.fiuba.algo3.vista.evento.OpcionSalirEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraMenu extends MenuBar {

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
    MenuItem opcionPantallaMinimizada = new MenuItem("Minimizar pantalla");


    public BarraMenu(Stage stage, Scene escenaJuego){
        //Menu menu = new Menu("Opciones");

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

        //menu.getItems().addAll(opcionSalir, opcionComoJugar, opcionReiniciar, opcionPantallaCompleta, opcionPantallaMinimizada);
        Menu menu1 = new Menu("Salir");
        menu1.getItems().add(opcionSalir);
        Menu menu2 = new Menu("Como jugar");
        menu2.getItems().add(opcionComoJugar);
        Menu menu3 = new Menu("Reiniciar");
        menu3.getItems().add(opcionReiniciar);
        Menu menu4 = new Menu("Pantalla completa");
        menu4.getItems().add(opcionPantallaCompleta);
        Menu menu5 = new Menu("Minimizar");
        menu5.getItems().add(opcionPantallaMinimizada);

        this.getMenus().addAll(menu1, menu2, menu3, menu4, menu5);
    }


}
