package org.example.structures.RedBlackTree;

public class RBTreeNode<T extends Comparable<T>> {
    private T value;
    private RBTreeNode<T> leftNode;
    private RBTreeNode<T> rightNode;
    private boolean isRed;

    public RBTreeNode(T value) {
        this.value = value;
        this.isRed = true;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RBTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RBTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public RBTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(RBTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public boolean getIsRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }
}
