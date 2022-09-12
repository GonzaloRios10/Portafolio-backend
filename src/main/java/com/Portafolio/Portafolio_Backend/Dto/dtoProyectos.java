package com.Portafolio.Portafolio_Backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyectos {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imagenP;
    
    //Constructor
    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String imagenP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imagenP = imagenP;
    }
    
    //Getters and setters
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImagenP() {
        return imagenP;
    }

    public void setImagenP(String imagenP) {
        this.imagenP = imagenP;
    }
}
