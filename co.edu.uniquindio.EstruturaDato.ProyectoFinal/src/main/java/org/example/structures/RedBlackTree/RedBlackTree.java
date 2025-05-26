package org.example.structures.RedBlackTree;

public class RedBlackTree<T extends Comparable<T>> {
    private RBTreeNode<T> root;

    private boolean isRed(RBTreeNode<T> node) {
        return node != null && node.getIsRed();
    }

    private RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        RBTreeNode<T> aux = node.getRightNode();
        node.setRightNode(aux.getLeftNode());
        aux.setLeftNode(node);
        aux.setIsRed(node.getIsRed());
        node.setIsRed(true);
        return aux;
    }
    private RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        RBTreeNode<T> aux = node.getLeftNode();
        node.setLeftNode(aux.getRightNode());
        aux.setRightNode(node);
        aux.setIsRed(node.getIsRed());
        node.setIsRed(true);
        return aux;
    }
    private void flipColors(RBTreeNode<T> node) {
        node.setIsRed(true);
        if (node.getLeftNode() != null) node.getLeftNode().setIsRed(false);
        if (node.getRightNode() != null) node.getRightNode().setIsRed(false);
    }
    public void insert(T value) {
        root = insert(root, value);
        root.setIsRed(false);
    }

    private RBTreeNode<T> insert(RBTreeNode<T> aux, T value) {

        if (aux == null) return new RBTreeNode<>(value);

        if (value.compareTo(aux.getValue()) < 0) {
            aux.setLeftNode(insert(aux.getLeftNode(), value));
        } else if (value.compareTo(aux.getValue()) > 0) {
            aux.setRightNode(insert(aux.getRightNode(), value));
        }

        // Rotaciones y balanceo
        if (isRed(aux.getRightNode()) && !isRed(aux.getLeftNode())) aux = rotateLeft(aux);
        if (isRed(aux.getLeftNode()) && isRed(aux.getLeftNode().getLeftNode())) aux = rotateRight(aux);
        if (isRed(aux.getLeftNode()) && isRed(aux.getRightNode())) flipColors(aux);

        return aux;
    }

    public boolean contains(T value) {
        RBTreeNode<T> current = root;
        while (current != null) {
            if (value.compareTo(current.getValue()) < 0) current = current.getLeftNode();
            else if (value.compareTo(current.getValue()) > 0) current = current.getRightNode();
            else return true;
        }
        return false;
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(RBTreeNode<T> node) {
        if (node == null) return;
        inOrder(node.getLeftNode());
        System.out.println(node.getValue() + (node.getIsRed() ? " (R)" : " (B)"));
        inOrder(node.getRightNode());
    }
}
