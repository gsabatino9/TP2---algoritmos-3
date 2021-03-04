package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.creadorDeBloque.*;
import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaBloquesColocables extends VBox implements Observador {
    private ControladorModelo controlador;
    private Button botonFinalizar;
    private VBox botonesPersonaje;
    private VBox botonesPersonalizados;
    private Personaje personaje;

    public VistaBloquesColocables(ControladorModelo controlador){
        this.controlador = controlador;
        getChildren().add(agregarBotonesFijos());
        setPadding(new Insets(20));
        botonesPersonaje = new VBox();
        botonesPersonalizados = new VBox();
        getChildren().addAll(botonesPersonaje, botonesPersonalizados);
        personaje = controlador.obtenerPersonaje();
    }

    private Button crearBotonSimple(Button boton, int minWidth, int minHeight, String color, CreadorDeBloque creador){
        crearBoton(boton, minWidth, minHeight, color);
        boton.setOnAction(new ControladorBloqueSimple(controlador, creador));
        return boton;
    }

    private Button crearBotonComplejo(Button boton, int minWidth, int minHeight, String color, CreadorBloqueComplejo creador){
        crearBoton(boton, minWidth, minHeight, color);
        boton.setOnAction(new ControladorBloqueComplejo(controlador, creador, this));
        return boton;
    }

    private void crearBoton(Button boton, int minWidth, int minHeight, String color){
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
    }

    private VBox agregarBotonesFijos(){
        Button bloqueDerecha = crearBotonSimple(new Button("Mover Derecha"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMover(Direccion.obtenerDerecha(), "Mover Derecha"));
        Button bloqueIzquierda = crearBotonSimple(new Button("Mover Izquierda"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMover(Direccion.obtenerIzquierda(), "Mover Izquierda"));
        Button bloqueArriba = crearBotonSimple(new Button("Mover Arriba"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMover(Direccion.obtenerArriba(), "Mover Arriba"));
        Button bloqueAbajo = crearBotonSimple(new Button("Mover Abajo"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueMover(Direccion.obtenerAbajo(), "Mover Abajo"));
        Button bloqueLevantar = crearBotonSimple(new Button("Levantar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueLapiz(new LapizLevantado(), "Levantar lapiz"));
        Button bloqueApoyar = crearBotonSimple(new Button("Apoyar lapiz"), 150, 30, "-fx-background-color: #95B2F9; ", new CreadorBloqueLapiz(new LapizApoyado(), "Apoyar lapiz"));

        Button bloqueInvertir = crearBotonComplejo(new Button("Invertir"), 150, 30, "-fx-background-color: #C781FD; ", new CreadorBloqueInvertir());
        Button bloqueRepetir2 = crearBotonComplejo(new Button("Repetir x2"), 150, 30, "-fx-background-color: #C781FD; ", new CreadorBloqueRepeticion(2));
        Button bloqueRepetir3 = crearBotonComplejo(new Button("Repetir x3"), 150, 30, "-fx-background-color: #C781FD; ", new CreadorBloqueRepeticion(3));

        botonFinalizar = new Button("Finalizar Secuencia");
        crearBoton(botonFinalizar, 150, 30, "-fx-background-color: #95b2f9; ");
        botonFinalizar.setOnAction(new ControladorBloqueFinalizar(controlador));
        botonFinalizar.setDisable(true);

        VBox botonesFijos = new VBox(new Label("Bloques disponibles"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo,
                bloqueLevantar, bloqueApoyar, bloqueInvertir, bloqueRepetir2, bloqueRepetir3, botonFinalizar);
        botonesFijos.setSpacing(5);

        return botonesFijos;
    }

    public void activarBloqueFinalizar(){
        botonFinalizar.setDisable(false);
    }

    public void desactivarBloqueFinalizar(){
        botonFinalizar.setDisable(true);
    }

    @Override
    public void actualizar() {
        ArrayList<Algoritmo> algorimosPersonalizados = personaje.obtenerAlgoritmos();
        botonesPersonalizados.getChildren().clear();

        algorimosPersonalizados.forEach(algo -> {
            Button boton = new Button(algo.obtenerNombre());
            Button personalizado = crearBotonSimple(boton, 150, 30, "-fx-background-color: #95B2F9; ",
                    new CreadorBloquePersonalizado(algo));
            botonesPersonalizados.getChildren().add(personalizado);
        });
        botonesPersonalizados.setSpacing(5);
        controlador.actualizarBloqueFinalizar(this);
    }
}
