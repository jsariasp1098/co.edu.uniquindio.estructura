package org.example.structures.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return peso == 0;
    }
    public void insert (T valor) {
        Node<T> rootNode = new Node<T>(valor, null, null);
        insertRecusive(rootNode, root);
        peso ++;
    }

    private void insertRecusive(Node<T> newNode, Node<T> rootFather) {
        if (this.root == null) {
            root = newNode;
        }else {
            if (newNode.getValue().compareTo(rootFather.getValue()) < 0) {
                if (rootFather.getLeftNode() == null) {
                    rootFather.setLeftNode(newNode);
                } else {
                    insertRecusive(newNode, rootFather.getLeftNode());
                }

            } else {
                if (rootFather.getRightNode() == null) {
                    rootFather.setRightNode(newNode);
                } else {
                    insertRecusive(newNode, rootFather.getRightNode());
                }
            }
        }
    }
    public List<T> inorder() {
        List<T> listInOrder = new ArrayList<T>();
        listInOrder = inorderRecursive(root, listInOrder);
        System.out.println();
        return listInOrder;
    }

    private List<T> inorderRecursive(Node<T> root, List<T> listInOrder) {
        if (root == null) {
            return listInOrder;
        }else {
            inorderRecursive(root.getLeftNode(), listInOrder);
            listInOrder.add(root.getValue());
            System.out.println(root.getValue() + " ");
            inorderRecursive(root.getRightNode(), listInOrder);
        }
            return listInOrder;
    }
    public List<T> preOrder() {
        List<T> listPreOrder = new ArrayList<T>();
        listPreOrder = preOrderRecursive(root, listPreOrder);
        System.out.println();
        return listPreOrder;
    }
    private List<T> preOrderRecursive(Node<T> root, List<T> listPreOrder) {
        if (root == null) {
            return listPreOrder;
        }else {
            System.out.print(root.getValue() + " ");
            listPreOrder.add(root.getValue());
            preOrderRecursive(root.getLeftNode(), listPreOrder);
            preOrderRecursive(root.getRightNode(), listPreOrder);
        }
        return listPreOrder;
    }
    public List<T> postOrder() {
        List<T> listPostOrder = new ArrayList<T>();
        listPostOrder = postOrderRecursive(root, listPostOrder);
        System.out.println();
        return listPostOrder;
    }
    private List<T> postOrderRecursive(Node<T> root, List<T> listPostOrder) {
        if (root == null) {
            return listPostOrder;
        }
        postOrderRecursive(root.getLeftNode(), listPostOrder);
        postOrderRecursive(root.getRightNode(), listPostOrder);
        listPostOrder.add(root.getValue());
        System.out.print(root.getValue() + " ");
        return listPostOrder;
    }
    public T search ( T valor){
        return searhValueRecursive(root, valor);
    }

    private T searhValueRecursive(Node<T> root, T value) {
        if (root == null) {
            return null;
        }
        if (root.getValue().compareTo(value)==0) {
            return root.getValue();
        }else if (root.getValue().compareTo(value)<0) {
            return searhValueRecursive(root.getLeftNode(), value);
        }else {
            return searhValueRecursive(root.getRightNode(), value);
        }
    }
    public int weight() {
        return peso;
    }
    public int height(){
        return heightRecursive(root);
    }

    private int heightRecursive(Node<T> root) {
        if (root == null) {
            return 0;
        }
        int alturaLeft = heightRecursive(root.getLeftNode());
        int alturaRight = heightRecursive(root.getRightNode());

        return 1 + Math.max(alturaLeft, alturaRight);
    }
    public int level (){
        return heightRecursive(root) - 1;
    }
    public int countLeaves(){
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return 1;
        }
        return countLeavesRecursive(root.getLeftNode()) + countLeavesRecursive(root.getRightNode());
    }
    public T lowest () {
        if (root == null) {
            throw new RuntimeException("El arbol esta vacio");
        }
        Node<T> position = root;
        while (position.getLeftNode() != null) {
            position = position.getLeftNode();
        }
        return position.getValue();
    }
    public List<T> printAmplitude() {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return null;
        }
        List<T> travelAmplitude = new ArrayList<T>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> position = queue.poll();
            System.out.print(position.getValue() + " ");
            travelAmplitude.add(position.getValue());

            if (position.getLeftNode() != null) {
                queue.add(position.getLeftNode());
            }
            if (position.getRightNode() != null) {
                queue.add(position.getRightNode());
            }
        }
        return travelAmplitude;
    }
    public void deleteData(T data) {
        root = daleteNode(root, data);
    }

    private Node<T> daleteNode(Node<T> aux, T data) {
        if (aux == null) {
            return null;
        }

        if (data.compareTo(aux.getValue()) < 0) {
            aux.setLeftNode(daleteNode(aux.getLeftNode(), data));
        } else if (data.compareTo(aux.getValue()) > 0) {
            aux.setRightNode(daleteNode(aux.getRightNode(), data));
        } else {
            // Caso 1: sin hijos
            if (aux.getLeftNode() == null && aux.getRightNode() == null) {
                peso--;
                return null;
            }

            // Caso 2: un solo hijo
            if (aux.getLeftNode() == null) {
                peso--;
                return aux.getRightNode();
            }
            if (aux.getRightNode() == null) {
                peso--;
                return aux.getRightNode();
            }

            // Caso 3: dos hijos
            // Buscar el menor del subárbol derecho (sucesor inorden)
            Node<T> successor = findMinimum(aux.getRightNode());
            aux.setValue(successor.getValue());
            aux.setRightNode(daleteNode(aux.getRightNode(), successor.getValue()));
        }
        return aux;
    }

    private Node<T> findMinimum (Node<T> node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }
    public Node<T> smallestNode(){
        if (root == null){
            return null;
        }
        Node<T> position = root;
        while (position.getLeftNode() != null){
            position = position.getLeftNode();
        }
        return position;
    }
    public Node<T> largestNode(){
        if (root == null){
            return null;
        }
        Node<T> position = root;
        while (position.getRightNode() != null){
            position = position.getRightNode();
        }
        return position;
    }
    public void deleteTree(){
        root = null;
        peso = 0;
    }
    public Node<T> obtenerRoot() {
        return root;
    }

}
