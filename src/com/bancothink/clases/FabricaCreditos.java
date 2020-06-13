package com.bancothink.clases;

import com.bancothink.interfaces.ICredito;
import com.bancothink.interfaces.ICuenta;
import com.bancothink.interfaces.IFabricaBancaria;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FabricaCreditos implements IFabricaBancaria {
    @Override
    public ICuenta getCuenta(String tipoCuenta, Boolean tarjeta) throws NotImplementedException {
        return null;
    }

    @Override
    public ICredito getCredito(String tipoCredito, Double monto, long cuotas) {
        tipoCredito = tipoCredito.toLowerCase();
        switch (tipoCredito) {
            case "consumo": return new CreditoConsumo(monto, cuotas);
            case "hipotecario": return new CreditoHipotecario(monto, cuotas);
            case "automotriz": return new CreditoAutomotriz(monto, cuotas);
            default: return null;
        }
    }
}
