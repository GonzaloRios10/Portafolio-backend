package com.Portafolio.Portafolio_Backend.Security.Controller;

public class Mensaje {
    private String mensaje;
    
    //Constructor
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Getters and setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
