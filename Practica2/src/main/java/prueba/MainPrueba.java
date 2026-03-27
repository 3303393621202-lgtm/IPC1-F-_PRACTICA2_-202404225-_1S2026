package prueba;

import modelo.Personaje;
import modelo.ListaPersonajes;
import java.util.Scanner;

public class MainPrueba {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Cargar personajes iniciales
        ListaPersonajes.cargarIniciales();

        int opcion;

        do {
            // 2. Imprimir vector actual
            System.out.println("\n--- LISTA DE PERSONAJES ---");

            for (int i = 0; i < ListaPersonajes.size(); i++) {
                Personaje p = ListaPersonajes.get(i);

                System.out.println(
                        "Código: " + p.getCodigo() +
                        " | Nombre: " + p.getNombre() +
                        " | Casa: " + p.getCasa() +
                        " | Escoba: " + p.getEscoba()
                );
            }

            // 3. Menú
            System.out.println("\n1. Agregar personaje");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (opcion == 1) {

                // 4. Ingreso de datos
                System.out.print("Código: ");
                String codigo = sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Casa: ");
                String casa = sc.nextLine();

                System.out.println("Seleccione escoba:");
                System.out.println("1. Nimbus 2000");
                System.out.println("2. Nimbus 2001");
                System.out.println("3. Saeta de Fuego");

                int opEscoba = sc.nextInt();
                sc.nextLine();

                String escoba = "";

                // switch para escoba
                switch (opEscoba) {
                    case 1: escoba = "Nimbus 2000"; break;
                    case 2: escoba = "Nimbus 2001"; break;
                    case 3: escoba = "Saeta de Fuego"; break;
                    default: escoba = "Nimbus 2000";
                }
                int puntos = 0;

                // 5. Crear objeto (POO)
                Personaje nuevo = new Personaje(codigo, nombre, casa, escoba, puntos);

                // 6. Agregar al vector
                boolean agregado = ListaPersonajes.agregar(nuevo);

                if (agregado) {
                    System.out.println("Personaje agregado correctamente");
                } else {
                    System.out.println("Vector lleno (máximo 10 personajes)");
                }
            }

        } while (opcion != 2); // ciclo do-while

        System.out.println("Programa finalizado.");
    }
}