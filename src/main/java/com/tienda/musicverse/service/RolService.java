package com.tienda.musicverse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.musicverse.model.Rol;
import com.tienda.musicverse.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public RolService(){
    }

    public void registarRol(String nombreRol){

        Rol rol = new Rol();
        if(!rolRepository.findByNombre(nombreRol).isPresent()){
            rol.setNombre(nombreRol);

            this.rolRepository.save(rol);
        }
    }

    public List<Rol> obtenerRoles(){

        return this.rolRepository.findAll();

    }

    public Rol obtenerRol(String nombre){

        return this.rolRepository.findByNombre(nombre).get();
        
    }
}
