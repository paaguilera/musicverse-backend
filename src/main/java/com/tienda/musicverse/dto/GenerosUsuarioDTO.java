package com.tienda.musicverse.dto;

public class GenerosUsuarioDTO {
    private int id;
    private String nombre;
    public GenerosUsuarioDTO() {
        this.id = 0;
        this.nombre = "";
    }
    public GenerosUsuarioDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
