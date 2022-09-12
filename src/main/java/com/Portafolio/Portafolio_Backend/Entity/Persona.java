package com.Portafolio.Portafolio_Backend.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
  
    @NotNull
    @Size(min = 1, max = 150, message = "No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 80, message = "No cumple con la longitud")
    private String apellido;
    
    @Size(min = 1, max = 80, message = "No cumple con la longitud")
    private String img;
    
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String telefono;
    
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String email;
    
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String perfil;
    
    @Size(min = 1, max = 255, message = "No cumple con la longitud")
    private String banner;
    
    @Size(min = 1, max = 5000, message = "No cumple con la longitud")
    private String acerca_demi;
    
    
    //Constructor
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String telefono, String email, String perfil, String banner, String acerca_demi) {
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
