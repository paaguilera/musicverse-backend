package com.tienda.musicverse.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tienda.musicverse.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

    Optional<Album> findByNombre(String nombre);

    List<Album> findByArtistaNombre(String nombre);

    List<Album> findByGeneroNombre(String nombre);

    List<Album> findByGeneroIdGenero(int id);

    Optional<Album> findByCodeUPC(int code_UPC);

    List<Album> findByNombreContainingIgnoreCase(String nombre);

    List<Album> findByArtistaNombreContainingIgnoreCase(String nombre);

    List<Album> findByGeneroNombreContainingIgnoreCase(String nombre);

    @Query(value = """
        SELECT a.* 
        FROM album a 
        WHERE a.id_genero IN (
            SELECT id_genero 
            FROM usuario_genero 
            WHERE rut = :rut
        )
    """, nativeQuery = true)
    List<Album> findAlbumsByUsuarioGenero(@Param("rut") String rut);
}
