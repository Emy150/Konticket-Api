package com.example.Proyecto_Eventos_Venta_Boletos.controller;

import com.example.Proyecto_Eventos_Venta_Boletos.dto.request.LoginRequestDTO;
import com.example.Proyecto_Eventos_Venta_Boletos.dto.response.AuthResponseDTO;
import com.example.Proyecto_Eventos_Venta_Boletos.config.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.generateToken(userDetails);

        String role = userDetails.getAuthorities().stream()
                .findFirst()
                .map(authority -> authority.getAuthority())
                .orElse("ROLE_ORGANIZADOR");

        AuthResponseDTO response = AuthResponseDTO.builder()
                .token(token)
                .type("Bearer")
                .email(userDetails.getUsername())
                .rol(role)
                .build();

        return ResponseEntity.ok(response);
    }
}