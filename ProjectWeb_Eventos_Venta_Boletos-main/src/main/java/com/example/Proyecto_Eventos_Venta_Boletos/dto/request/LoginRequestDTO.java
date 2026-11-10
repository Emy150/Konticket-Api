package com.example.Proyecto_Eventos_Venta_Boletos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un formato de correo válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}