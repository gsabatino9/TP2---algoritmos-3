package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje {
    private Posicion posicion;
    private Lapiz lapiz;
    private Map<String, Bloque> bloquesGuardados;

    Personaje(Posicion posicion, Lapiz lapiz){
        this.lapiz = lapiz;

        this.posicion = posicion;

        this.bloquesGuardados = new HashMap<String, Bloque>();

        /*posicion.cambiarEstado();*/
    }

    public void cambiarEstadoDelLapiz(EstadoLapiz nuevoEstado){
        this.lapiz.cambiarEstado(nuevoEstado);
    }

    public EstadoLapiz obtenerEstado()
    {
        return this.lapiz.obtenerEstado();
    }

    public void mover(Direccion direccion){
        this.lapiz.pintar(this.posicion.crearSegmento(direccion));
        /*this.posicion.cambiarEstado();*/
        this.posicion = direccion.siguientePosicion(this.posicion);
        /*this.posicion.cambiarEstado();*/
    }

    public Posicion devolverPosicion(){
        return this.posicion;
    }

    public boolean algoritmoEstaGuardado(String nombreAlgoritmo) {
        Bloque bloquePedido = obtenerAlgoritmo(nombreAlgoritmo);
        return (bloquePedido != null);
    }

    public Bloque obtenerAlgoritmo(String nombreAlgoritmo) {
        return bloquesGuardados.get(nombreAlgoritmo);
    }

    public void agregarBloque(Algoritmo algoritmoPersonalizado, String nombreAlgoritmo){
        bloquesGuardados.put(nombreAlgoritmo, algoritmoPersonalizado);
    }
}
