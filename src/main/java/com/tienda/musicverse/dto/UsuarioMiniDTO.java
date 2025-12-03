package com.tienda.musicverse.dto;

public class UsuarioMiniDTO {
    private String rut;
    private String nombre;
    private String correo;

    public UsuarioMiniDTO() {
        this.rut = "";
        this.nombre = "";
        this.correo = "";
    }
    public UsuarioMiniDTO(String rut, String nombre, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.correo = correo;
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
