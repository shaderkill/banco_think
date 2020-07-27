package com.bancothink.clases;

import com.bancothink.interfaces.INotificacion;
import com.bancothink.interfaces.IObservador;
import com.bancothink.interfaces.ISolicitud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona implements IObservador {
    private long id;
    private String direccionLaboral;
    private Date fechaIngreso;
    private List<ISolicitud> solicitudes = new ArrayList<>();
    private List<INotificacion> notificaciones = new ArrayList<>();
    private CuentaCorriente cuentaCorriente;
    private double sueldo;

    public Cliente() {
    }

    public Cliente(long id, String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String telefono, String direccionParticular, String direccionLaboral, double sueldo) {
        super(nombre, apellidoPaterno, apellidoMaterno, rut, telefono, direccionParticular);
        this.id = id;
        this.direccionLaboral = direccionLaboral;
        this.fechaIngreso = new Date();
        this.sueldo = sueldo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccionLaboral() {
        return direccionLaboral;
    }

    public void setDireccionLaboral(String direccionLaboral) {
        this.direccionLaboral = direccionLaboral;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<ISolicitud> getSolicitudes() {
        if(solicitudes == null) solicitudes = new ArrayList<>();
        return solicitudes;
    }

    public void setSolicitudes(List<ISolicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getMontoCreditos() {
        double colector = 0;
        if(solicitudes.size() > 0) {
            for (ISolicitud solicitud:solicitudes) {
                if(solicitud.getTipoSolicitud().equals("Crédito")){
                    colector += solicitud.getMontoCreditos();
                }
            }
        }
        return colector;
    }

    public void agregarSolicitud(ISolicitud solicitud) {
        this.solicitudes.add(solicitud);
    }

    public void removerSolicitud(ISolicitud solicitud) {
        this.solicitudes.remove(solicitud);
    }

    @Override
    public void actualizarNotificaciones(INotificacion notificacion) {
        System.out.println("Cliente notificado.");
        notificaciones.add(notificacion);

    }

    @Override
    public void leerNotificaciones() {
        if(notificaciones != null && notificaciones.size() > 0) {
            System.out.println("Notificaciones nuevas");
            for (INotificacion notificacion : notificaciones) {
                System.out.println(notificacion.obtenerNotificacion());
            }
            notificaciones.clear();
        } else {
            System.out.println("No se encontraron nuevas notificaciones.");
        }
    }

}
