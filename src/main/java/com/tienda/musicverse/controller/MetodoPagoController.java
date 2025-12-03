package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.model.MetodoPago;
import com.tienda.musicverse.service.MetodoPagoService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/metodopago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("")
    public List<MetodoPago> obtenerMetodos() {
        return metodoPagoService.obtenerMetodosPago();
    }
    
}
