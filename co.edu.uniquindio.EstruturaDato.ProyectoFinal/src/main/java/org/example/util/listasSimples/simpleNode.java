package org.example.util.listasSimples;

public class simpleNode<T>{
    private T value;
    private simpleNode<T> nextNode;

    public simpleNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public simpleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(simpleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

}
