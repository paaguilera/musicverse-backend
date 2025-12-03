package com.tienda.musicverse.dto;

public class LoginDTO {

    private String mensaje;
    private String rut;
    private String usuario;
    private String rol;
    private String direccion;
    private String telefono;
    private String fecha;
    private int metodoPago;
    private String genero;

    public LoginDTO() {
        this.mensaje = "";
        this.rut = "";
        this.usuario = "";
        this.rol = "";
        this.direccion = "";
        this.telefono = "";
        this.fecha = "";
        this.metodoPago = 0;
        this.genero = "";
    }

    public LoginDTO(String mensaje, String rut, String usuario, String rol, String direccion, String telefono,
        String fecha, String genero, int metodoPago
    ) {
        this.mensaje = mensaje;
        this.rut = rut;
        this.usuario = usuario;
        this.rol = rol;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha = fecha;
        this.genero = genero;
        this.metodoPago = metodoPago;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
    
}
