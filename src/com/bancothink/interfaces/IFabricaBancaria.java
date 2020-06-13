package com.bancothink.interfaces;

public interface IFabricaBancaria {

    ICuenta getCuenta(String tipoCuenta, Boolean tarjeta);
    ICredito getCredito(String tipoCredito, Double monto, long cuotas);

}
