package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.ControladorBorrarAlgoritmo;
import edu.fiuba.algo3.controlador.ControladorBotonEjecutar;
import edu.fiuba.algo3.controlador.ControladorGuardar;
import edu.fiuba.algo3.controlador.ControladorModelo;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class PanelDerecho extends VBox {

    private VistaAlgoritmo vistaAlgoritmo;
    private ScrollPane secuenciaBloques;

    public PanelDerecho(ControladorModelo controladorModelo){
        Button ejecutar = new Button("Ejecutar");
        ejecutar.setStyle("-fx-background-color: #F7FD81; ");
        ejecutar.setMinSize(120, 25);

        Button guardar = new Button("Guardar");
        guardar.setStyle("-fx-background-color: #C8FD81; ");
        guardar.setMinSize(120, 25);

        Button borrar = new Button("Borrar Algoritmo");
        borrar.setStyle("-fx-background-color: #33C1FF; ");
        borrar.setMinSize(120, 25);

        getChildren().addAll(ejecutar, guardar, borrar, new Label("Secuencia de Bloques"));
        setSpacing(5);
        setPadding(new Insets(20));

        vistaAlgoritmo = new VistaAlgoritmo(controladorModelo.obtenerAlgoritmo());
        controladorModelo.obtenerAlgoritmo().agregarObservador(vistaAlgoritmo);
        vistaAlgoritmo.actualizar();
        secuenciaBloques = new ScrollPane(vistaAlgoritmo);
        secuenciaBloques.setMinSize(170, 25);
        getChildren().add(this.secuenciaBloques);


        ejecutar.setOnAction(new ControladorBotonEjecutar(controladorModelo));
        guardar.setOnAction(new ControladorGuardar(controladorModelo));
        borrar.setOnAction(new ControladorBorrarAlgoritmo(controladorModelo));
    }



}
