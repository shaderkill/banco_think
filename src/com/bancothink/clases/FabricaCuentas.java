package com.bancothink.clases;

import com.bancothink.interfaces.ICredito;
import com.bancothink.interfaces.ICuenta;
import com.bancothink.interfaces.IFabricaBancaria;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FabricaCuentas implements IFabricaBancaria {
    @Override
    public ICuenta getCuenta(String tipoCuenta, Boolean tarjeta) {
        tipoCuenta = tipoCuenta.toLowerCase();
        switch (tipoCuenta) {
            case "vista": return new CuentaVista(tarjeta);
            case "ahorro": return new CuentaAhorro(tarjeta);
            case "corriente": return new CuentaCorriente(tarjeta);
            default: return null;
        }
    }

    @Override
    public ICredito getCredito(String tipoCredito, Double monto, long cuotas) throws NotImplementedException {
        return null;
    }
}
