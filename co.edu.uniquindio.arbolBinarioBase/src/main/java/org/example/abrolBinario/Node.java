package org.example.abrolBinario;

public class Node {
    private int value;
    private Node rightNode;
    private Node leftNode;

    public Node(int valor, Node rightNode, Node leftNode) {
        this.value = valor;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
}
