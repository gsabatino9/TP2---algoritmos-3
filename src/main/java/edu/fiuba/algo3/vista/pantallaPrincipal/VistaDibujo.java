package edu.fiuba.algo3.vista.pantallaPrincipal;


import edu.fiuba.algo3.modelo.Dibujo;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Segmento;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.List;

public class VistaDibujo implements Observador {
    private Dibujo dibujo;
    Canvas canvas;

    public VistaDibujo(Dibujo unDibujo, Canvas canvas) {
        this.dibujo = unDibujo;
        this.canvas = canvas;
    }

    private void dibujarFormas(Segmento segmento) {
        int x1 = segmento.obtenerInicio().obtenerColumna()*50;
        int x2 = segmento.obtenerFin().obtenerColumna()*50;

        int y1 = segmento.obtenerInicio().obtenerFila()*50;
        int y2 = segmento.obtenerFin().obtenerFila()*50;

        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        canvas.getGraphicsContext2D().setStroke(Color.WHITE);
        canvas.getGraphicsContext2D().setLineWidth(3);
        canvas.getGraphicsContext2D().strokeLine(x1 + 25, y1 + 25, x2 + 25, y2 + 25);
    }

    public void dibujar(){
        List<Segmento> segmentos = dibujo.obtenerSegmentos();
        for(int i = 0; i < segmentos.size(); i++){
            dibujarFormas(segmentos.get(i));
        }
    }

    @Override
    public void actualizar() {
        dibujar();
    }
}
