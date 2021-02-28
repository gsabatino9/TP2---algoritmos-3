package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.creadorDeBloque.CreadorBloqueComplejo;
import edu.fiuba.algo3.controlador.creadorDeBloque.CreadorBloqueMoverDerecha;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorBloqueComplejo implements EventHandler<ActionEvent> {

    private ControladorModelo controlador;
    private CreadorBloqueComplejo creador;
    private VistaBloquesColocables vistaBloquesColocables;

    public ControladorBloqueComplejo(ControladorModelo controlador, CreadorBloqueComplejo creador, VistaBloquesColocables bloquesColocables){
        this.creador = creador;
        this.controlador = controlador;
        vistaBloquesColocables = bloquesColocables;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.agregarBloqueComplejo(creador.crearBloque());
        vistaBloquesColocables.activarBloqueFinalizar();
    }
}
