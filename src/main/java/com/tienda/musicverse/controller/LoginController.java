package com.tienda.musicverse.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.LoginDTO;
import com.tienda.musicverse.dto.LoginEnterDTO;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.UsuarioRepository;
import com.tienda.musicverse.service.LoginService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // @GetMapping("/login")
    // public String getLogin() {
    //     return "login";
    // }
    
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginEnterDTO loginEnterDTO) {
        return loginService.loginRequest(loginEnterDTO);
    }

    @GetMapping("/usuario-logueado")
    public ResponseEntity<?> usuarioActual(Authentication auth) {
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().body(Map.of("correo", auth.getName()));
    }
    
    
}
