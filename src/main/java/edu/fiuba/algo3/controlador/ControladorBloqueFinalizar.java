package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloqueFinalizar implements Controlador {
    private ControladorModelo controlador;

    public ControladorBloqueFinalizar(ControladorModelo controlador){
        this.controlador = controlador;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.finalizarSecuencia();
    }
}
