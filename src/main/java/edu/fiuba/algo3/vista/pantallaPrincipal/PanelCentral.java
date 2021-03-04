package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.ControladorModelo;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class PanelCentral extends StackPane {
    private VistaPersonaje vistaPersonaje;
    private VistaDibujo vistaDibujo;
    private ImageView imageView;
    private GridPane dibujo;
    private Canvas tablero;

    public PanelCentral(ControladorModelo controladorModelo)
    {
        imageView = new ImageView();
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Image img = new Image("LapizLevantado.png");
        imageView.setImage(img);

        ImageView view2 = new ImageView();
        ImageView view3 = new ImageView();

        this.dibujo = new GridPane();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(imageView, 8, 5);
        dibujo.add(view2, 15, 10);
        dibujo.add(view3, 0, 0);
        dibujo.setGridLinesVisible(false);
        dibujo.setAlignment(Pos.CENTER);

        tablero = new Canvas(800, 550);
        vistaDibujo = new VistaDibujo(controladorModelo.obtenerDibujo(), tablero);
        controladorModelo.obtenerDibujo().agregarObservador(vistaDibujo);



        Image imagen = new Image("Fond.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1000, 800, false, false, false, false));
        this.setBackground(new Background(imagenDeFondo));
        this.getChildren().addAll(tablero, dibujo);
        this.setAlignment(Pos.CENTER);

        vistaPersonaje = new VistaPersonaje(controladorModelo.obtenerPersonaje(), imageView, dibujo);
        controladorModelo.obtenerPersonaje().agregarObservador(vistaPersonaje);
    }
}
