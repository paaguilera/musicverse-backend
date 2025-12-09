package com.tienda.musicverse.dto;

public class ProductosMiniDTO {

    private int id;
    private String nombre;
    private String artista;
    private String genero;
    private int precio;
    private String imagenUrl;
    private Boolean desabilidato;

    public ProductosMiniDTO() {
        this.id = 0;
        this.nombre = "";
        this.artista = "";
        this.genero = "";
        this.precio = 0;
        this.imagenUrl = "";
        this.desabilidato = false;
    }

    public ProductosMiniDTO(int id, String nombre, String artista, String genero, int precio, String imagenUrl,
            Boolean desabilidato
    ) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.precio = precio;
        this.imagenUrl = imagenUrl;
        this.desabilidato = desabilidato;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getImagenUrl() {
        return imagenUrl;
    }
    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Boolean getDesabilidato() {
        return desabilidato;
    }

    public void setDesabilidato(Boolean desabilidato) {
        this.desabilidato = desabilidato;
    }
    
}
