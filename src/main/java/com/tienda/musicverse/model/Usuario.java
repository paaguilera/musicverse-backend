package com.tienda.musicverse.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
    private String rut;
    private String nombre;
    private String contrasena;
    private String direccion;
    private String telefono;
    private String genero;
    private String correo;
    private LocalDate fechaNacimiento;
    private boolean activa;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_metodopago")
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Resenia> resenias;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Venta> ventas;

    @ManyToMany
    @JoinTable(
        name = "usuario_genero",
        joinColumns = @JoinColumn(name = "rut"),
        inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private List<Genero> generos;

    public Usuario() {
        this.rut = "";
        this.nombre = "";
        this.contrasena = "";
        this.direccion = "";
        this.correo = "";
        this.telefono = "";
        this.genero = "";
        this.fechaNacimiento = LocalDate.now();
        this.activa = false;
    }
    
    public Usuario(String rut, String nombre, String contrasena, String direccion, String correo,
            String genero, String telefono, LocalDate fechaNacimiento, boolean activa, Rol rol) {
        this.rut = rut;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.activa = activa;
        this.rol = rol;
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
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
    public boolean isActiva() {
        return activa;
    }
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
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
    
}
