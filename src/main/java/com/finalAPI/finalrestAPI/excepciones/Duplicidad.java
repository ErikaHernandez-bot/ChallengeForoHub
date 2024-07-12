package com.finalAPI.finalrestAPI.excepciones;

public class Duplicidad extends RuntimeException {
    public Duplicidad(String mensaje) {
        super(mensaje);
    }
}
