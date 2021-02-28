package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.ControladorBloqueComplejo;
import edu.fiuba.algo3.controlador.ControladorBloqueSimple;
import edu.fiuba.algo3.controlador.ControladorModelo;
import edu.fiuba.algo3.controlador.creadorDeBloque.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaBloquesColocables extends VBox {
    private ControladorModelo controlador;

    public VistaBloquesColocables(ControladorModelo controlador){
        this.controlador = controlador;
        getChildren().add(agregarBotonesSimples());
        setPadding(new Insets(20));
    }


    private Button crearBotonSimple(Button boton, int minWidth, int minHeight, String color, CreadorDeBloque creador){
        crearBoton(boton, minWidth, minHeight, color);
        boton.setOnAction(new ControladorBloqueSimple(controlador, creador));
        return boton;
    }

    private Button crearBotonComplejo(Button boton, int minWidth, int minHeight, String color, CreadorBloqueComplejo creador){
        crearBoton(boton, minWidth, minHeight, color);
        boton.setOnAction(new ControladorBloqueComplejo(controlador, creador));
        return boton;
    }

    private void crearBoton(Button boton, int minWidth, int minHeight, String color){
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
    }

    private VBox agregarBotonesSimples(){
        Button bloqueDerecha = crearBotonSimple(new Button("Mover Derecha"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMoverDerecha());
        Button bloqueIzquierda = crearBotonSimple(new Button("Mover Izquierda"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMoverIzquierda());
        Button bloqueArriba = crearBotonSimple(new Button("Mover Arriba"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMoverArriba());
        Button bloqueAbajo = crearBotonSimple(new Button("Mover Abajo"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMoverAbajo());
        Button bloqueLevantar = crearBotonSimple(new Button("Levantar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueLevantarLapiz());
        Button bloqueApoyar = crearBotonSimple(new Button("Apoyar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueApoyarLapiz());

        Button bloqueInvertir = crearBotonComplejo(new Button("Invertir"), 150, 30, "-fx-background-color: #C781FD; ", new CreadorBloqueInvertir());
        Button bloqueRepetir = crearBotonComplejo(new Button("Repetir x2"), 150, 30, "-fx-background-color: #C781FD; ", new CreadorBloqueRepeticion(2));

        VBox bottomControl = new VBox(new Label("Bloques disponibles"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo, bloqueLevantar, bloqueApoyar, bloqueInvertir, bloqueRepetir);
        bottomControl.setSpacing(5);

        return bottomControl;
    }
}
