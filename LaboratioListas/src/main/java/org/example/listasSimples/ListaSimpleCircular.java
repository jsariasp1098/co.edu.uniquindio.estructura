package org.example.listasSimples;

public class ListaSimpleCircular<T> {
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;

    public ListaSimpleCircular() {
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
    public void addEnd(T valor){
        Nodo<T> nodo = new Nodo<>(valor);
        if(isEmpty()){
            nodoPrimero = nodoUltimo = nodo;
            nodo.setNodoSiguiente(nodoPrimero);
        }else{
            nodoUltimo.setNodoSiguiente(nodo);
            nodo.setNodoSiguiente(nodoPrimero);
            nodoUltimo= nodo;
        }

        tamanio++;
    }
    public void buscar(T comparar){
        if(isEmpty()){
            throw new RuntimeException("Lista Vacia");
        }else{
            Integer i = 0;
            for (Nodo<T> aux = nodoPrimero; aux != nodoUltimo; aux = aux.getNodoSiguiente()) {
                if(aux.getValor().equals(comparar)) {
                    System.out.println(aux.getValor()+ "Posicion: " + i);
                }
                i++;
            }
            if(nodoUltimo.getValor().equals(comparar)){
                System.out.println(nodoUltimo.getValor()+ "Posicion: " + i);
            }
        }
    }
    public boolean isEmpty(){
        return tamanio == 0;
    }
}
