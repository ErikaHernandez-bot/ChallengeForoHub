package com.finalAPI.finalrestAPI.excepciones;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensajito) {
        super(mensajito);
    }
}
