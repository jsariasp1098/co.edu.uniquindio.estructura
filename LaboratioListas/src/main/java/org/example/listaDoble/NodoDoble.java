package org.example.listaDoble;

public class NodoDoble<T> {
    private NodoDoble nodoSiguiente;
    private NodoDoble nodoAnterior;
    private T valor;

    public NodoDoble() {
        this.nodoSiguiente = null;
        this.nodoAnterior = null;
        this.valor = valor;
    }

    public NodoDoble(T valor) {
        this.valor = valor;
    }

    public NodoDoble getNodoSiguiente() {
        return nodoSiguiente;
    }

    public void setNodoSiguiente(NodoDoble nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    public NodoDoble getNodoAnterior() {
        return nodoAnterior;
    }

    public void setNodoAnterior(NodoDoble nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}
