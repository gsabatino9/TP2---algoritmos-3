package edu.fiuba.algo3.modelo;

public class Personaje {
    private Posicion posicion;
    private Lapiz lapiz;

    Personaje(Posicion posicion){
        this.lapiz = new Lapiz(new Dibujo());

        this.posicion = posicion;
        posicion.cambiarEstado();
    }

    public void cambiarEstadoDelLapiz(EstadoLapiz nuevoEstado){
        this.lapiz.cambiarEstado(nuevoEstado);
    }

    public EstadoLapiz obtenerEstado()
    {
        return this.lapiz.obtenerEstado();
    }

    public void mover(Direccion direccion){
        this.lapiz.pintar(this.posicion);
        this.posicion.cambiarEstado();
        this.posicion = direccion.siguientePosicion(this.posicion);
        this.posicion.cambiarEstado();
    }

    public Posicion devolverPosicion(){
        return this.posicion;
    }

}
