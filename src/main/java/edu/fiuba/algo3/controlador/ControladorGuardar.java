package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorGuardar implements EventHandler<ActionEvent> {

    private ControladorModelo controladorModelo;
    private  VistaBloquesColocables botoneras;

    ControladorGuardar(ControladorModelo controladorModelo, VistaBloquesColocables botoneras){
        this.controladorModelo = controladorModelo;
        this.botoneras =  botoneras;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorModelo.guardarAlgoritmo(botoneras);
    }
}
