package com.bancothink.mockup;

import com.bancothink.clases.Cliente;
import com.bancothink.clases.Solicitud;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


}
