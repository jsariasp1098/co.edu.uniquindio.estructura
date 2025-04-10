package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto05 {
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();

        lista.addEnd(4);
        lista.addEnd(3);
        lista.addEnd(4);
        lista.addEnd(7);
        lista.addEnd(4);

        int cantidad = lista.valorRepetido(3);

        System.out.println(cantidad);
    }
}
