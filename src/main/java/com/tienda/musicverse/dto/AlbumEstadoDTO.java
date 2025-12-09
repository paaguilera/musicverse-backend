package com.tienda.musicverse.dto;

public class AlbumEstadoDTO {
    private boolean estado;

    public AlbumEstadoDTO() {
        this.estado = false;
    }
    public AlbumEstadoDTO(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
