package com.company.logica;

import java.util.List;
import java.util.Scanner;

public class Application {

    private Scanner sc;
    private int opcion;
    private Almacen almacen;

    public Application() {
        this.sc = new Scanner(System.in);
        this.almacen = new Almacen();
    }

    public void mostrarMenu() {

        do {
            System.out.println("======================");
            System.out.println("= ALMACEN DE NUMEROS =");
            System.out.println("======================");
            System.out.println();
            System.out.println("Opciones:");
            System.out.println("1- Almacenar numeros");
            System.out.println("2- Recuperar numeros");
            System.out.println("0- Salir");
            System.out.println("======================");
            System.out.print("Opcion elegida: ");
            opcion = sc.nextInt();
            System.out.println("======================");
            ejecutarOpcion(opcion);
        } while (opcion != 0);

    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                almacen.cerrarRecursos();
                break;
            case 1:
                System.out.print("Introduce el numero: ");
                int numeroDado = sc.nextInt();
                almacen.almacenarNumero(numeroDado);
                break;
            case 2:
                List<Integer> lista = almacen.recuperarNumeros();
                System.out.print("Numeros recuperados: ");
                System.out.println(lista);
                break;
            default:
                System.out.println("La opcion elegida no es valida");

        }
    }

}
