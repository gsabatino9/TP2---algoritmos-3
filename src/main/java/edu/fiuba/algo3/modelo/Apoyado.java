package edu.fiuba.algo3.modelo;

public class Apoyado implements EstadoLapiz {
   public void pintar(Posicion posicion) {
      //interaccion con parte grafica
      posicion.pintar();
   }

   public boolean estaLevantado() {
      return false;
   }
}