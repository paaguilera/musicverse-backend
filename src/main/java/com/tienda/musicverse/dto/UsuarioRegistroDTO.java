package com.tienda.musicverse.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UsuarioRegistroDTO {

    private String rut;
    private String nombre;
    private String contrasenia;
    private String direccion;
    private String genero;
    private String correo;
    private String telefono;
    private int metodoPago;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;

    public UsuarioRegistroDTO() {
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.correo = "";
        this.telefono = "";
        this.fechaNacimiento = LocalDate.now();
        this.metodoPago = 0;
    }

    public UsuarioRegistroDTO(String rut, String nombre, String contrasenia, String direccion, String correo,
            String genero, String telefono, int metodoPago, LocalDate fechaNacimiento) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.metodoPago = metodoPago;
        this.fechaNacimiento = fechaNacimiento;
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
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

}
