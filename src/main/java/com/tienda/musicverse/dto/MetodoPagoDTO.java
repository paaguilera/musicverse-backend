package com.tienda.musicverse.dto;

public class MetodoPagoDTO {
    private int idpago;

    public MetodoPagoDTO() {
        this.idpago = 0;
    }

    public MetodoPagoDTO(int idpago) {
        this.idpago = idpago;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }
    
}
