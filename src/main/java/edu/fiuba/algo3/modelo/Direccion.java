package edu.fiuba.algo3.modelo;

public class Direccion {

    private static Direccion arriba;
    private static Direccion abajo;
    private static Direccion izquierda;
    private static Direccion derecha;

    private int x;
    private int y;

    static {
        arriba = new Direccion(0, 1);
        abajo = new Direccion(0, -1);
        izquierda = new Direccion(-1, 0);
        derecha = new Direccion(1, 0);
    }

    private Direccion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Posicion siguientePosicion(Posicion posicionActual){
        int columna = posicionActual.obtenerColumna() + this.x;
        int fila = posicionActual.obtenerFila() + this.y;

        return new Posicion(columna, fila);
    }

    public static Direccion obtenerArriba() {
        return arriba;
    }

    public static Direccion obtenerAbajo() {
        return abajo;
    }

    public static Direccion obtenerIzquierda() {
        return izquierda;
    }

    public static Direccion obtenerDerecha() {
        return derecha;
    }
}
