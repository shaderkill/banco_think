package com.bancothink.interfaces;

import java.util.UUID;

public interface INotificacion {
    UUID getUuid();
    void setMensaje(String mensaje);
    void agregarObservador(IObservador iObservador);
    void eliminarObservador(IObservador iObservador);
    void notificarObservadores(String mensaje);
    String obtenerNotificacion();
}
