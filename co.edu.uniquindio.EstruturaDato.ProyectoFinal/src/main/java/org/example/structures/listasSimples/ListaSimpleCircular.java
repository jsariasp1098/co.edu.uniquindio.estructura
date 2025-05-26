package org.example.structures.listasSimples;

public class ListaSimpleCircular<T> {
    private SimpleNode<T> nodoPrimero;
    private SimpleNode<T> nodoUltimo;
    private int tamanio;

    public ListaSimpleCircular() {
        this.tamanio = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
    }

    public SimpleNode<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(SimpleNode<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public SimpleNode<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(SimpleNode<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    public void addEnd(T valor){
        SimpleNode<T> nodo = new SimpleNode<>(valor);
        if(isEmpty()){
            nodoPrimero = nodoUltimo = nodo;
            nodo.setNextNode(nodoPrimero);
        }else{
            nodoUltimo.setNextNode(nodo);
            nodo.setNextNode(nodoPrimero);
            nodoUltimo= nodo;
        }

        tamanio++;
    }
    public void buscar(T comparar){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            Integer i = 0;
            for (SimpleNode<T> aux = nodoPrimero; aux != nodoUltimo; aux = aux.getNextNode()) {
                if(aux.getValue().equals(comparar)) {
                    System.out.println(aux.getValue()+ " Posicion: " + i);
                }
                i++;
            }
            if(nodoUltimo.getValue().equals(comparar)){
                System.out.println(nodoUltimo.getValue()+ "Posicion: " + i);
            }
        }
    }
    public boolean isEmpty(){
        return tamanio == 0;
    }
}
