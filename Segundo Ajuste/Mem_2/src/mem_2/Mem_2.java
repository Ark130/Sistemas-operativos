/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mem_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sunse
 */
public class Mem_2 {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Windows_2 = 2000;

        System.out.print("Ingrese la cantidad de particiones: ");
        int cantidadParticiones = scanner.nextInt();

        List<Particion> particiones = new ArrayList<>();
        for (int i = 0; i < cantidadParticiones; i++) {
            System.out.print("Ingrese el tamano de la particion " + (i + 1) + ": ");
            int tamanoParticion = scanner.nextInt();
            particiones.add(new Particion(i + 1, tamanoParticion));
        }

        System.out.println("\nIngresar procesos:");
        List<Proceso> procesos = new ArrayList<>();
        scanner.nextLine(); // Consumir la nueva línea pendiente
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingrese el nombre del proceso " + (i) + ": ");
            String nombreProceso = scanner.nextLine();
            System.out.print("Ingrese el tamano del proceso " + (i) + ": ");
            int tamanoProceso = scanner.nextInt();
            procesos.add(new Proceso(nombreProceso, tamanoProceso));
            scanner.nextLine(); // Consumir la nueva línea pendiente
        }

        System.out.println("\n");

        // Asignación de procesos a particiones
        int lastPartitionIndex = 0;
        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);
            boolean asignado = false;

            for (int j = lastPartitionIndex; j < particiones.size(); j++) {
                Particion particion = particiones.get(j);
                if (!particion.ocupada && particion.tamano >= proceso.tamano) {
                    particion.ocupada = true;
                    particion.nombreProceso = proceso.nombre;
                    asignado = true;
                    System.out.println(proceso.nombre + " asignado a la particion " + particion.id);
                    lastPartitionIndex = j + 1;
                    break;
                }
            }

            if (!asignado) {
                System.out.println(proceso.nombre + " no fue asignado a ninguna particion");
            }
        }

        int espacioOcupado = 0;
        for (Particion particion : particiones) {
            if (particion.ocupada) {
                for (Proceso proceso : procesos) {
                    if (particion.nombreProceso.equals(proceso.nombre)) {
                        espacioOcupado += proceso.tamano;
                        break;
                    }
                }
            }
        }

        if (espacioOcupado > Windows_2) {
            System.out.println("\nNo hay suficiente memoria para asignar todos los procesos.");
        } else {
            int espacioSobrante = Windows_2 - espacioOcupado;
            System.out.println("\nEspacio restante de Windows 2 es de: " + espacioSobrante + " de un total de " + Windows_2);
        }

        scanner.close();
    }
    
}
