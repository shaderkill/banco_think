package com.bancothink.mockup;

import com.bancothink.clases.Cliente;
import com.bancothink.clases.Ejecutivo;
import com.bancothink.clases.Solicitud;
import com.bancothink.clases.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    private List<Cliente> clientes = new ArrayList<>();
    private Supervisor supervisor = new Supervisor();
    private Ejecutivo ejecutivo = new Ejecutivo();

    public long getTotalSolicitudes() {
        return totalSolicitudes;
    }

    public void setTotalSolicitudes(long totalSolicitudes) {
        this.totalSolicitudes = totalSolicitudes;
    }

    private long totalSolicitudes = 0;

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


}
