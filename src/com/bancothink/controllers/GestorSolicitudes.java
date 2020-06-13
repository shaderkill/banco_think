package com.bancothink.controllers;

import com.bancothink.clases.*;
import com.bancothink.interfaces.ICredito;
import com.bancothink.interfaces.ICuenta;
import com.bancothink.interfaces.IFabricaBancaria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorSolicitudes {

    public void listarSolicitudes() throws IOException {
        BaseDatos baseDatos = BaseDatos.getInstancia();
        List<Cliente> clientes = baseDatos.getClientes();
        System.out.println("Listado de solicitudes");
        boolean haySolicitudes = false;
        for (Cliente cliente:clientes) {
            List<Solicitud> solicitudes = cliente.getSolicitudes();
            if(solicitudes != null) {
                System.out.println("------------------------------------");
                System.out.println("N° Cliente " + cliente.getId() + " - " + cliente.getNombre() + " " + cliente.getApellidoPaterno());
                for(Solicitud solicitud:solicitudes) {
                    System.out.println("N° Solicitud " + solicitud.getId() + " Solicitud de " + solicitud.getTipoSolicitud()  + " - Estado: " + solicitud.isAprobado() );
                }
                System.out.println("------------------------------------");
                haySolicitudes = true;
            }
        }
        if(haySolicitudes) {
            boolean listo = false;
            while(!listo) {
                System.out.println("¿Desea ver una solicitud en detalle? (Y/N)");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String option = reader.readLine();
                if (option.toLowerCase().equals("y")) {
                    try {
                        System.out.println("Ingrese el número de cliente");
                        long idCliente = Long.parseLong(reader.readLine());
                        System.out.println("Ingrese el número de solicitud");
                        long idSolicitud = Long.parseLong(reader.readLine());
                        obtenerSolicitud(idCliente, idSolicitud);
                        listo = true;
                    } catch (Exception e) {
                        System.out.println("Valor ingresado no es válido, intente nuevamente.");
                        e.printStackTrace();
                        listo = false;
                    }
                } else if (option.toLowerCase().equals("n")) {
                    listo = true;
                } else {
                    System.out.println("Valor ingresado \"" + option + "\" no es válido.");
                }
            }
        } else {
            System.out.println("No se encuentraron solicitudes en la base de datos.");
        }
    }

    public void obtenerSolicitud(long idCliente, long idSolicitud) throws IOException {
        BaseDatos baseDatos = BaseDatos.getInstancia();
        List<Cliente> clientes = baseDatos.getClientes();
        for (Cliente cliente:clientes) {
            if (idCliente == cliente.getId()) {
                List<Solicitud> solicitudes = cliente.getSolicitudes();
                for (Solicitud solicitud:solicitudes) {
                    if(idSolicitud == solicitud.getId()) {
                        System.out.println("Solicitud " + solicitud.getId());
                        System.out.println("Fecha solicitud: " + solicitud.getFechaSolicitud().toString());
                        System.out.println("Estado: " + solicitud.isAprobado());
                        System.out.println("Tipo solicitud: " + solicitud.getTipoSolicitud());
                        System.out.println("Cliente: " + solicitud.getCliente().getNombre() + " " + solicitud.getCliente().getApellidoPaterno());
                        boolean listo = false;
                        while(!listo) {
                            System.out.println("¿Desea aprobar esta solicitud? (Y/N)");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                            String option = reader.readLine();
                            if(option.toLowerCase().equals("y")) {
                                solicitud.setAprobado(true);
                                System.out.println("Se ha aprobado la solicitud");
                                listo = true;
                            } else if(option.toLowerCase().equals("n")) {
                                System.out.println("No se ha aprobado la solicitud");
                                listo = true;
                            } else {
                                System.out.println("Valor ingresado: " + option + " no es valido.");
                            }
                        }
                    }
                }
                cliente.setSolicitudes(solicitudes);
            }
        }
        baseDatos.setClientes(clientes);
    }

    public Cliente crearSolicitudCredito(Cliente cliente, Ejecutivo ejecutivo) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("¿Cual es el monto del crédito?");
        Double monto = Double.parseDouble(reader.readLine());

        System.out.println("¿Total de cuotas del crédito?");
        long cuotas = Long.parseLong(reader.readLine());

        System.out.println("¿Tipo de crédito? \nCréditos disponibles: \n- Hipotecario \n- Automotriz \n- Consumo");
        String tipoCredito = reader.readLine();

        List<Solicitud> solicitudes = cliente.getSolicitudes();
        if(solicitudes == null) solicitudes = new ArrayList<>();
        IFabricaBancaria fabricaCreditos = ProveedorFabrica.getFabrica("creditos");
        ICredito credito = fabricaCreditos.getCredito(tipoCredito, monto, cuotas);
        Solicitud nuevaSolicitud = new Solicitud(solicitudes.size(), false, new Date(), credito, cliente, ejecutivo, "Crédito");
        solicitudes.add(nuevaSolicitud);
        cliente.setSolicitudes(solicitudes);
        System.out.println("Se ha generado la solicitud de crédito n°" + nuevaSolicitud.getId() + " por el monto de " + credito.getMonto() + " con " + credito.getCuotas() + " cuotas.");
        return cliente;
    }

    public Cliente crearSolicitudCuenta(Cliente cliente, Ejecutivo ejecutivo) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("¿Tipo de Cuenta? \nCuentas disponibles: \n- Ahorro \n- Corriente \n- Vista");
        String tipoCuenta = reader.readLine();

        System.out.println("¿La cuenta incorporara tarjeta? (Y/N)");
        String option = reader.readLine();
        boolean tarjeta = false;
        if("y".equals(option.toLowerCase())) tarjeta = true;

        List<Solicitud> solicitudes = cliente.getSolicitudes();
        if(solicitudes == null) solicitudes = new ArrayList<>();
        IFabricaBancaria fabricaCuentas = ProveedorFabrica.getFabrica("cuentas");
        ICuenta cuenta = fabricaCuentas.getCuenta(tipoCuenta, tarjeta);
        Solicitud nuevaSolicitud = new Solicitud(solicitudes.size(), false, new Date(), cuenta, cliente, ejecutivo, "Cuenta");
        solicitudes.add(nuevaSolicitud);
        cliente.setSolicitudes(solicitudes);
        System.out.println("Se ha generado la solicitud de apertura de cuenta n°" + nuevaSolicitud.getId() + " de tipo " + cuenta.getTipoCuenta());
        if (tarjeta) {
            System.out.println("Se incluye tarjeta asociada a la cuenta");
        } else {
            System.out.println("No se incluye tarjeta asociada a la cuenta");
        }
        return cliente;
    }

}
