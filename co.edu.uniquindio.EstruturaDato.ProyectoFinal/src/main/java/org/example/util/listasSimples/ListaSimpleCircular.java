package org.example.util.listasSimples;

public class ListaSimpleCircular<T> {
    private simpleNode<T> nodoPrimero;
    private simpleNode<T> nodoUltimo;
    private int tamanio;

    public ListaSimpleCircular() {
        this.tamanio = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
    }

    public simpleNode<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(simpleNode<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public simpleNode<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(simpleNode<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    public void addEnd(T valor){
        simpleNode<T> nodo = new simpleNode<>(valor);
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
            for (simpleNode<T> aux = nodoPrimero; aux != nodoUltimo; aux = aux.getNextNode()) {
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
