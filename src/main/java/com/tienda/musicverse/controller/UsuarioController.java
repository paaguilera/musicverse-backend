package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.GenerosFavoritosDTO;
import com.tienda.musicverse.dto.GenerosUsuarioDTO;
import com.tienda.musicverse.dto.MetodoPagoDTO;
import com.tienda.musicverse.dto.UsuarioMiniDTO;
import com.tienda.musicverse.dto.UsuarioModificarDTO;
import com.tienda.musicverse.service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable String id, @RequestBody UsuarioModificarDTO dto) {
        
        String ok = usuarioService.modificUsuario(id,dto);
        return ResponseEntity.ok(ok);
    }

    @PostMapping("/generos/{id}")
    public ResponseEntity<?> agregarGeneros(@PathVariable String id, @RequestBody GenerosFavoritosDTO dto) {

        String ok = usuarioService.generosFavoritos(id,dto);
        return ResponseEntity.ok(ok);
    }

    @PutMapping("/generos/{id}")
    public ResponseEntity<?> cambiarGeneros(@PathVariable String id, @RequestBody GenerosFavoritosDTO dto) {

        String ok = usuarioService.generosFavoritos(id,dto);
        return ResponseEntity.ok(ok);
    }

    @PostMapping("/metodopago/{id}")
    public ResponseEntity<?> agregarMetodoPago(@PathVariable String id, @RequestBody MetodoPagoDTO metodoPagoDTO) {

        String ok = usuarioService.agregarMetodoPago(id,metodoPagoDTO.getIdpago());
        return ResponseEntity.ok(ok);
    }
    
    @GetMapping("{rut}/generos")
    public List<GenerosUsuarioDTO> getGenerosUser(@PathVariable String rut) {
        System.out.println(usuarioService.generosFavoritoList(rut));
        return usuarioService.generosFavoritoList(rut);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UsuarioMiniDTO>> buscarMiniUser(@RequestParam String query) {
        return ResponseEntity.ok(usuarioService.buscarQuery(query));
    }
}
