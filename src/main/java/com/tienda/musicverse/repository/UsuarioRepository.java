package com.tienda.musicverse.repository;

import java.util.List;
import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.musicverse.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByNombre(String nombre);
    boolean existsByCorreo(String correo);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    List<Usuario> findByRutContainingIgnoreCase(String rut);

    List<Usuario> findByCorreoContainingIgnoreCase(String correo);
}
