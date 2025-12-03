package com.tienda.musicverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.musicverse.dto.GenerosUsuarioDTO;
import com.tienda.musicverse.model.Genero;
import com.tienda.musicverse.repository.GeneroRepository;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public void ingresarGenero(String nombre){
        Genero genero = new Genero();
        if(!generoRepository.findByNombre(nombre).isPresent()){
            genero.setNombre(nombre);

            generoRepository.save(genero);
        }
    }
    public List<Genero> obtenerGeneros(){
        return generoRepository.findAll();
    }
}
