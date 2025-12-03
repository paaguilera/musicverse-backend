package com.tienda.musicverse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalleventa;

    private int cantidad;
    private double descuento;
    private int precio;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "id_album")
    @JsonIgnore
    private Album album;

    public DetalleVenta() {
        this.id_detalleventa = 0;
        this.cantidad = 0;
        this.descuento = 0;
        this.precio = 0;
    }

    
    public DetalleVenta(int id_detalleventa, int cantidad, double descuento, int precio, Venta venta, Album album) {
        this.id_detalleventa = id_detalleventa;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
        this.venta = venta;
        this.album = album;
    }

    public Venta getVenta() {
        return venta;
    }


    public void setVenta(Venta venta) {
        this.venta = venta;
    }


    public Album getAlbum() {
        return album;
    }


    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getId_detalleventa() {
        return id_detalleventa;
    }
    public void setId_detalleventa(int id_detalleventa) {
        this.id_detalleventa = id_detalleventa;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getPrecio() {
        return precio;
    }


    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
