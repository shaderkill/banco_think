package com.bancothink.clases;

import com.bancothink.interfaces.ICredito;
import com.bancothink.interfaces.ICuenta;

import java.util.Date;

public class Solicitud {
    private long id;
    private boolean aprobado;
    private Date fechaSolicitud;
    private ICuenta cuenta;
    private ICredito credito;
    private Cliente cliente;
    private Ejecutivo ejecutivo;
    private String tipoSolicitud;

    public Solicitud() {
    }

    public Solicitud(long id, boolean aprobado, Date fechaSolicitud, ICuenta cuenta, Cliente cliente, Ejecutivo ejecutivo, String tipoSolicitud) {
        this.id = id;
        this.aprobado = aprobado;
        this.fechaSolicitud = fechaSolicitud;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.ejecutivo = ejecutivo;
        this.tipoSolicitud = tipoSolicitud;
    }


    public Solicitud(long id, boolean aprobado, Date fechaSolicitud, ICredito credito, Cliente cliente, Ejecutivo ejecutivo, String tipoSolicitud) {
        this.id = id;
        this.aprobado = aprobado;
        this.fechaSolicitud = fechaSolicitud;
        this.credito = credito;
        this.cliente = cliente;
        this.ejecutivo = ejecutivo;
        this.tipoSolicitud = tipoSolicitud;
    }

    public ICuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(ICuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String isAprobado() {
        String resultado = "";
        if(aprobado) resultado = "Aprobado";
        else resultado = "No aprobado o Pendiente";
        return resultado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public ICredito getCredito() {
        return credito;
    }

    public void setCredito(ICredito credito) {
        this.credito = credito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }
}
