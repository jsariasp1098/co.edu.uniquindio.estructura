package org.example;

import org.example.listasSimples.ListaSimple;

public class Punto02 {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        Persona persona3 = new Persona();
        Persona persona4 = new Persona();
        ListaSimple<Persona> listaPersonas = new ListaSimple<>();

        persona1.setNombre("Juan");
        persona1.setCedula("12342");
        listaPersonas.addEnd(persona1);
        persona2.setNombre("Lina");
        persona2.setCedula("123456");
        listaPersonas.addEnd(persona2);
        persona3.setNombre("Maria");
        persona3.setCedula("12345");
        listaPersonas.addEnd(persona3);
        persona4.setNombre("Jhon");
        persona4.setCedula("12311456");
        listaPersonas.addEnd(persona4);

        ListaSimple<Persona> listaPersonas2 = new ListaSimple<>();
        listaPersonas2 = obtenerCedulaPar(listaPersonas);
        for(Persona p : listaPersonas2){
            System.out.println(p.toString());
        }
        //listaPersonas2.imprimirLista();
    }

    private static ListaSimple<Persona> obtenerCedulaPar(ListaSimple<Persona> listaPersonas) {
        ListaSimple<Persona> listaAux = new ListaSimple<>();
        for(Persona p : listaPersonas) {
            if(p.getCedula().length() % 2 ==0) {
                listaAux.addEnd(p);
            }
        }
        return listaAux;
    }
}
