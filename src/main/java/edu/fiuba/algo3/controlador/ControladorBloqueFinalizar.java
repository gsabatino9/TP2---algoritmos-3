package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloqueFinalizar implements EventHandler<ActionEvent> {
    private VistaBloquesColocables vistaBloques;
    private ControladorModelo controlador;

    public ControladorBloqueFinalizar(VistaBloquesColocables vista, ControladorModelo controlador){
        vistaBloques = vista;
        this.controlador = controlador;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.finalizarSecuencia(vistaBloques);
    }
}
