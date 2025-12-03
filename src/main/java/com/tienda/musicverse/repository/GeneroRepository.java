package com.tienda.musicverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musicverse.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer>{
    Optional<Genero> findByNombre(String nombre);
}
