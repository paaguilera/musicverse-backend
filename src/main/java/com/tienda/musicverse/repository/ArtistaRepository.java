package com.tienda.musicverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musicverse.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Integer>{
    Optional<Artista> findByNombre(String nombre);
}
