package org.example.listaDoble;

import org.example.listasSimples.ListaSimple;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDoble<T> implements Iterable<T> {
    private int tamanio;
    private NodoDoble nodoPrimero;
    private NodoDoble nodoUltimo;
    private NodoDoble nodoPrevious;
    private NodoDoble nodoNext;

    public ListaDoble() {
        this.tamanio = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
        this.nodoPrevious = null;
        this.nodoNext = null;
    }
    public void addEnd(T valor){
        NodoDoble<T> nodo = new NodoDoble<T>(valor);
        if(nodoPrimero == null){
                nodoPrimero = nodoUltimo = nodo;
            }else{
                nodoUltimo.setNodoSiguiente(nodo);
                nodo.setNodoAnterior(nodoUltimo);
                nodoUltimo = nodo;
            }
        tamanio++;

    }
    public void imprimirAtras(){
        if (isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else {
            NodoDoble<T> actual = nodoUltimo;
            while(actual!=null){
                System.out.println(actual.getValor()+ " ");
                actual = actual.getNodoAnterior();
            }
        }
    }

    public boolean isEmpty(){
        return tamanio == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaDoble();
    }
    private class IteradorListaDoble implements Iterator<T> {
        private NodoDoble<T> actual = nodoPrimero;
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
