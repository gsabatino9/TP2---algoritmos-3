package edu.fiuba.algo3.modelo;


import java.util.*;

public class Personaje implements Observado{
    private Posicion posicion;
    private Lapiz lapiz;
    private ArrayList<Algoritmo> bloquesGuardados;
    private ArrayList<Observador> observadores;

    public Personaje(Posicion posicion, Lapiz lapiz){
        this.lapiz = lapiz;
        this.posicion = posicion;
        this.bloquesGuardados = new ArrayList<>();
        this.observadores = new ArrayList<>();
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
        Algoritmo algoritmo = null;
        for (int i = 0; i < bloquesGuardados.size(); i++) {
            if (bloquesGuardados.get(i).obtenerNombre().equals(nombreAlgoritmo))
                algoritmo = bloquesGuardados.get(i);
        }
        if (algoritmo == null) {
            throw new BloquePersonalizadoNoExisteException("El bloque personalizado buscado no fue encontrado.");
        }
        return algoritmo;
    }

    public void agregarBloque(Algoritmo algoritmoPersonalizado, String nombreAlgoritmo) throws BloquePersonalizadoYaExisteException{
        if (bloquesGuardados.stream().anyMatch(bloque -> bloque.obtenerNombre().equals(nombreAlgoritmo)))
            throw new BloquePersonalizadoYaExisteException("El nombre elegido no esta disponible.");
        algoritmoPersonalizado.agregarNombre(nombreAlgoritmo);
        bloquesGuardados.add(algoritmoPersonalizado);
        notificarObservadores();
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservadores() {
        observadores.forEach(Observador::actualizar);
    }

    public ArrayList<Algoritmo> obtenerAlgoritmos() {
        return bloquesGuardados;
    }
}
