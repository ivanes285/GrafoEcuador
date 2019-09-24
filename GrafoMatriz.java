/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo_01;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author David
 */
public class GrafoMatriz {

    int numVertices;
    int matriz[][];
    Vertice vertices[];

//    static int maxVertice = 20;
    public GrafoMatriz(int n) {
        matriz = new int[n][n];
        vertices = new Vertice[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = 0;
            }
        }
        numVertices = 0;
    }

    //busca un vertice por el nombre y devuelve su numero, si no encuentra retorna -1
    public int numVertice(String vertice) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].nombre.equals(vertice)) {
                return i;
            }
        }
        return -1;
    }

    public void nuevoVertice(String nombre) {
        if (numVertice(nombre) == -1) {
            Vertice v = new Vertice(nombre);
            v.numero = numVertices;
            vertices[numVertices] = v;
            numVertices++;
        }
    }

    public void nuevoArco(String a, String b) throws Exception {
        int numA, numB;
        System.out.println(a + "," + b);
        numA = numVertice(a);
        numB = numVertice(b);
        if (numA == -1 || numB == -1) {
            throw new Exception("Error: Vertice no existe: " + numA + "," + numB);
        } else {
            matriz[numA][numB] = 1;
        }
    }

    public String imprimirMatriz(int m[][]) {
        String respuesta = "";
        for (int i = 0; i < vertices.length; i++) {
            respuesta = respuesta + "\n";
            for (int j = 0; j < vertices.length; j++) {
                respuesta = respuesta + "\t" + m[i][j];
            }
        }
        return respuesta;
    }

    public String imprimirVertiString() {
        String resp = "";
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null) {
                resp = resp + "\n" + vertices[i].imprimirVertice();
            }
        }
        return resp;
    }

    public void recorrerAnchura(GrafoMatriz g, String inicial) throws Exception {
        int noMarcado = -1;
        int w, posVisitado, v = g.numVertice(inicial);
        int M[] = new int[g.numVertices];
        if (v < 0) {
            throw new Exception("Vertice inicial no existe");
        }
        Queue<Object> cola = new LinkedList<>();
        for (int i = 0; i < g.numVertices; i++) {
            M[i] = noMarcado;//llenamos el arreglo con -1
        }
        M[v] = 0;//vertice inicial queda marcado
        MostrarArray(M);
        cola.add(new Integer(v));
        MostrarCola(cola);
        while (!cola.isEmpty()) {
            Integer visitado = (Integer) cola.poll();
            MostrarCola(cola);
            posVisitado = visitado.intValue();
            System.out.println("Vertice " + g.vertices[posVisitado].imprimirVertice() + " Ya visitado");
            for (int i = 0; i < g.numVertices; i++) {
                if (g.matriz[posVisitado][i] == 1 && M[i] == noMarcado) {
                    M[i] = 0;
                    MostrarArray(M);
                    cola.add(new Integer(i));
                    MostrarCola(cola);
                }
            }
        }
    }

    public void MostrarCola(Queue cola) {
        System.out.print("Cola: ");
        for (Object object : cola) {
            System.out.print((int) object + ",");
        }
        System.out.println();
    }

    public void MostrarArray(int a[]) {
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    public int[][] matrizCaminos() throws Exception {
        int p[][] = matriz;
        for (int k = 0; k < vertices.length; k++) {
            for (int i = 0; i < vertices.length; i++) {
                for (int j = 0; j < vertices.length; j++) {
                    p[i][j] = Math.min(p[i][j] + p[i][k] * p[k][j], 1);
                }
            }
        }
        return p;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
