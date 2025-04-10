package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto01 {
    public static void main(String[] args) {

        ListaSimple<Integer> lista = new ListaSimple<Integer>();
        ListaSimple<Integer> posicionesImpares;

        lista.addEnd(0);
        lista.addEnd(10);
        lista.addEnd(2);
        lista.addEnd(30);
        lista.addEnd(4);
        lista.addEnd(50);
        lista.addEnd(6);
        lista.addEnd(70);

        posicionesImpares = lista.posicionesImpares();

        posicionesImpares.imprimirLista();

    }

}
