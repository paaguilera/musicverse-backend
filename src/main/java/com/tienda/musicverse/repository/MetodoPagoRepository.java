package com.tienda.musicverse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musicverse.model.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago,Integer>{
    Optional<MetodoPago> findByNombre(String nombre_banco);

}
