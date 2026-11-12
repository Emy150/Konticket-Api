package com.example.Proyecto_Eventos_Venta_Boletos.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}