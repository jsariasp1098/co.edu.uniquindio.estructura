package org.example.abrolBinario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    private Node root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    public boolean isEmpty() {
        return peso == 0;
    }
    public void insert (int valor) {
        Node rootNode = new Node(valor, null, null);
        insertRecusive(rootNode, root);
        peso ++;
    }

    private void insertRecusive(Node newNode, Node rootFather) {
        if (this.root == null) {
            root = newNode;
        }else {
            if (newNode.getValue() < rootFather.getValue()) {
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
    public List<Integer> inorder() {
        List<Integer> listInOrder = new ArrayList<>();
        listInOrder = inorderRecursive(root, listInOrder);
        System.out.println();
        return listInOrder;
    }

    private List<Integer> inorderRecursive(Node root, List<Integer> listInOrder) {
        if (root == null) {
            return listInOrder;
        }else {
            inorderRecursive(root.getLeftNode(), listInOrder);
            listInOrder.add(root.getValue());
            System.out.print(root.getValue() + " ");
            inorderRecursive(root.getRightNode(), listInOrder);
        }
            return listInOrder;
    }
    public List<Integer> preOrder() {
        List<Integer> listPreOrder = new ArrayList<>();
        listPreOrder = preOrderRecursive(root, listPreOrder);
        System.out.println();
        return listPreOrder;
    }
    private List<Integer> preOrderRecursive(Node root, List<Integer> listPreOrder) {
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
    public List<Integer> postOrder() {
        List<Integer> listPostOrder = new ArrayList<>();
        listPostOrder = postOrderRecursive(root, listPostOrder);
        System.out.println();
        return listPostOrder;
    }
    private List<Integer> postOrderRecursive(Node root, List<Integer> listPostOrder) {
        if (root == null) {
            return listPostOrder;
        }
        postOrderRecursive(root.getLeftNode(), listPostOrder);
        postOrderRecursive(root.getRightNode(), listPostOrder);
        listPostOrder.add(root.getValue());
        System.out.print(root.getValue() + " ");
        return listPostOrder;
    }
    public boolean search ( int valor){
        return searhValueRecursive(root, valor);
    }

    private boolean searhValueRecursive(Node root, int valor) {
        if (root == null) {
            return false;
        }
        if (root.getValue() == valor) {
            return true;
        }
        if (root.getValue() > valor) {
            return searhValueRecursive(root.getLeftNode(), valor);
        }else {
            return searhValueRecursive(root.getRightNode(), valor);
        }
    }
    public int weight() {
        return peso;
    }
    public int height(){
        return heightRecursive(root);
    }

    private int heightRecursive(Node root) {
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

    private int countLeavesRecursive(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return 1;
        }
        return countLeavesRecursive(root.getLeftNode()) + countLeavesRecursive(root.getRightNode());
    }
    public int lowest () {
        if (root == null) {
            throw new RuntimeException("El arbol esta vacio");
        }
        Node position = root;
        while (position.getLeftNode() != null) {
            position = position.getLeftNode();
        }
        return position.getValue();
    }
    public List<Integer> printAmplitude() {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return null;
        }
        List<Integer> travelAmplitude = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node position = queue.poll();
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
    public void deleteData(int data) {
        root = daleteNode(root, data);
    }

    private Node daleteNode(Node aux, int data) {
        if (aux == null) {
            return null;
        }

        if (data < aux.getValue()) {
            aux.setLeftNode(daleteNode(aux.getLeftNode(), data));
        } else if (data > aux.getValue()) {
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
            Node successor = findMinimum(aux.getRightNode());
            aux.setValue(successor.getValue());
            aux.setRightNode(daleteNode(aux.getRightNode(), successor.getValue()));
        }
        return aux;
    }

    private Node findMinimum (Node node) {
        while (node.getLeftNode() != null) {
            node = node.getLeftNode();
        }
        return node;
    }
    public Node smallestNode(){
        if (root == null){
            return null;
        }
        Node position = root;
        while (position.getLeftNode() != null){
            position = position.getLeftNode();
        }
        return position;
    }
    public Node largestNode(){
        if (root == null){
            return null;
        }
        Node position = root;
        while (position.getRightNode() != null){
            position = position.getRightNode();
        }
        return position;
    }
    public void deleteTree(){
        root = null;
        peso = 0;
    }
    public Node obtenerRoot() {
        return root;
    }
}
