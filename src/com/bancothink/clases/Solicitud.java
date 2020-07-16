package com.bancothink.clases;

import com.bancothink.interfaces.*;

import java.util.Date;
import java.util.List;

public class Solicitud implements ISolicitud {
    private long id;
    private String estado;
    private Date fechaSolicitud;
    private ICuenta cuenta;
    private ICredito credito;
    private Cliente cliente;
    private Ejecutivo ejecutivo;
    private String tipoSolicitud;

    public INotificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(INotificacion notificacion) {
        this.notificacion = notificacion;
    }

    private INotificacion notificacion;

    public Solicitud() {
    }

    public Solicitud(long id, Date fechaSolicitud, ICuenta cuenta, Cliente cliente, Ejecutivo ejecutivo, String tipoSolicitud) {
        this.id = id;
        this.estado = "Pendiente";
        this.fechaSolicitud = fechaSolicitud;
        this.cuenta = cuenta;
        this.cliente = cliente;
        this.ejecutivo = ejecutivo;
        this.tipoSolicitud = tipoSolicitud;
    }


    public Solicitud(long id, Date fechaSolicitud, ICredito credito, Cliente cliente, Ejecutivo ejecutivo, String tipoSolicitud) {
        this.id = id;
        this.estado = "Pendiente";
        this.fechaSolicitud = fechaSolicitud;
        this.credito = credito;
        this.cliente = cliente;
        this.ejecutivo = ejecutivo;
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    public ICuenta getCuenta() {
        return cuenta;
    }

    @Override
    public void setCuenta(ICuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    @Override
    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String isAprobado() {
        return estado;
    }

    @Override
    public void setEstado(String aprobado) {
        this.estado = aprobado;
    }

    @Override
    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    @Override
    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    @Override
    public ICredito getCredito() {
        return credito;
    }

    @Override
    public void setCredito(ICredito credito) {
        this.credito = credito;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Ejecutivo getEjecutivo() {
        return ejecutivo;
    }

    @Override
    public void setEjecutivo(Ejecutivo ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    @Override
    public double getMontoCreditos() {
        return this.credito.getMonto();
    }
}
