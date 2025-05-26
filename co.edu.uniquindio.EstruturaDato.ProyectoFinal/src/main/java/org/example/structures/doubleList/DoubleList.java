package org.example.structures.doubleList;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleList<T> implements Iterable<T> {
    private int size;
    private DoubleNode firstNode;
    private DoubleNode lastNode;
    private DoubleNode previousNode;
    private DoubleNode nextNode;

    public DoubleList() {
        this.size = 0;
        this.firstNode = null;
        this.lastNode = null;
        this.previousNode = null;
        this.nextNode = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DoubleNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(DoubleNode firstNode) {
        this.firstNode = firstNode;
    }

    public DoubleNode getLastNode() {
        return lastNode;
    }

    public void setLastNode(DoubleNode lastNode) {
        this.lastNode = lastNode;
    }

    public DoubleNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleNode previousNode) {
        this.previousNode = previousNode;
    }

    public DoubleNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode nextNode) {
        this.nextNode = nextNode;
    }

    public void addEnd(T valor){
        DoubleNode<T> nodo = new DoubleNode<T>(valor);
        if(firstNode == null){
                firstNode = lastNode = nodo;
            }else{
                lastNode.setNextNode(nodo);
                nodo.setPreviousNode(lastNode);
                lastNode = nodo;
            }
        size++;

    }
    public void imprimirAtras(){
        if (isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else {
            DoubleNode<T> actual = lastNode;
            while(actual!=null){
                System.out.println(actual.getValue()+ " ");
                actual = actual.getPreviousNode();
            }
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorListaDoble();
    }
    private class IteradorListaDoble implements Iterator<T> {
        private DoubleNode<T> actual = firstNode;
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
