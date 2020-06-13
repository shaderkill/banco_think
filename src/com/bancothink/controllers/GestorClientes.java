package com.bancothink.controllers;

import com.bancothink.clases.BaseDatos;
import com.bancothink.clases.Cliente;
import com.bancothink.clases.Ejecutivo;
import com.bancothink.clases.Solicitud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GestorClientes {

    public void listarClientes() throws IOException {
        BaseDatos baseDatos = BaseDatos.getInstancia();
        List<Cliente> clientes = baseDatos.getClientes();
        System.out.println("Listado de Clientes");
        for (Cliente cliente:clientes) {
            System.out.println("Cliente # " + cliente.getId() + " - " + cliente.getNombre() + " " + cliente.getApellidoPaterno() +
                    "  Cliente desde " + cliente.getFechaIngreso().toString());
        }
        boolean listo = false;
        while(!listo) {
            System.out.println("¿Desea ingresar una nueva solicitud? (Y/N)");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String option = reader.readLine();
            if (option.toLowerCase().equals("y")) {
                try {
                    System.out.println("Ingrese el número de cliente");
                    long idCliente = Long.parseLong(reader.readLine());
                    System.out.println("Ingrese el tipo de solicitud a crear (cuenta/credito): ");
                    String tipoSolicitud = reader.readLine();
                    for (Cliente cliente:clientes) {
                        if(cliente.getId() == idCliente) {
                            if("cuenta".equals(tipoSolicitud.toLowerCase())) {
                                cliente.setSolicitudes(new GestorSolicitudes().crearSolicitudCuenta(cliente, new Ejecutivo()).getSolicitudes());
                                listo = true;
                            } else if("credito".equals(tipoSolicitud.toLowerCase())) {
                                cliente.setSolicitudes(new GestorSolicitudes().crearSolicitudCredito(cliente, new Ejecutivo()).getSolicitudes());
                                listo = true;
                            } else System.out.println("Tipo de solicitud ingresado no existe");
                        }
                    }
                    baseDatos.setClientes(clientes);

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
    }

    public void crearCliente() throws IOException {
        System.out.println("Formulario de registro nuevo Cliente\n" +
                "Lea atentamente y rellene con los datos solicitados");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nombre del cliente: ");
        String nombre = reader.readLine();
        System.out.println("Apellido Paterno del cliente: ");
        String apellidoPaterno = reader.readLine();
        System.out.println("Apellido Materno del cliente: ");
        String apellidoMaterno = reader.readLine();
        System.out.println("RUT del cliente: ");
        String rut = reader.readLine();
        System.out.println("telefono del cliente: ");
        String telefono = reader.readLine();
        System.out.println("Dirección particular del cliente: ");
        String direccionParticular = reader.readLine();
        System.out.println("Dirección laboral del cliente: ");
        String direccionLaboral = reader.readLine();
        BaseDatos baseDatos = BaseDatos.getInstancia();
        List<Cliente> clientes = baseDatos.getClientes();
        Cliente nuevoCliente = new Cliente(clientes.size(), nombre,apellidoPaterno,apellidoMaterno,rut,telefono,direccionParticular,direccionLaboral);
        clientes.add(nuevoCliente);
        System.out.println("Cliente " + nuevoCliente.getNombre() + " ha sido registrado.");
        baseDatos.setClientes(clientes);
    }
}
