package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto03 {

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();

        lista.addEnd(1);
        lista.addEnd(3);
        lista.addEnd(4);
        lista.addEnd(7);
        lista.addEnd(8);

     //   lista.imprimirLista();

        lista.deletePares();

        lista.imprimirLista();
    }


}
