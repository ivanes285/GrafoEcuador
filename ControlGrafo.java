/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo_01;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class ControlGrafo {

    public static void main(String args[]) {
        Scanner k = new Scanner(System.in);
        GrafoMatriz grafo;

        System.out.println("Ingrese el numero de Vertices");
        int size = k.nextInt();
        grafo = new GrafoMatriz(size);

        for (int i = 0; i == 0;) {
            System.out.println("\n");
            System.out.println("Ingresar vertices   1");
            System.out.println("Nuevo Arco          2");
            System.out.println("Ver Vertices        3");
            System.out.println("Ver Matriz          4");
            System.out.println("Salir               5");
            switch (k.nextInt()) {
                case 1:
                    for (int j = 0; j < size; j++) {
                        grafo.nuevoVertice(k.next());
                    }
                    break;
                case 2:
                    try {
                        grafo.nuevoArco(k.next(), k.next());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(grafo.imprimirVertiString());
                    break;
                case 4:
                    try {
                        System.out.println(grafo.imprimirMatriz(grafo.getMatriz()));
                        System.out.println(grafo.imprimirMatriz(grafo.matrizCaminos()));
                        System.out.println("Vertice inicial:");
                        grafo.recorrerAnchura(grafo, k.next());
                    } catch (Exception ex) {
                        System.out.println("Error:" + ex);
                        ex.printStackTrace();
                    }
                    break;
                case 5:
                    i++;
                    break;
            }
        }
    }
}
