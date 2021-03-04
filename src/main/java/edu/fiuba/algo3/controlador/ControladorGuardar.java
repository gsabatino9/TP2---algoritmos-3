package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.AlgoritmoVacioException;
import edu.fiuba.algo3.modelo.BloquePersonalizadoYaExisteException;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class ControladorGuardar implements EventHandler<ActionEvent> {

    private ControladorModelo controladorModelo;

    public ControladorGuardar(ControladorModelo controladorModelo) {
        this.controladorModelo = controladorModelo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextInputDialog dialog = new TextInputDialog("Ingrese un nombre");
        dialog.setTitle("Input name");
        dialog.setHeaderText("Ingrese el nombre de su bloque personalizado");
        dialog.setContentText("Escriba el nombre");

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            try {
                controladorModelo.guardarAlgoritmos(result.get());
                controladorModelo.vaciarAlgoritmo();
            } catch (BloquePersonalizadoYaExisteException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error al guardar");
                alert.setHeaderText("El nombre que esta intentando ingresar ya existe");
                alert.setContentText("Ingrese otro nombre!");
                alert.showAndWait();
            } catch (AlgoritmoVacioException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error al guardar");
                alert.setHeaderText("No se puede guardar un Algoritmo sin Bloques");
                alert.setContentText("Agregue Bloques y guarde nuevamente");
                alert.showAndWait();
            }
        }
    }
}
