package com.tienda.musicverse.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.CompraCarritoDTO;
import com.tienda.musicverse.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/comprar")
    public ResponseEntity<?> comprar(@RequestBody CompraCarritoDTO dto) {
        try {
            return ResponseEntity.ok(ventaService.realizarCompra(dto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{rut}")
    public ResponseEntity<?> listarComprasUsuario(@PathVariable String rut) {
        try {
            return ResponseEntity.ok(ventaService.listarComprasUsuario(rut));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
