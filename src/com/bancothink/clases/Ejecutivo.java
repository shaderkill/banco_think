package com.bancothink.clases;

import com.bancothink.controllers.GestorClientes;
import com.bancothink.controllers.GestorSolicitudes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Ejecutivo {
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

    public void crearCliente() throws IOException {
        new GestorClientes().crearCliente();
    }

    public void obtenerClientes() throws IOException {
        new GestorClientes().listarClientes();
    }

    public void desplegarMenu() {
        System.out.println("Menú de Supervisor \n" +
                "1 - Listar clientes\n" +
                "2 - Crear cliente\n" +
                "3 - Salir");
    }
}
