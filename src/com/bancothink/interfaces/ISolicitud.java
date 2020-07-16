package com.bancothink.interfaces;

import com.bancothink.clases.Cliente;
import com.bancothink.clases.Ejecutivo;

import java.util.Date;

public interface ISolicitud {
    double getMontoCreditos();
    String getTipoSolicitud();
    void setNotificacion(INotificacion notificacion);
    INotificacion getNotificacion();
    long getId();
    void setId(long id);
    String isAprobado();
    ICuenta getCuenta();
    void setCuenta(ICuenta cuenta);
    void setEstado(String estado);
    Date getFechaSolicitud();
    void setFechaSolicitud(Date fechaSolicitud);
    ICredito getCredito();
    void setCredito(ICredito credito);
    Cliente getCliente();
    void setCliente(Cliente cliente);
    Ejecutivo getEjecutivo();
    void setEjecutivo(Ejecutivo ejecutivo);
    void setTipoSolicitud(String tipoSolicitud);
}
