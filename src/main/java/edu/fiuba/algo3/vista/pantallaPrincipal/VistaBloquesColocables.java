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


    private Button crearBoton(CreadorDeBloque creador, Controlador controladorBloque, String color){
        Bloque bloque = creador.crearBloque();
        Button boton = new Button(bloque.obtenerNombre());
        crearBotonVisual(boton, 150, 30, color);
        boton.setOnAction(controladorBloque);
        return boton;
    }


    private Button crearBotonComplejo(CreadorBloqueComplejo creador, Controlador controladorBloque) {
        Bloque bloque = creador.crearBloque();
        Button boton = new Button(bloque.obtenerNombre());
        crearBotonVisual(boton, 150, 30, "-fx-background-color: #F995B2; ");
        boton.setOnAction(controladorBloque);
        return boton;
    }

    private Button crearBotonFinalizar(){
        Button boton = new Button("Finalizar Secuencia");
        crearBotonVisual(boton, 150, 30, "-fx-background-color: #F995B2; ");
        boton.setOnAction(new ControladorBloqueFinalizar(controlador));
        boton.setDisable(true);
        return boton;
    }

    private void crearBotonVisual(Button boton, int minWidth, int minHeight, String color){
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
    }

    private VBox agregarBotonesFijos(){
        CreadorBloqueMover creadorBloqueMover = new CreadorBloqueMover(Direccion.obtenerDerecha(), "Mover Derecha");
        Button bloqueDerecha = crearBoton(creadorBloqueMover, new ControladorBloqueSimple(controlador, creadorBloqueMover), "-fx-background-color: #ADC4FA; ");

        CreadorBloqueMover creadorBloqueIzquierda = new CreadorBloqueMover(Direccion.obtenerIzquierda(), "Mover Izquierda");
        Button bloqueIzquierda = crearBoton(creadorBloqueIzquierda, new ControladorBloqueSimple(controlador, creadorBloqueIzquierda), "-fx-background-color: #ADC4FA; ");

        CreadorBloqueMover creadorBloqueArriba = new CreadorBloqueMover(Direccion.obtenerArriba(), "Mover Arriba");
        Button bloqueArriba = crearBoton(creadorBloqueArriba, new ControladorBloqueSimple(controlador, creadorBloqueArriba), "-fx-background-color: #ADC4FA; ");

        CreadorBloqueMover creadorBloqueAbajo = new CreadorBloqueMover(Direccion.obtenerAbajo(), "Mover Abajo");
        Button bloqueAbajo = crearBoton(creadorBloqueAbajo, new ControladorBloqueSimple(controlador, creadorBloqueAbajo), "-fx-background-color: #ADC4FA; ");

        CreadorBloqueLapiz creadorBloqueLevantado = new CreadorBloqueLapiz(new LapizLevantado(), "Levantar lapiz");
        Button bloqueLevantado = crearBoton(creadorBloqueLevantado, new ControladorBloqueSimple(controlador, creadorBloqueLevantado), "-fx-background-color: #ADC4FA; ");

        CreadorBloqueLapiz creadorBloqueApoyado = new CreadorBloqueLapiz(new LapizApoyado(), "Apoyar lapiz");
        Button bloqueApoyado = crearBoton(creadorBloqueApoyado, new ControladorBloqueSimple(controlador, creadorBloqueApoyado), "-fx-background-color: #ADC4FA; ");


        CreadorBloqueInvertir creadorBloqueInvertir = new CreadorBloqueInvertir();
        Button bloqueInvertir = crearBotonComplejo(creadorBloqueInvertir, new ControladorBloqueComplejo(controlador, creadorBloqueInvertir, this));

        CreadorBloqueRepeticion creadorRepetir2 = new CreadorBloqueRepeticion(2);
        Button bloqueRepetir2 = crearBotonComplejo(creadorRepetir2, new ControladorBloqueComplejo(controlador, creadorRepetir2, this));

        CreadorBloqueRepeticion creadorRepetir3 = new CreadorBloqueRepeticion(3);
        Button bloqueRepetir3 = crearBotonComplejo(creadorRepetir3, new ControladorBloqueComplejo(controlador, creadorRepetir3, this));

        botonFinalizar = crearBotonFinalizar();

        VBox botonesFijos = new VBox(new Label("Bloques disponibles"),  bloqueDerecha, bloqueIzquierda, bloqueArriba, bloqueAbajo, bloqueLevantado, bloqueApoyado,
               bloqueInvertir, bloqueRepetir2, bloqueRepetir3, botonFinalizar);

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
            CreadorBloquePersonalizado creadorBloque = new CreadorBloquePersonalizado(algo);
            Button personalizado = crearBoton(creadorBloque, new ControladorBloqueSimple(controlador, creadorBloque), "-fx-background-color: #AA95F9; ");
            botonesPersonalizados.getChildren().add(personalizado);
        });

        botonesPersonalizados.setSpacing(5);
        controlador.actualizarBloqueFinalizar(this);
    }
}
