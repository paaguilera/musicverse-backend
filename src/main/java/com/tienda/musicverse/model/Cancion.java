package com.tienda.musicverse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cancion;
    private int numero;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnore
    private Album album;

    public Cancion(int id_cancion, int numero, String nombre, Album album) {
        this.id_cancion = id_cancion;
        this.numero = numero;
        this.nombre = nombre;
        this.album = album;
    }

    public Cancion() {
        this.id_cancion = 0;
        this.numero = 0;
        this.nombre = "";
    }
   
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    
}
