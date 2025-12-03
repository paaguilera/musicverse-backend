package com.tienda.musicverse.dto;

public class ProductoCompraDTO {

    private int idAlbum;
    private int cantidad;
    private double desc;

    public ProductoCompraDTO() {
        this.idAlbum = 0;
        this.cantidad = 0;
        this.desc = 1;
    }

    public ProductoCompraDTO(int idAlbum, int cantidad, double desc) {
        this.idAlbum = idAlbum;
        this.cantidad = cantidad;
        this.desc = desc;
    }

    public int getIdAlbum() {
        return idAlbum;
    }
    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }
        
}
