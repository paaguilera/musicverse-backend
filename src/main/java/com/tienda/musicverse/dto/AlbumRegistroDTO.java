package com.tienda.musicverse.dto;

import java.time.LocalDate;

public class AlbumRegistroDTO {

    private String nombre;
    private String formato;
    private long codeUPC;
    private String fecha_lanza;
    private int precio;
    private int stock;
    private String artista;
    private String genero;

    public AlbumRegistroDTO() {
        this.nombre = "";
        this.formato = "";
        this.codeUPC = 0L;
        this.fecha_lanza = "";
        this.precio = 0;
        this.stock = 0;
        this.artista = "";
        this.genero = "";
    }

    public AlbumRegistroDTO(String nombre, String formato, long codeUPC, String fecha_lanza, int precio, int stock,
            String artista, String genero) {
        this.nombre = nombre;
        this.formato = formato;
        this.codeUPC = codeUPC;
        this.fecha_lanza = fecha_lanza;
        this.precio = precio;
        this.stock = stock;
        this.artista = artista;
        this.genero = genero;
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
    public void setCodeUPC(long code_UPC) {
        this.codeUPC = code_UPC;
    }
    public String getFecha_lanza() {
        return fecha_lanza;
    }
    public void setFecha_lanza(String fecha_lanza) {
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
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    
}
