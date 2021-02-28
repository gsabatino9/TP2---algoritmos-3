package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.controlador.creadorDeBloque.CreadorBloqueComplejo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorBloqueComplejo implements EventHandler<ActionEvent> {

    private ControladorModelo controlador;
    private CreadorBloqueComplejo creador;

    public ControladorBloqueComplejo(ControladorModelo controlador, CreadorBloqueComplejo creador){
        this.creador = creador;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controlador.agregarBloqueComplejo(creador.crearBloque());
        //se crea un bloque Finalizar.
    }
}
