package com.techsolutions.empresa;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Lista para almacenar todos los empleados
    static ArrayList<Empleado> empleados = new ArrayList<>();

    // Scanner para leer datos del usuario
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║          BIENVENIDO A TECHSOLUTIONS              ║");
        System.out.println("║        Sistema de Gestión de Empleados           ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            System.out.print("\nSelecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarIngeniero();
                    break;
                case 2:
                    registrarContador();
                    break;
                case 3:
                    registrarVendedor();
                    break;
                case 4:
                    mostrarTodosEmpleados();
                    break;
                case 5:
                    buscarEmpleado();
                    break;
                case 6:
                    System.out.println("\n¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("❌ Opción inválida");
            }
        }

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│            MENÚ PRINCIPAL           │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ 1) Registrar Ingeniero              │");
        System.out.println("│ 2) Registrar Contador               │");
        System.out.println("│ 3) Registrar Vendedor               │");
        System.out.println("│ 4) Mostrar Todos los Empleados      │");
        System.out.println("│ 5) Buscar Empleado por ID           │");
        System.out.println("│ 6) Salir                            │");
        System.out.println("└─────────────────────────────────────┘");
    }

    static void registrarIngeniero() {

        System.out.println("\n📝 REGISTRAR NUEVO INGENIERO");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        System.out.print("Años de experiencia: ");
        int experiencia = sc.nextInt();
        sc.nextLine();

        System.out.print("Lenguajes principales: ");
        String lenguajes = sc.nextLine();

        Ingeniero ing = new Ingeniero(id, nombre, salario, especialidad, experiencia, lenguajes);
        empleados.add(ing);

        System.out.println("✅ Ingeniero registrado exitosamente");
    }

    static void registrarContador() {

        System.out.println("\n📝 REGISTRAR NUEVO CONTADOR");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Cantidad de clientes a cargo: ");
        int clientes = sc.nextInt();
        sc.nextLine();

        System.out.print("Tipo de certificación: ");
        String certificacion = sc.nextLine();

        System.out.print("Auditorías realizadas: ");
        int auditorias = sc.nextInt();
        sc.nextLine();

        Contador contador = new Contador(id, nombre, salario, clientes, certificacion, auditorias);
        empleados.add(contador);

        System.out.println("✅ Contador registrado exitosamente");
    }

    static void registrarVendedor() {

        System.out.println("\n📝 REGISTRAR NUEVO VENDEDOR");

        System.out.print("ID del empleado: ");
        String id = sc.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Salario base: $");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Zona de ventas: ");
        String zona = sc.nextLine();

        System.out.print("Porcentaje de comisión (%): ");
        double comision = sc.nextDouble();
        sc.nextLine();

        System.out.print("Meta mensual: $");
        double meta = sc.nextDouble();
        sc.nextLine();

        Vendedor vendedor = new Vendedor(id, nombre, salario, zona, comision, meta);
        empleados.add(vendedor);

        System.out.println("✅ Vendedor registrado exitosamente");
    }

    static void mostrarTodosEmpleados() {

        if (empleados.isEmpty()) {
            System.out.println("❌ No hay empleados registrados");
            return;
        }

        for (Empleado emp : empleados) {
            emp.mostrarInfo();
            System.out.println();
        }
    }

    static void buscarEmpleado() {

        System.out.print("Ingresa el ID del empleado a buscar: ");
        String idBuscado = sc.nextLine();

        for (Empleado emp : empleados) {
            if (emp.getId().equals(idBuscado)) {
                emp.mostrarInfo();
                return;
            }
        }

        System.out.println("❌ Empleado no encontrado");
    }
}
