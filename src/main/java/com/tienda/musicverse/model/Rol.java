package com.tienda.musicverse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    private String nombre;

    public Rol() {
        this.id_rol = 0;
        this.nombre = "";
    }
    public Rol(int id_rol, String nombre) {
        this.nombre = nombre;
    }

    
    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
