package com.tienda.musicverse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tienda.musicverse.model.Usuario;
import com.tienda.musicverse.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String rut) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findById(rut)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        if (usuario.isActiva()) {
            throw new DisabledException("El usuario está bloqueado");
        }
        return User.builder()
                .username(usuario.getRut())
                .password(usuario.getContrasena())
                .roles(usuario.getRol().getNombre().replace("ROLE_", ""))
                .build();
    }
}
