package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto04 {
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();

        lista.addEnd(2);
        lista.addEnd(3);
        lista.addEnd(4);
        lista.addEnd(7);
        lista.addEnd(8);

        ListaSimple<Integer> listaPar = new ListaSimple<>();

        listaPar = lista.valorPar();

        listaPar.imprimirLista();

    }


}
