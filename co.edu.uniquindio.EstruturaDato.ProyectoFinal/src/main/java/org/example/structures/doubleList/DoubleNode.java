package org.example.structures.doubleList;

public class DoubleNode<T> {
    private DoubleNode nextNode;
    private DoubleNode previousNode;
    private T value;

    public DoubleNode() {
        this.nextNode = null;
        this.previousNode = null;
        this.value = value;
    }

    public DoubleNode(T value) {
        this.value = value;
    }

    public DoubleNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleNode previousNode) {
        this.previousNode = previousNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
