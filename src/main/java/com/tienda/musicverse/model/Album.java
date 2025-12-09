package com.tienda.musicverse.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_album;
    private String nombre;
    private String formato;
    private long codeUPC;
    private LocalDate fecha_lanza;
    private int precio;
    private int stock;
    private boolean desabilidato;

    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Resenia> resenias;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;

    public Album() {
        this.id_album = 0;
        this.nombre = "";
        this.formato = "";
        this.codeUPC = 0L;
        this.fecha_lanza = LocalDate.now();
        this.precio = 0;
        this.stock = 0;
        this.imagenUrl = "";
        this.desabilidato = false;
    }

    public Album(int id_album, String nombre, String formato, long codeUPC, LocalDate fecha_lanza, int precio,
            int stock, String imagenUrl, Artista artista, List<Cancion> canciones, List<Resenia> resenias, Genero genero,
            Boolean desabilidato) {
        this.id_album = id_album;
        this.nombre = nombre;
        this.formato = formato;
        this.codeUPC = codeUPC;
        this.fecha_lanza = fecha_lanza;
        this.precio = precio;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
        this.artista = artista;
        this.canciones = canciones;
        this.resenias = resenias;
        this.genero = genero;
    }

    public int getId_album() {
        return id_album;
    }

    public void setId_album(int id_album) {
        this.id_album = id_album;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public long getCodeUPC() {
        return codeUPC;
    }

    public void setCodeUPC(long codeUPC) {
        this.codeUPC = codeUPC;
    }

    public LocalDate getFecha_lanza() {
        return fecha_lanza;
    }

    public void setFecha_lanza(LocalDate fecha_lanza) {
        this.fecha_lanza = fecha_lanza;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    public boolean isDesabilidato() {
        return desabilidato;
    }
    public void setDesabilidato(boolean desabilidato) {
        this.desabilidato = desabilidato;
    }
}
