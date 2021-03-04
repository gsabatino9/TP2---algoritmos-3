package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PantallaPrincipal extends BorderPane {

    private VistaPersonaje vistaPersonaje;
    private BarraMenu barraMenu;
    private Scene escenaJuego;
    private ControladorModelo controladorModelo;
    private ControladorPersonaje controladorPersonaje;
    private VistaBloquesColocables vistaBloques;
    //private Canvas tablero;
    private VistaDibujo vistaDibujo;
    //private StackPane contenedorDibujo;
    private GridPane dibujo;
    //private ImageView view;
    private ControladorDibujo controladorDibujo;


    public void inicializar(Stage stage) {
        controladorModelo = new ControladorModelo(8, 5);
        controladorPersonaje = new ControladorPersonaje(controladorModelo.obtenerPersonaje());
        controladorDibujo = new ControladorDibujo(controladorModelo.obtenerDibujo());
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
        /*this.view = new ImageView();
        view.setFitWidth(50);
        view.setFitHeight(50);
        Image img = new Image("FondoCapo.png");
        view.setImage(img);

        ImageView view2 = new ImageView();
        ImageView view3 = new ImageView();

        this.contenedorDibujo = new StackPane();
        this.dibujo = new GridPane();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(view, 8, 5);
        dibujo.add(view2, 15, 10);
        dibujo.add(view3, 0, 0);
        dibujo.setGridLinesVisible(false);
        dibujo.setAlignment(Pos.CENTER);

        tablero = new Canvas(800, 550);
        vistaDibujo = new VistaDibujo(controladorDibujo, tablero);
        controladorModelo.obtenerDibujo().agregarObservador(vistaDibujo);



        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1000, 800, false, false, false, false));
        contenedorDibujo.setBackground(new Background(imagenDeFondo));
        contenedorDibujo.getChildren().addAll(tablero, dibujo);
        contenedorDibujo.setAlignment(Pos.CENTER);

        vistaPersonaje = new VistaPersonaje(controladorPersonaje, view, dibujo);
        controladorModelo.obtenerPersonaje().agregarObservador(vistaPersonaje);

        this.setCenter(contenedorDibujo);*/
        PanelCentral vistaDibujo = new PanelCentral(controladorDibujo, controladorModelo, controladorPersonaje);
        this.setCenter(vistaDibujo);
    }
}
