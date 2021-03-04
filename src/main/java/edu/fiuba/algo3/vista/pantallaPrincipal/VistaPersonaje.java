package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class VistaPersonaje implements Observador {

    private Personaje personaje;
    private ImageView view;
    private GridPane grid;
    private int x;
    private int y;

    public VistaPersonaje(Personaje unPersonaje, ImageView view, GridPane grid) {
        this.personaje = unPersonaje;
        this.view = view;
        this.grid = grid;
        this.x = personaje.obtenerColumna();
        this.y = personaje.obtenerFila();
    }


    public void mostrar(GridPane dibujo){
        Image img;

        img = new Image(personaje.obtenerEstado().obtenerNombre() + ".png");
        view.setImage(img);


        ImageView view2 = new ImageView();
        dibujo.getChildren().clear();
        dibujo.setMinWidth(800);
        dibujo.setMinHeight(600);
        dibujo.setHgap(50);
        dibujo.setVgap(50);
        dibujo.add(view, personaje.obtenerColumna(), personaje.obtenerFila());
        dibujo.add(view2, 15, 10);
        dibujo.setGridLinesVisible(false);
        dibujo.setAlignment(Pos.CENTER);
    }


    @Override
    public void actualizar() {
        mostrar(this.grid);
        x = personaje.obtenerColumna();
        y = personaje.obtenerFila();
    }
}
