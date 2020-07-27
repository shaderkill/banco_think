package com.bancothink.clases;

import com.bancothink.interfaces.INotificacion;
import com.bancothink.interfaces.IObservador;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Notificacion implements INotificacion {
    private UUID uuid;
    private List<IObservador> observadores = new ArrayList<>();
    private String mensaje;

    public Notificacion() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void agregarObservador(IObservador iObservador) {
        observadores.add(iObservador);
    }

    @Override
    public void eliminarObservador(IObservador iObservador) {
        observadores.remove(iObservador);
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public void notificarObservadores(String mensaje) {
        this.mensaje = mensaje;
        for (IObservador observador : observadores) {
            observador.actualizarNotificaciones(this);
        }
    }

    @Override
    public String obtenerNotificacion() {
        return mensaje;
    }

}
