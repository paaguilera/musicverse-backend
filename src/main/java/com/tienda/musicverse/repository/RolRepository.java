package com.tienda.musicverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musicverse.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByNombre(String nombre_rol);
}
