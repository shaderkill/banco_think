package com.bancothink.clases;

import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
    private long id;
    private String direccionLaboral;
    private Date fechaIngreso;
    private List<Solicitud> solicitudes;
    private CuentaCorriente cuentaCorriente;

    public Cliente() {}

    public Cliente(long id, String nombre, String apellidoPaterno, String apellidoMaterno, String rut, String telefono, String direccionParticular, String direccionLaboral) {
        super(nombre, apellidoPaterno, apellidoMaterno, rut, telefono, direccionParticular);
        this.id = id;
        this.direccionLaboral = direccionLaboral;
        this.fechaIngreso = new Date();
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

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }
}
