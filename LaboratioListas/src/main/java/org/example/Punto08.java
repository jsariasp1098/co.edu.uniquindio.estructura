package org.example;

import org.example.listaDoble.ListaDoble;
import org.example.listasSimples.ListaSimple;

public class Punto08 {
    public static void main(String[] args) {
        ListaDoble<Persona> listaDoble = new ListaDoble<>();

        listaDoble.addEnd(new Persona("Emiliana", "123456"));
        listaDoble.addEnd(new Persona("Juan", "12345"));
        listaDoble.addEnd(new Persona("Lina", "1234"));
        listaDoble.addEnd(new Persona("Mauricio", "123"));
        listaDoble.addEnd(new Persona("Hilda", "12"));

        ListaDoble<Persona> listaDoble1 = obtenerCedulaPar(listaDoble);

        for(Persona persona : listaDoble1) {
            System.out.println(persona);
        }


    }
    private static ListaDoble<Persona> obtenerCedulaPar(ListaDoble<Persona> listaPersonas) {
        ListaDoble<Persona> listaAux = new ListaDoble<>();
        for(Persona p : listaPersonas) {
            if(p.getCedula().length() % 2 == 0) {
                listaAux.addEnd(p);
            }
        }
        return listaAux;
    }
}
