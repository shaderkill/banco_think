package com.bancothink.clases;

import com.bancothink.interfaces.ICuenta;

import java.util.UUID;

public class CuentaCorriente implements ICuenta {
    private String id;
    private String tipo;
    private Boolean tarjeta;

    public CuentaCorriente() {}

    public CuentaCorriente(Boolean tarjeta) {
        this.id = UUID.randomUUID().toString();
        this.tipo = "Cuenta Corriente";
        this.tarjeta = tarjeta;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Boolean getTarjeta() {
        return tarjeta;
    }

    @Override
    public void setTarjeta(Boolean tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String getTipoCuenta() {
        return this.tipo;
    }
}
