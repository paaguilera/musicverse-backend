package com.tienda.musicverse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.tienda.musicverse.dto.LoginDTO;
import com.tienda.musicverse.dto.LoginEnterDTO;
import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.UsuarioRepository;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<LoginDTO> loginRequest(@RequestBody LoginEnterDTO loginEnterDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(loginEnterDTO.getCorreo());
        LoginDTO loginDTO  = new LoginDTO();
        loginDTO.setMensaje("");
        loginDTO.setRol("");
        loginDTO.setRut("");
        loginDTO.setUsuario("");
        loginDTO.setDireccion("");
        loginDTO.setTelefono("");

        if (usuarioOpt.isEmpty()) {
            loginDTO.setMensaje("Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(loginDTO);
        }

        Usuario usuario = usuarioOpt.get();
        if (!passwordEncoder.matches(loginEnterDTO.getContrasenia(), usuario.getContrasena())) {
            loginDTO.setMensaje("Contraseña incorrecta");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(loginDTO);
        }

        if (!usuario.isActiva()) {
            loginDTO.setMensaje("Usuario bloqueado");
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(loginDTO);
        }

        loginDTO.setMensaje("ok");
        loginDTO.setRol(usuario.getRol().getNombre());
        loginDTO.setRut(usuario.getRut());
        loginDTO.setUsuario(usuario.getNombre());
        loginDTO.setTelefono(usuario.getTelefono());
        loginDTO.setDireccion(usuario.getDireccion());
        loginDTO.setFecha(usuario.getFechaNacimiento().toString());
        loginDTO.setGenero(usuario.getGenero());
        if(usuario.getMetodoPago()!=null){
            loginDTO.setMetodoPago(usuario.getMetodoPago().getId_metodopago());
        }
        return ResponseEntity.ok(loginDTO);
    }
}
