package com.tienda.musicverse.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlbumGrandDTO {
    private int idAlbum;
    private String nombre;
    private String formato;
    private Long codeUPC;
    private LocalDate fechaLanza;
    private int precio;
    private int stock;
    private String imagenUrl;
    private String artista;
    private List<String> canciones;
    private List<String> resenias;
    private String genero;
    private boolean desabilidato;

    public AlbumGrandDTO() {
        this.idAlbum = 0;
        this.nombre = "";
        this.formato = "";
        this.codeUPC = 0L;
        this.fechaLanza = LocalDate.now();
        this.precio = 0;
        this.stock = 0;
        this.imagenUrl = "";
        this.artista = "";
        this.canciones = new ArrayList<>();
        this.resenias = new ArrayList<>();
        this.genero = "";
        this.desabilidato = false;
    }
    public AlbumGrandDTO(int idAlbum, String nombre, String formato, Long codeUPC, LocalDate fechaLanza, int precio,
            int stock, String imagenUrl, String artista, List<String> canciones, List<String> resenias, String genero,
            Boolean desabilidato) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.formato = formato;
        this.codeUPC = codeUPC;
        this.fechaLanza = fechaLanza;
        this.precio = precio;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
        this.artista = artista;
        this.canciones = canciones;
        this.resenias = resenias;
        this.genero = genero;
        this.desabilidato = desabilidato;
    }
    public int getIdAlbum() {
        return idAlbum;
    }
    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
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
    public Long getCodeUPC() {
        return codeUPC;
    }
    public void setCodeUPC(Long codeUPC) {
        this.codeUPC = codeUPC;
    }
    public LocalDate getFechaLanza() {
        return fechaLanza;
    }
    public void setFechaLanza(LocalDate fechaLanza) {
        this.fechaLanza = fechaLanza;
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
    public String getImagenUrl() {
        return imagenUrl;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public List<String> getCanciones() {
        return canciones;
    }
    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }
    public List<String> getResenias() {
        return resenias;
    }
    public void setResenias(List<String> resenias) {
        this.resenias = resenias;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public boolean isDesabilidato() {
        return desabilidato;
    }
    public void setDesabilidato(boolean desabilidato) {
        this.desabilidato = desabilidato;
    }

}
