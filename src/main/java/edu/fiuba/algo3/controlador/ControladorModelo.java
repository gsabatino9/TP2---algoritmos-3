package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;

import java.util.Stack;

public class ControladorModelo {

    private Algoritmo algoritmo;
    private Dibujo dibujo;
    private Personaje personaje;
    private Stack<SecuenciaBloques> secuenciasAnidadas;

    public ControladorModelo(int x, int y){
        algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(x, y);
        dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        personaje = new Personaje(posicionInicio, lapiz);
        secuenciasAnidadas = new Stack<>();
        secuenciasAnidadas.push(algoritmo);
    }

    public Algoritmo obtenerAlgoritmo(){
        return algoritmo;
    }

    public Personaje obtenerPersonaje() {return personaje;}

    public Dibujo obtenerDibujo(){
        return dibujo;
    }

    public void agregarBloque(Bloque bloque){
        secuenciasAnidadas.peek().agregarBloque(bloque);
        algoritmo.notificarObservadores();
    }

    public void agregarBloqueComplejo(SecuenciaBloques bloques){
        agregarBloque(bloques);
        secuenciasAnidadas.push(bloques);
    }

    public void finalizarSecuencia(){
        secuenciasAnidadas.pop();
        personaje.notificarObservadores();
    }

    public void actualizarBloqueFinalizar(VistaBloquesColocables vista){
        if(secuenciasAnidadas.size() == 1)
            vista.desactivarBloqueFinalizar();
        else
            vista.activarBloqueFinalizar();
    }

    public void vaciarAlgoritmo(){
        algoritmo.vaciar();
        secuenciasAnidadas.clear();
        secuenciasAnidadas.push(algoritmo);
        algoritmo.notificarObservadores();
        personaje.notificarObservadores();
    }

    public void ejecutar() {
        algoritmo.ejecutar(personaje);
    }

    public void guardarAlgoritmos(String nombreAlgoritmo) throws BloquePersonalizadoYaExisteException, AlgoritmoVacioException {
        Algoritmo algoritmoCopia = algoritmo.clonar();
        algoritmoCopia.guardar(nombreAlgoritmo, personaje);
        vaciarAlgoritmo();
    }
}
