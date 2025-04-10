package org.example.listasSimples;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimple <T> implements Iterable<T>{
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;

    public ListaSimple() {
        this.tamanio = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
    }

    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public Nodo<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(Nodo<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    public boolean isEmpty() {
        return tamanio == 0;
    }
    public void addEnd(T valor){
        Nodo<T> nodo = new Nodo<T>(valor);
        if(isEmpty()){
            nodoPrimero =  nodo;
        }else{
            nodoUltimo.setNodoSiguiente(nodo);

        }
        nodoUltimo  = nodo;
        tamanio ++;
    }
    public void addFirst (T valor){
        Nodo<T> nodo = new Nodo<T>(valor);
        if(isEmpty()){
            nodoPrimero = nodo;
            nodoUltimo = nodo;
        }
        else{
            nodo.setNodoSiguiente(nodoPrimero);
            nodoPrimero = nodo;
        }
        tamanio ++;
    }
    public void imprimirLista(){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }else{
            Nodo<T> aux = nodoPrimero;
            while(aux != null){
                System.out.printf(aux.getValor() + " ");
                aux = aux.getNodoSiguiente();
            }
        }
    }
    public void imprimirLista2(){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }
        else{
            for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                System.out.printf(aux.getValor() + " ");
            }
        }
    }
    public void imprimirListaPosicionesPares (){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }else {
            int i = 0;
            for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                if(i % 2 == 0) {
                    System.out.println(aux.getValor() + " ");
                }
                i++;
            }
        }
    }
    public void imprimirListaRecursivo(){
        imprimirListaRecursivo(nodoPrimero);

    }
    private void imprimirListaRecursivo(Nodo<T> aux) {
        if(aux == null){
            System.out.println("Termine");
        }
        else{
            System.out.println(aux.getValor() + " ");
            imprimirListaRecursivo(aux.getNodoSiguiente());
        }
    }
    public void deleteFirst(){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            nodoPrimero = nodoPrimero.getNodoSiguiente();
        }
        tamanio --;
    }
    public void deleteEnd(){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }
        if(tamanio == 1){
            deleteAll();
        }else {
            Nodo<T> aux = nodoPrimero;
            while(aux.getNodoSiguiente() != nodoUltimo){
                aux = aux.getNodoSiguiente();
            }
            nodoUltimo = aux;
            aux.setNodoSiguiente(null);
        }
        tamanio --;
    }
    public void deleteAll(){
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }
    public ListaSimple<T> posicionesImpares(){
        ListaSimple<T> auxImpares = new ListaSimple<>();
        if(isEmpty()){
             throw new RuntimeException("Lista Vacia");
         }else{
             int i = 0;
             for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                 if(i % 2 != 0) {
                     auxImpares.addEnd(aux.getValor());
                 }
                 i++;
             }
         }
        return auxImpares;
    }
    public ListaSimple<T> valorPar(){
        ListaSimple<T> auxPar = new ListaSimple<>();
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                if(esPar(aux.getValor())) {
                    auxPar.addEnd(aux.getValor());
                }
            }
        }
        return auxPar;
    }
    public Integer valorRepetido(T comparar){

        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            Integer i = 0;
            for (Nodo<T> aux = nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                if(aux.getValor().equals(comparar)) {
                    i ++;
                }
            }
            return i;
        }
    }
    public void deletePares(){

        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            while (nodoPrimero != null && esPar(nodoPrimero.getNodoSiguiente().getValor())){
                nodoPrimero = nodoPrimero.getNodoSiguiente();
            }
            Nodo<T> actual = nodoPrimero;
            while(actual.getNodoSiguiente() != null){
                if(esPar(actual.getNodoSiguiente().getValor())){
                    actual.setNodoSiguiente(actual.getNodoSiguiente().getNodoSiguiente());
                    tamanio --;
                }else {
                    actual = actual.getNodoSiguiente();
                }
            }
        }
    }
    private boolean esPar(T dato) {
        if (dato instanceof Integer) {
            return ((Integer) dato) % 2 == 0;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    public ListaSimple<T> unirLista(ListaSimple<T> lista1, ListaSimple<T> lista2) {
        ListaSimple<T> listaUnida = new ListaSimple<>();
        if(lista1.isEmpty() && lista2.isEmpty()){
            System.out.println("Listas Vacia\n");
        }else {
            for (Nodo<T> aux = lista1.nodoPrimero; aux != null; aux = aux.getNodoSiguiente()) {
                listaUnida.addEnd(aux.getValor());
            }
            for (Nodo<T> aux = lista2.nodoPrimero; aux != null; aux = aux.getNodoSiguiente()){
                listaUnida.addEnd(aux.getValor());
            }
        }
        return listaUnida;
    }

    private class IteradorLista implements Iterator<T> {
        private Nodo<T> actual = nodoPrimero;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T valor = actual.getValor();
            actual = actual.getNodoSiguiente();
            return valor;
        }
    }
}
