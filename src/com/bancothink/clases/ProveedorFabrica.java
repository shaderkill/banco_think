package com.bancothink.clases;

import com.bancothink.interfaces.IFabricaBancaria;

public class ProveedorFabrica {

    public static IFabricaBancaria getFabrica(String tipoFabrica) {
        if("cuentas".equals(tipoFabrica.toLowerCase())) return new FabricaCuentas();
        else return new FabricaCreditos();
    }
}
