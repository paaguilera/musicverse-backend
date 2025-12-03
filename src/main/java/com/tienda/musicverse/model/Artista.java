package com.tienda.musicverse.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_artista;
    private String nombre;

    @OneToMany(mappedBy = "artista")
    @JsonIgnore
    private List<Album> albums;
    
    public Artista() {
        this.id_artista = 0;
        this.nombre = "";
    }

    public Artista(int id_artista, String nombre, List<Album> albums) {
        this.id_artista = id_artista;
        this.nombre = nombre;
        this.albums = albums;
    }

    public int getId_artista() {
        return id_artista;
    }
    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
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
