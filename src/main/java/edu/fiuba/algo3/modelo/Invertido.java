package edu.fiuba.algo3.modelo;

public class Invertido extends SecuenciaBloques{

    @Override
    public void ejecutar(Personaje personaje) throws AlgoritmoVacioException{
        bloques.forEach(Bloque::invertir);
        super.ejecutar(personaje);
        bloques.forEach(Bloque::invertir);
    }

    public Invertido clonar()
    {
        Invertido bloque = new Invertido();
        bloque.agregarNombre(this.obtenerNombre());
        return bloque;
    }
}
