/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package majuste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sunse
 */
public class Majuste {
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

        // Ordenar las particiones utilizando el ordenamiento burbuja
        int n = particiones.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (particiones.get(j).tamano > particiones.get(j + 1).tamano) {
                    Particion temp = particiones.get(j);
                    particiones.set(j, particiones.get(j + 1));
                    particiones.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nIngresar procesos:");
        List<Proceso> procesos = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            scanner.nextLine();
            System.out.print("Ingrese el nombre del proceso " + (i) + ": ");
            String nombreProceso = scanner.nextLine();
            System.out.print("Ingrese el tamano del proceso " + (i) + ": ");
            int tamanoProceso = scanner.nextInt();
            procesos.add(new Proceso(nombreProceso, tamanoProceso));
        }

        System.out.println("\n");
        
        // Asignación de procesos a particiones
        for (int i = 0; i < procesos.size(); i++) {
            Proceso proceso = procesos.get(i);
            boolean asignado = false;

            for (int j = 0; j < particiones.size(); j++) {
                Particion particion = particiones.get(j);
                if (!particion.ocupada && particion.tamano >= proceso.tamano) {
                    particion.ocupada = true;
                    particion.nombreProceso = proceso.nombre;
                    asignado = true;
                    System.out.println(proceso.nombre + " asignado a la particion " + particion.id);
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
