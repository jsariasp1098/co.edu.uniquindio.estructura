package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto10 {
    public static void main(String[] args) {
        ListaSimple<Integer> lista1 = new ListaSimple<>();
        ListaSimple<Integer> lista2 = new ListaSimple<>();

        lista1.addEnd(1);
        lista1.addEnd(2);
        lista1.addEnd(3);
        lista1.addEnd(4);

        lista2.addEnd(5);
        lista2.addEnd(6);
        lista2.addEnd(7);
        lista2.addEnd(8);

        ListaSimple<Integer> listaUnida = new ListaSimple<>();
        listaUnida = listaUnida.unirLista(lista1, lista2);
        listaUnida.imprimirLista();
    }




}
