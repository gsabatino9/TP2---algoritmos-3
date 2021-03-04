package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.BloquePersonalizadoYaExisteException;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ControladorBotonEjecutar implements Controlador {
    private ControladorModelo controladorModelo;
    public ControladorBotonEjecutar(ControladorModelo controladorModelo){
        this.controladorModelo = controladorModelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try{
            controladorModelo.ejecutar();
        } catch (AlgoritmoVacioException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error al ejecutar");
            alert.setHeaderText("No se puede ejecutar un Algoritmo sin Bloques");
            alert.setContentText("Agregue Bloques y ejecute nuevamente");
            alert.showAndWait();
        }
    }
}

