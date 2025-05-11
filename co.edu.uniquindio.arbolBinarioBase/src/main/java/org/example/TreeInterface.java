package org.example;

import org.example.abrolBinario.BinaryTree;
import org.example.abrolBinario.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TreeInterface {
    private JTextField addToData;
    private JButton delete;
    private JButton dataExists;
    private JButton getWeight;
    private JButton add;
    private JButton getLevel;
    private JButton countLeaves;
    private JButton getLowest;
    private JButton getLargestNode;
    private JButton getSmallestNode;
    private JButton deleteTree;
    private JButton inOrder;
    private JButton preOrder;
    private JButton postOrder;
    private JButton width;
    private JButton getHeight;
    private JPanel treeInterface;
    private JPanel darwingPanel;
    private JButton isEmpty;
    private TreePanel treePanel;

    BinaryTree binaryTree = new BinaryTree();

    public TreeInterface() {
        treePanel = new TreePanel(binaryTree);
        darwingPanel.setLayout(new BorderLayout()); // o null si quieres layout absoluto
        darwingPanel.add(treePanel, BorderLayout.CENTER);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = addToData.getText();
                binaryTree.insert(parseInt(data));
                treePanel.repaint();
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = addToData.getText();
                binaryTree.deleteData(parseInt(data));
                treePanel.repaint();
                JOptionPane.showMessageDialog(darwingPanel, "Nodo"+ data +" eliminado");

            }
        });

        deleteTree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryTree.deleteTree();
                JOptionPane.showMessageDialog(darwingPanel, "Arbol Eliminadp");
                treePanel.repaint();
            }
        });
        dataExists.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = addToData.getText();
                boolean found = binaryTree.search(parseInt(data));
                if(found){
                    JOptionPane.showMessageDialog(darwingPanel, "Nodo"+ data +" encontrado");
                }else{
                    JOptionPane.showMessageDialog(darwingPanel, "No se encontro el nodo");
                }
            }
        });
        getWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int weight = binaryTree.weight();
                JOptionPane.showMessageDialog(darwingPanel, "El peso del arbol es de: "+ weight );
            }
        });
        getHeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int height = binaryTree.height();
                JOptionPane.showMessageDialog(darwingPanel, "La altura del arbol es de: "+ height );
            }
        });
        getLevel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int level = binaryTree.level();
                JOptionPane.showMessageDialog(darwingPanel, "El arbol tiene " +  level +" Niveles");
            }
        });
        countLeaves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int leaves = binaryTree.countLeaves();
                JOptionPane.showMessageDialog(darwingPanel, "El arbol tiene " +  leaves +" hojas");
            }
        });
        getLowest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lowest = binaryTree.lowest();
                JOptionPane.showMessageDialog(darwingPanel, "EL nodo menor del Arbol es: " +  lowest);
            }
        });
        getLargestNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node largest = binaryTree.largestNode();
                JOptionPane.showMessageDialog(darwingPanel, "EL nodo mayor del Arbol es: " +  largest.getValue());
            }
        });
        getSmallestNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Node smallest = binaryTree.smallestNode();
                JOptionPane.showMessageDialog(darwingPanel, "EL nodo menor del Arbol es: " +  smallest.getValue());
            }
        });
        width.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> width = binaryTree.printAmplitude();
                JOptionPane.showMessageDialog(darwingPanel, "Recorrido en amplitud: " +  width);
            }
        });
        inOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> inOrder = binaryTree.inorder();
                JOptionPane.showMessageDialog(darwingPanel, "Recorrido inOrden: " +  inOrder);
            }
        });
        preOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> preOrder = binaryTree.preOrder();
                JOptionPane.showMessageDialog(darwingPanel, "Recorrido preOrden: " +  preOrder);
            }
        });
        postOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Integer> postOrder = binaryTree.postOrder();
                JOptionPane.showMessageDialog(darwingPanel, "Recorrido postOrden: " +  postOrder);
            }
        });
        isEmpty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isEmpty = binaryTree.isEmpty();
                if(isEmpty){
                    JOptionPane.showMessageDialog(darwingPanel, "El arbol esta vacio");
                }else {
                    JOptionPane.showMessageDialog(darwingPanel, "El arbol no esta vacio");
                }
            }
        });
    }

    public JPanel getTreeInterface() {
        return treeInterface;
    }

    public void setTreeInterface(JPanel treeInterface) {
        this.treeInterface = treeInterface;
    }
}
