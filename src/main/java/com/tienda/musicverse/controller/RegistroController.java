package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.UsuarioRegistroDTO;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping({"/registro"})
public class RegistroController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public ResponseEntity<?> registrar(@RequestBody UsuarioRegistroDTO dto) {
        String ok = usuarioService.registrarUsuario(dto);
        if(!ok.equals("ok")){
            return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Ya existe un usuario registrado con ese RUT");
        }
        return ResponseEntity.ok(ok);
    }
    
    @GetMapping("")
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obteneUsuarios();
    }
    
}
