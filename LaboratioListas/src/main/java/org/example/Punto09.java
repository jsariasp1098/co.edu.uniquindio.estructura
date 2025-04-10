package org.example;

import org.example.listasSimples.ListaSimpleCircular;

public class Punto09 {
    public static void main(String[] args) {
        ListaSimpleCircular<Integer> lista = new ListaSimpleCircular<>();

        lista.addEnd(4);
        lista.addEnd(3);
        lista.addEnd(4);
        lista.addEnd(2);
        lista.addEnd(3);

        lista.buscar(4);
    }
}
