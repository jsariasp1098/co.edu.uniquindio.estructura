package org.example.util.listasSimples;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class simpleList<T> implements Iterable<T>{
    private simpleNode<T> firstNode;
    private simpleNode<T> lastNode;
    private int size;

    public simpleList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
    }

    public simpleNode<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(simpleNode<T> firstNode) {
        this.firstNode = firstNode;
    }

    public simpleNode<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(simpleNode<T> lastNode) {
        this.lastNode = lastNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addEnd(T value){
        simpleNode<T> node = new simpleNode<T>(value);
        if(isEmpty()){
            firstNode =  node;
        }else{
            lastNode.setNextNode(node);

        }
        lastNode = node;
        size++;
    }
    public void addFirst (T value){
        simpleNode<T> node = new simpleNode<T>(value);
        if(isEmpty()){
            firstNode = node;
            lastNode = node;
        }
        else{
            node.setNextNode(firstNode);
            firstNode = node;
        }
        size++;
    }
    public void imprimirLista(){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }else{
            simpleNode<T> aux = firstNode;
            while(aux != null){
                System.out.printf(aux.getValue() + " ");
                aux = aux.getNextNode();
            }
        }
    }
    public void imprimirLista2(){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }
        else{
            for (simpleNode<T> aux = firstNode; aux != null; aux = aux.getNextNode()) {
                System.out.printf(aux.getValue() + " ");
            }
        }
    }
    public void imprimirListaPosicionesPares (){
        if(isEmpty()){
            System.out.println("Lista Vacia\n");
        }else {
            int i = 0;
            for (simpleNode<T> aux = firstNode; aux != null; aux = aux.getNextNode()) {
                if(i % 2 == 0) {
                    System.out.println(aux.getValue() + " ");
                }
                i++;
            }
        }
    }
    public void printRecursiveList(){
        printRecursiveList(firstNode);
    }
    private void printRecursiveList(simpleNode<T> aux) {
        if(aux == null){
            System.out.println("Termine");
        }
        else{
            System.out.println(aux.getValue() + " ");
            printRecursiveList(aux.getNextNode());
        }
    }
    public void deleteFirst(){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            firstNode = firstNode.getNextNode();
        }
        size--;
    }
    public void deleteEnd(){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }
        if(size == 1){
            deleteAll();
        }else {
            simpleNode<T> aux = firstNode;
            while(aux.getNextNode() != lastNode){
                aux = aux.getNextNode();
            }
            lastNode = aux;
            aux.setNextNode(null);
        }
        size--;
    }
    public void deleteAll(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public simpleList<T> posicionesImpares(){
        simpleList<T> auxImpares = new simpleList<>();
        if(isEmpty()){
             throw new RuntimeException("Lista Vacia");
         }else{
             int i = 0;
             for (simpleNode<T> aux = firstNode; aux != null; aux = aux.getNextNode()) {
                 if(i % 2 != 0) {
                     auxImpares.addEnd(aux.getValue());
                 }
                 i++;
             }
         }
        return auxImpares;
    }
    public simpleList<T> parValue(){
        simpleList<T> auxPar = new simpleList<>();
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            for (simpleNode<T> aux = firstNode; aux != null; aux = aux.getNextNode()) {
                if(isPar(aux.getValue())) {
                    auxPar.addEnd(aux.getValue());
                }
            }
        }
        return auxPar;
    }
    public Integer repeatedValue(T comparar){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            Integer i = 0;
            for (simpleNode<T> aux = firstNode; aux != null; aux = aux.getNextNode()) {
                if(aux.getValue().equals(comparar)) {
                    i ++;
                }
            }
            return i;
        }
    }
    public void deletePar(){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            while (firstNode != null && isPar(firstNode.getNextNode().getValue())){
                firstNode = firstNode.getNextNode();
            }
            simpleNode<T> actual = firstNode;
            while(actual.getNextNode() != null){
                if(isPar(actual.getNextNode().getValue())){
                    actual.setNextNode(actual.getNextNode().getNextNode());
                    size--;
                }else {
                    actual = actual.getNextNode();
                }
            }
        }
    }

    private boolean isPar(T dato) {
        if (dato instanceof Integer) {
            return ((Integer) dato) % 2 == 0;
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorLista();
    }

    public simpleList<T> joinList(simpleList<T> lista1, simpleList<T> lista2) {
        simpleList<T> listaUnida = new simpleList<>();
        if(lista1.isEmpty() && lista2.isEmpty()){
            System.out.println("Listas Vacia\n");
        }else {
            for (simpleNode<T> aux = lista1.firstNode; aux != null; aux = aux.getNextNode()) {
                listaUnida.addEnd(aux.getValue());
            }
            for (simpleNode<T> aux = lista2.firstNode; aux != null; aux = aux.getNextNode()){
                listaUnida.addEnd(aux.getValue());
            }
        }
        return listaUnida;
    }

    private class IteradorLista implements Iterator<T> {
        private simpleNode<T> actual = firstNode;

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T valor = actual.getValue();
            actual = actual.getNextNode();
            return valor;
        }
    }
}
