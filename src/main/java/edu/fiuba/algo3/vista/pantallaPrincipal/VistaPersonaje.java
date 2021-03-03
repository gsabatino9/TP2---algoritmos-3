package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.ControladorPersonaje;
import edu.fiuba.algo3.modelo.LapizLevantado;
import edu.fiuba.algo3.modelo.Observador;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VistaPersonaje implements Observador {

    private ControladorPersonaje controlador;
    private ImageView view;
    private GridPane grid;

    public VistaPersonaje(ControladorPersonaje controlador, ImageView view, GridPane grid) {
        this.controlador = controlador;
        this.view = view;
        this.grid = grid;
    }


    public void mostrar(GridPane dibujo){
        Image img;
        if(controlador.estadoLapizDelPersonaje() instanceof LapizLevantado)
            img = new Image("FondoCapo.png");
        else
            img = new Image("FondoTransparente.png");

        view.setImage(img);

        ImageView view2 = new ImageView();
        dibujo.getChildren().clear();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(view, controlador.obtenerX(), controlador.obtenerY());
        dibujo.add(view2, 15, 10);
        dibujo.setGridLinesVisible(false);
        dibujo.setAlignment(Pos.CENTER);
    }


    @Override
    public void actualizar() {
        mostrar(this.grid);
    }
}