package org.example;

import org.example.listaDoble.ListaDoble;

public class Punto06 {
    public static void main(String[] args) {
        ListaDoble<Integer> listaDoble = new ListaDoble<>();

        listaDoble.addEnd(3);
        listaDoble.addEnd(2);
        listaDoble.addEnd(1);

        listaDoble.imprimirAtras();

    }
}
