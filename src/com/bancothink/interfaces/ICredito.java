package com.bancothink.interfaces;

import com.bancothink.clases.CreditoConsumo;

public interface ICredito {
    String getId();
    void setId(String id);
    Double getMonto();
    void setMonto(Double monto);
    long getCuotas();
    void setCuotas(long cuotas);
    String getTipo();
    void setTipo(String tipo);
    String getTipoCredito();
}
