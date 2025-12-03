package com.tienda.musicverse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.musicverse.model.Venta;

public interface VentaRepository extends JpaRepository<Venta, Integer>{
    List<Venta> findByUsuarioRut(String rut);
}
