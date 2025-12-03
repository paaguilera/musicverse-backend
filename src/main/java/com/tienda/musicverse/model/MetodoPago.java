package com.tienda.musicverse.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_metodopago;
    private String tipo;
    private String nombre;

    public MetodoPago() {
        this.id_metodopago = 0;
        this.tipo = "";
        this.nombre = "";
    }

    public MetodoPago(int id_metodopago, String tipo, String nombre) {
        this.id_metodopago = id_metodopago;
        this.tipo = tipo;
        this.nombre = nombre;
    }

    public int getId_metodopago() {
        return id_metodopago;
    }
    public void setId_metodopago(int id_metodopago) {
        this.id_metodopago = id_metodopago;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
