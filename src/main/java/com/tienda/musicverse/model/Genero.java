package com.tienda.musicverse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGenero;
    private String nombre;

    @OneToMany(mappedBy = "genero")
    @JsonIgnore
    private List<Album> albums;
    
    public Genero() {
        this.idGenero = 0;
        this.nombre = "";
    }

    public Genero(int idGenero, String nombre, List<Album> albums) {
        this.idGenero = idGenero;
        this.nombre = nombre;
        this.albums = albums;
    }

    public int getIdGenero() {
        return idGenero;
    }
    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
