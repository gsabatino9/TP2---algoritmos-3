package edu.fiuba.algo3.vista.pantallaPrincipal;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaPersonaje {
    //private Personaje personaje;
    Canvas canvas;
    private int x;
    private int y;

    public VistaPersonaje(int x, int y, Canvas canvas) {
        this.x = x;
        this.y = y;
        this.canvas = canvas;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
        //this.clean();
        canvas.getGraphicsContext2D().setFill(Color.BLUE);
        canvas.getGraphicsContext2D().strokeLine(x + 50, y, x, y);
    }

    /*public void clean() {
        canvas.getGraphicsContext2D().setFill(Color.BEIGE);
        canvas.getGraphicsContext2D().fillRect(0, 0, 460, 220);
    }*/
}
