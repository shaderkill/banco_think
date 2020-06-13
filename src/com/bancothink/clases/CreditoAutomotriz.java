package com.bancothink.clases;

import com.bancothink.interfaces.ICredito;

import java.util.UUID;

public class CreditoAutomotriz implements ICredito {
    private String id;
    private Double monto;
    private long cuotas;
    private String tipo;

    public CreditoAutomotriz() {}

    public CreditoAutomotriz(Double monto, long cuotas) {
        this.id = UUID.randomUUID().toString();
        this.monto = monto;
        this.cuotas = cuotas;
        this.tipo = "Crédito Automotriz";
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
    public Double getMonto() {
        return monto;
    }

    @Override
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public long getCuotas() {
        return cuotas;
    }

    @Override
    public void setCuotas(long cuotas) {
        this.cuotas = cuotas;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getTipoCredito() {
        return this.tipo;
    }
}
