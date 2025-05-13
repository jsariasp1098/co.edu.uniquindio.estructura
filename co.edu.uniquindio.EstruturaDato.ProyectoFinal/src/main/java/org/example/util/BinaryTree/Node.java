package org.example.util.BinaryTree;

public class Node <T extends Comparable<T>> {
    private T value;
    private Node<T> rightNode;
    private Node<T> leftNode;

    public Node(T valor, Node<T> rightNode, Node<T> leftNode) {
        this.value = valor;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

}
