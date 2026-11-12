package com.example.Proyecto_Eventos_Venta_Boletos.exception;

public class SinStockException extends RuntimeException {
    public SinStockException(String message) {
        super(message);
    }
}