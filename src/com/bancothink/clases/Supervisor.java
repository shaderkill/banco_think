package com.bancothink.clases;

import com.bancothink.controllers.GestorSolicitudes;
import com.bancothink.interfaces.INotificacion;
import com.bancothink.interfaces.IObservador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Supervisor extends Persona implements IObservador {
    private long id;
    private String email;
    private String sucursal;
    private List<INotificacion> notificaciones = new ArrayList<>();

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
        if (notificaciones != null && notificaciones.size() > 0) {
            System.out.println("Tiene un total de " + notificaciones.size() + " notificaciones nuevas.");
        }
        System.out.println("Menú de Supervisor \n" +
                "1 - Gestionar solicitudes\n" +
                "2 - Ver notificaciones\n" +
                "3 - Salir");
    }

    public List<INotificacion> getNotificaciones() {
        return notificaciones;
    }

    @Override
    public void actualizarNotificaciones(INotificacion notificacion) {
        BaseDatos baseDatos = BaseDatos.getInstancia();
        notificaciones = baseDatos.getSupervisor().getNotificaciones();
        System.out.println("Supervisor notificado");
        notificaciones.add(notificacion);
        baseDatos.setSupervisor(this);
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
