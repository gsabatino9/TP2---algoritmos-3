package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaPrincipal extends BorderPane {

    private BarraMenu barraMenu;
    private Scene escenaJuego;
    private ControladorModelo controladorModelo;
    private VistaBloquesColocables vistaBloques;


    public void inicializar(Stage stage) {
        controladorModelo = new ControladorModelo(8, 5);
        setMenu(stage);
        setBotonera();
        setContenedor();
        setDibujo();
    }

    public void setScene(Scene escenaJuego) {
        this.escenaJuego = escenaJuego;
    }

    public void setMenu(Stage stage) {
        barraMenu = new BarraMenu(stage, escenaJuego, this);
        this.setTop(barraMenu);
    }

    public void setBotonera() {
        vistaBloques = new VistaBloquesColocables(controladorModelo);
        controladorModelo.obtenerPersonaje().agregarObservador(vistaBloques);
        this.setLeft(vistaBloques);
    }

    public void setContenedor() {
        PanelDerecho vistaAlgoritmo = new PanelDerecho(controladorModelo);
        setRight(vistaAlgoritmo);
    }

    public void setDibujo(){
        PanelCentral vistaDibujo = new PanelCentral(controladorModelo);
        this.setCenter(vistaDibujo);
    }
}
