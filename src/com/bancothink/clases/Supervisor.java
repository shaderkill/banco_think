package com.bancothink.clases;

import com.bancothink.controllers.GestorSolicitudes;

import java.io.IOException;

public class Supervisor extends Persona {
    private long id;
    private String email;
    private String sucursal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void verSolicitudes() throws IOException {
        new GestorSolicitudes().listarSolicitudes();
    }

    public void desplegarMenu() {
        System.out.println("Menú de Supervisor \n" +
                "1 - Gestionar solicitudes\n" +
                "2 - Salir");
    }

}
