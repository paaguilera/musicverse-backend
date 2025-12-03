package com.tienda.musicverse.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_venta;

    private LocalDate fecha;
    private String estado;
    private int monto;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_metodopago")
    @JsonIgnore
    private MetodoPago metodoPago;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalles;

    
    public Venta() {
        this.id_venta = 0;
        this.fecha = LocalDate.now();
        this.estado = "";
        this.monto = 0;
        this.usuario = new Usuario();
        this.metodoPago = new MetodoPago();
        this.detalles = new ArrayList<>();
    }
    
    public Venta(int id_venta, LocalDate fecha, String estado, int monto, Usuario usuario, MetodoPago metodoPago,
            List<DetalleVenta> detalles) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.estado = estado;
        this.monto = monto;
        this.usuario = usuario;
        this.metodoPago = metodoPago;
        this.detalles = detalles;
    }

    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getMonto() {
        return monto;
    }
    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

}
