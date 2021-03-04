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
        Invertido invertidoClonado = new Invertido();
        return (Invertido) super.clonarSecuencia(invertidoClonado);

    }
}
