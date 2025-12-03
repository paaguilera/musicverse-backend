package com.tienda.musicverse.dto;

import java.util.List;

public class GenerosFavoritosDTO {

    private List<Integer> generosIds;

    public GenerosFavoritosDTO() {
        this.generosIds = null;
    }
    public GenerosFavoritosDTO(List<Integer> generosIds) {
        this.generosIds = generosIds;
    }

    public List<Integer> getGenerosIds() {
        return generosIds;
    }
    public void setGenerosIds(List<Integer> generosIds) {
        this.generosIds = generosIds;
    }

}
