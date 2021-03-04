package edu.fiuba.algo3.modelo;

public class Repeticion extends SecuenciaBloques{
    private int cantidadRepeticiones;

    public Repeticion(int cantidad){
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser positiva");
        }
        this.cantidadRepeticiones = cantidad;
    }
    @Override
    public void ejecutar(Personaje personaje) {
        for (int i = 0; i < cantidadRepeticiones; i++) {
            super.ejecutar(personaje);
        }
    }

    public Repeticion clonar()
    {
        Repeticion repeticionClonado = new Repeticion(cantidadRepeticiones);
        return (Repeticion) super.clonarSecuencia(repeticionClonado);

    }
}
