package com.Portafolio.Portafolio_Backend.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String telefono;
    @NotBlank
    private String email;
    @NotBlank
    private String perfil;
    @NotBlank
    private String banner;
    @NotBlank
    private String acerca_demi;
    
    //Constructor
    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String img, String telefono, String email, String perfil, String banner, String acerca_demi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.telefono = telefono;
        this.email = email;
        this.perfil = perfil;
        this.banner = banner;
        this.acerca_demi = acerca_demi;
    }
    
    //Getters and setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getAcerca_demi() {
        return acerca_demi;
    }

    public void setAcerca_demi(String acerca_demi) {
        this.acerca_demi = acerca_demi;
    } 
}
