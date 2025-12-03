package com.tienda.musicverse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.musicverse.dto.GenerosUsuarioDTO;
import com.tienda.musicverse.model.Genero;
import com.tienda.musicverse.service.GeneroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/generos")
public class GeneroController {
    
    @Autowired
    private GeneroService generoService;

    @GetMapping("")
    public List<Genero> getGeneros() {
        return generoService.obtenerGeneros();
    }
    
}
