package edu.fiuba.algo3.vista.pantallaPrincipal;

import edu.fiuba.algo3.modelo.Algoritmo;
import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Observador;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaAlgoritmo extends VBox implements Observador {
    private Algoritmo algoritmo;

    public VistaAlgoritmo(Algoritmo algoritmo){
        this.algoritmo = algoritmo;
        setSpacing(5);
    }

    private Button crearBoton(String nombre, double minWidth, double minHeight, String color){
        Button boton = new Button(nombre);
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
        return boton;
    }


    public void mostrar(ArrayList<Bloque> listaBloques, double ancho, double alto, VBox celda){
        listaBloques.forEach((bloque) -> {
            Button boton = crearBoton(bloque.obtenerNombre(), ancho, alto, "-fx-background-color: #95B2F9; ");
            VBox anidado = new VBox();
            mostrar(bloque.obtenerHijos(), ancho * 0.85, alto * 0.85, anidado);
            celda.getChildren().add(boton);
            celda.getChildren().add(anidado);
            celda.setSpacing(5);
        });
    }

    @Override
    public void actualizar() {
        getChildren().clear();
        mostrar(algoritmo.obtenerHijos(), 150, 30, this);
    }
}
