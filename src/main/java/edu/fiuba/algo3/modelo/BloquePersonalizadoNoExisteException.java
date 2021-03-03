package edu.fiuba.algo3.modelo;

import java.util.function.Supplier;

public class BloquePersonalizadoNoExisteException extends RuntimeException{
    public BloquePersonalizadoNoExisteException(String message) {
        super(message);
    }
}
