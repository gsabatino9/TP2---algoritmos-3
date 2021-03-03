package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.BloquePersonalizadoYaExisteException;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorGuardar implements EventHandler<ActionEvent> {

    private ControladorModelo controladorModelo;

    public ControladorGuardar(ControladorModelo controladorModelo){
        this.controladorModelo = controladorModelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //pedir el nombre para el nuevo algoritmo

        try {
            controladorModelo.guardarAlgoritmos("Algo Nuevo 123");
        } catch (BloquePersonalizadoYaExisteException e) {
            //pedir de nuevo el nombre de algoritmo
        }
    }
}
