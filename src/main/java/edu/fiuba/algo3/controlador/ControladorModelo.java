package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.pantallaPrincipal.VistaBloquesColocables;

import java.util.Stack;

public class ControladorModelo {

    private Algoritmo algoritmo;
    private Dibujo dibujo;
    private Personaje personaje;
    private Stack<SecuenciaBloques> secuenciasAnidadas;

    public ControladorModelo(){
        algoritmo = new Algoritmo();
        Posicion posicionInicio = new Posicion(0, 0);
        dibujo = new Dibujo();
        Lapiz lapiz = new Lapiz(dibujo);
        personaje = new Personaje(posicionInicio, lapiz);
        secuenciasAnidadas = new Stack<>();
        secuenciasAnidadas.push(algoritmo);
    }

    public Algoritmo obtenerAlgoritmo(){
        return algoritmo;
    }

    public void agregarBloque(Bloque bloque){
        secuenciasAnidadas.peek().agregarBloque(bloque);
        algoritmo.notificarObservadores();
    }

    public void agregarBloqueComplejo(SecuenciaBloques bloques){
        agregarBloque(bloques);
        secuenciasAnidadas.push(bloques);
    }

    public void finalizarSecuencia(VistaBloquesColocables vista){
        secuenciasAnidadas.pop();
        if(secuenciasAnidadas.size() == 1)
            vista.desactivarBloqueFinalizar();
    }
}
