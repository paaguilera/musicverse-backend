package com.tienda.musicverse.dto;

public class UsuarioModificarDTO {
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String contrasenia;
    private int metodoPago;
    private String genero;
    private String fecha;

    public UsuarioModificarDTO() {
        this.nombre = "";
        this.correo = "";
        this.direccion = "";
        this.telefono = "";
        this.contrasenia = "";
        this.metodoPago = 0;
        this.genero = "";
        this.fecha = "";
    }
    public UsuarioModificarDTO(String nombre, String correo, String direccion, String telefono, String contrasenia,
        String fecha,  String genero, int metodoPago
    ) {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.genero = genero;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public int getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
