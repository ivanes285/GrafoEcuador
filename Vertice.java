/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo_01;

/**
 *
 * @author David
 */
public class Vertice {

    String nombre;
    int numero;

    public Vertice(String nombre) {
        this.nombre = nombre;
        numero = -1;
    }

    public String imprimirVertice() {
        return nombre + " #" + numero;
    }
    
    public boolean equals(Vertice n){
        return nombre.equals(n.nombre);
    }
    

}
