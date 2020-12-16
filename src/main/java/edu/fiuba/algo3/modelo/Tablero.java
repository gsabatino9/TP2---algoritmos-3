package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private Personaje personaje;
    private Posicion posiciones[][] = new Posicion[3][3];
    private Algoritmo algoritmo;

    Tablero(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
              this.posiciones[i][j] = new Posicion();
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                this.relacionarPosicion(i, j);
            }
        }

        this.posiciones[1][1].cambiarEstado();

        this.personaje = new Personaje(this.posiciones[1][1]);
        this.algoritmo = new Algoritmo();
    }

    public void relacionarPosicion(int fila, int columna){
        if(columna == 0){
            this.posiciones[fila][columna].agregarIzquierda(posiciones[fila][columna+2]);
            this.posiciones[fila][columna].agregarDerecha(posiciones[fila][columna+1]);
        }else if(columna == 2){
            this.posiciones[fila][columna].agregarIzquierda(posiciones[fila][columna-1]);
            this.posiciones[fila][columna].agregarDerecha(posiciones[fila][columna-2]);
        }else{
            this.posiciones[fila][columna].agregarIzquierda(posiciones[fila][columna-1]);
            this.posiciones[fila][columna].agregarDerecha(posiciones[fila][columna+1]);
        }

        if(fila  == 0){
            this.posiciones[fila][columna].agregarArriba(posiciones[fila+2][columna]);
            this.posiciones[fila][columna].agregarAbajo(posiciones[fila+1][columna]);
        }else if(fila == 2){
            this.posiciones[fila][columna].agregarArriba(posiciones[fila-1][columna]);
            this.posiciones[fila][columna].agregarAbajo(posiciones[fila-2][columna]);
        }else{
            this.posiciones[fila][columna].agregarArriba(posiciones[fila-1][columna]);
            this.posiciones[fila][columna].agregarAbajo(posiciones[fila+1][columna]);
        }
    }

    public void agregarBloque(Bloque bloque){
        this.algoritmo.agregarBloque(bloque);
    }

    public void realizarSecuencia(){
        this.algoritmo.realizarSecuencia(this.personaje);
    }

    public Posicion posicionDelPersonaje(){
        return this.personaje.posicion();
    }

    public Posicion obtenerPosicion(int fila, int columna){
        return this.posiciones[fila][columna];
    }
}
