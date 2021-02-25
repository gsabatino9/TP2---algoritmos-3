package edu.fiuba.algo3.vista.evento;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BloqueEventHandler implements EventHandler<ActionEvent> {
    private VBox secuencia;
    private String text;
    private int minWidth;
    private int minHeight;
    private String color;


    public BloqueEventHandler(String text, int minWidth, int minHeight, String color, VBox secuencia){
        this.secuencia = secuencia;
        this.text = text;
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.color = color;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button boton = new Button(text);
        boton.setMinSize(minWidth, minHeight);
        boton.setStyle(color);
        secuencia.getChildren().add(boton);
    }
}
