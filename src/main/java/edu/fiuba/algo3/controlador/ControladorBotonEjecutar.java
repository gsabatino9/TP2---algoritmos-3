package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.pantallaPrincipal.VistaAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControladorBotonEjecutar implements EventHandler<ActionEvent> {
    private ControladorModelo controladorModelo;
    private VBox contenedor;
    private VistaAlgoritmo vistaAlgo;
    private ScrollPane secuenciaBloques;

    public ControladorBotonEjecutar(ControladorModelo controladorModelo, VBox contenedor, VistaAlgoritmo vistaAlgo,
                                    ScrollPane secuenciaDeBloques){
        this.controladorModelo = controladorModelo;
        this.contenedor = contenedor;
        this.vistaAlgo = vistaAlgo;
        this.secuenciaBloques = secuenciaDeBloques;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        controladorModelo.ejecutar();
        controladorModelo.vaciarSecuencia();

        contenedor.getChildren().remove(this.secuenciaBloques);
        vistaAlgo.actualizar();
        secuenciaBloques = new ScrollPane(vistaAlgo);
        secuenciaBloques.setMinSize(170, 25);
        contenedor.getChildren().add(this.secuenciaBloques);
    }
}

