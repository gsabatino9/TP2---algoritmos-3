package edu.fiuba.algo3.controlador;
import edu.fiuba.algo3.modelo.Dibujo;
import edu.fiuba.algo3.modelo.Segmento;

import java.util.List;

public class ControladorDibujo {
    private Dibujo dibujo;

    public ControladorDibujo(Dibujo dibujo){
        this.dibujo = dibujo;
    }

    public List<Segmento> obtenerSegmentos(){
        return dibujo.obtenerSegmentos();
    }

    public Segmento obtenerSiguienteSegmento(){
        return dibujo.obtenerSiguienteSegmento();
    }
}
