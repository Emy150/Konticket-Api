package com.example.Proyecto_Eventos_Venta_Boletos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthResponseDTO {
    private String token;
    private String type; // "Bearer"
    private String email;
    private String rol;
}