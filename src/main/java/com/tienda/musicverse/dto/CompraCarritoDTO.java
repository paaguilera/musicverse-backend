package com.tienda.musicverse.dto;

import java.util.ArrayList;
import java.util.List;

public class CompraCarritoDTO {

    private String rutUsuario;
    private int idMetodoPago;
    private List<ProductoCompraDTO> productos;

    public CompraCarritoDTO() {
        this.rutUsuario = "";
        this.idMetodoPago = 0;
        this.productos = new ArrayList<>();
    }

    public CompraCarritoDTO(String rutUsuario, int idMetodoPago, double desc, List<ProductoCompraDTO> productos) {
        this.rutUsuario = rutUsuario;
        this.idMetodoPago = idMetodoPago;
        this.productos = productos;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }
    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
    public int getIdMetodoPago() {
        return idMetodoPago;
    }
    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    public List<ProductoCompraDTO> getProductos() {
        return productos;
    }
    public void setProductos(List<ProductoCompraDTO> productos) {
        this.productos = productos;
    }
    
}
