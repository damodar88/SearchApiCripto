package com.search.common.exception;

public class MapperException extends RuntimeException{
    /**
     * Constructor con mensaje de error.
     *
     * @param message Descripción del error.
     */
    public MapperException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa del error.
     *
     * @param message Descripción del error.
     * @param cause   Excepción original que causó el error.
     */
    public MapperException(String message, Throwable cause) {
        super(message, cause);
    }
}
