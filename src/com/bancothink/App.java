package com.bancothink;

import com.bancothink.clases.BaseDatos;
import com.bancothink.clases.Cliente;
import com.bancothink.clases.Ejecutivo;
import com.bancothink.clases.Supervisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
	// write your code here
        BaseDatos baseDatos = BaseDatos.getInstancia();
        List<Cliente> clientes = baseDatos.getClientes();
        Cliente cliente = new Cliente(0, "Cristian", "Molina", "Seguel", "1-9","99999999","Calle falsa 123", "Calle falsa 123", 700000);
        clientes.add(cliente);
        cliente = new Cliente(1, "Victor", "Hugo", "Hugo", "1-9","99999999","Calle falsa 123", "Calle falsa 123",1000000);
        clientes.add(cliente);
        cliente = new Cliente(2, "Felipe", "Soto", "Soto", "1-9","99999999","Calle falsa 123", "Calle falsa 123",350000);
        clientes.add(cliente);
        menu();
    }

    public static void menu() throws IOException {
        System.out.println("Bienvenido al sistema de gestión bancaria - Banco Think");
        System.out.println("Iniciar sesión como...  ¿Ejecutivo o Supervisor?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String option = reader.readLine();
        if(option.toLowerCase().equals("ejecutivo")) {
            BaseDatos baseDatos = BaseDatos.getInstancia();
            Ejecutivo ejecutivo = baseDatos.getEjecutivo();
            menuEjecutivo(ejecutivo);
        } else if (option.toLowerCase().equals("supervisor")) {
            BaseDatos baseDatos = BaseDatos.getInstancia();
            Supervisor supervisor = baseDatos.getSupervisor();
            menuSupervisor(supervisor);
        }
    }

    public static void menuEjecutivo(Ejecutivo ejecutivo) throws IOException {
        boolean inMenu = true;
        while(inMenu) {
            BaseDatos baseDatos = BaseDatos.getInstancia();
            ejecutivo = baseDatos.getEjecutivo();
            ejecutivo.desplegarMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String option = reader.readLine();
            switch (option) {
                case "1":
                    ejecutivo.obtenerClientes();
                    break;
                case "2":
                    ejecutivo.crearCliente();

                    break;
                case "3":
                    ejecutivo.leerNotificaciones();
                    break;
                case "4":
                    inMenu = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        }
        System.out.println("Sesión cerrada.");
        menu();
    }

    public static void menuSupervisor(Supervisor supervisor) throws IOException {
        boolean inMenu = true;
        while(inMenu) {
            BaseDatos baseDatos = BaseDatos.getInstancia();
            supervisor = baseDatos.getSupervisor();
            supervisor.desplegarMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String option = reader.readLine();
            switch (option) {
                case "1":
                    supervisor.verSolicitudes();
                    break;
                case "2":
                    supervisor.leerNotificaciones();
                    break;
                case "3":
                    inMenu = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        }
        System.out.println("Sesión cerrada.");
        menu();
    }

}
