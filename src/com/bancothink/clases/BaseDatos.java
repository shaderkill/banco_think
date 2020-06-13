package com.bancothink.clases;

import com.bancothink.mockup.Datos;

// Ignorar extends es para efectos de imitar almacenamiento de datos, solo MOCKUP
public class BaseDatos extends Datos {
    private String host;
    private int port;
    private String nombreBase;
    private static BaseDatos instancia;

    private BaseDatos() {
        this.nombreBase = "BD_BancoThink";
        this.host = "127.0.0.1";
        this.port = 8080;
    }

    public static BaseDatos getInstancia() {
        if(instancia == null) {
          instancia = new BaseDatos();
          instancia.conectarBD();
        }
        return instancia;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreBase(String nombreBase) {
        this.nombreBase = nombreBase;
    }

    public void conectarBD() {
        System.out.println("Se ha conectado con la base de datos " + this.nombreBase);
    }

    public void desconectarBD() {
        System.out.println("Se ha desconectado de la base de datos " + this.nombreBase);
    }


}
