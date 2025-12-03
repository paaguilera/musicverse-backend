package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.UsuarioMiniDTO;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.service.UsuarioService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista-usuarios")
    public List<UsuarioMiniDTO> obtenerUsuariosMini() {
        return usuarioService.obteneUsuariosMini();
    }

    @DeleteMapping("/usuario/borrar/{rut}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable String rut) {
        try {
            usuarioService.eliminarUsuarioPorRut(rut);
            return ResponseEntity.ok("Usuario  " + rut + " ha sido eliminado.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
