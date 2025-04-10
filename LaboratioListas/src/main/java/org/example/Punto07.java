package org.example;

import org.example.listaDoble.ListaDoble;

public class Punto07 {
    public static void main(String[] args) {
        ListaDoble<Integer> listaDoble = new ListaDoble<>();

        listaDoble.addEnd(6);
        listaDoble.addEnd(7);
        listaDoble.addEnd(8);

        for(Integer i : listaDoble) {
            System.out.println(i);
        }
    }
}
