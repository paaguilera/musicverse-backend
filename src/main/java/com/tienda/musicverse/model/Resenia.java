package com.tienda.musicverse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resenia;
    private int nota;
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "rut")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_album")
    @JsonIgnore
    private Album album;

    public Resenia() {
        this.id_resenia = 0;
        this.nota = 0;
        this.contenido = "";
    }
    
    public Resenia(int id_resenia, int nota, String contenido, Usuario usuario, Album album) {
        this.id_resenia = id_resenia;
        this.nota = nota;
        this.contenido = contenido;
        this.usuario = usuario;
        this.album = album;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getId_resenia() {
        return id_resenia;
    }
    public void setId_resenia(int id_resenia) {
        this.id_resenia = id_resenia;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
}
