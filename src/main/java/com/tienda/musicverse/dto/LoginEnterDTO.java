package com.tienda.musicverse.dto;

public class LoginEnterDTO {
    
    private String correo;
    private String contrasenia;

    public LoginEnterDTO() {
        this.correo = "";
        this.contrasenia = "";
    }

    public LoginEnterDTO(String correo, String contrasenia) {
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
