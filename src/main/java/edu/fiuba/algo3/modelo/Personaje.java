package edu.fiuba.algo3.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personaje implements Observado{
    private Posicion posicion;
    private Lapiz lapiz;
    private Map<String, Bloque> bloquesGuardados;
    private ArrayList<Observador> observadores;

    public Personaje(Posicion posicion, Lapiz lapiz){
        this.lapiz = lapiz;
        this.posicion = posicion;
        this.bloquesGuardados = new HashMap<>();
        this.observadores = new ArrayList<Observador>();
    }

    public void cambiarEstadoDelLapiz(EstadoLapiz nuevoEstado){
        this.lapiz.cambiarEstado(nuevoEstado);
        notificarObservadores();
    }

    public EstadoLapiz obtenerEstado()
    {
        return this.lapiz.obtenerEstado();
    }

    public void mover(Direccion direccion){
        this.lapiz.pintar(this.posicion.crearSegmento(direccion));
        this.posicion = direccion.siguientePosicion(this.posicion);
        notificarObservadores();
    }

    public Posicion devolverPosicion(){
        return this.posicion;
    }

    public Bloque obtenerAlgoritmo(String nombreAlgoritmo) throws BloquePersonalizadoNoExisteException{
        Bloque bloque = bloquesGuardados.get(nombreAlgoritmo);
        if (bloque == null) {
            throw new BloquePersonalizadoNoExisteException("El bloque personalizado buscado no fue encontrado.");
        }
        return bloque;
    }

    public void agregarBloque(Algoritmo algoritmoPersonalizado, String nombreAlgoritmo) throws BloquePersonalizadoYaExisteException{
        if (bloquesGuardados.get(nombreAlgoritmo) != null)
            throw new BloquePersonalizadoYaExisteException("El nombre elegido no esta disponible.");
        bloquesGuardados.put(nombreAlgoritmo, algoritmoPersonalizado);
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(Observador::actualizar);
    }
}
