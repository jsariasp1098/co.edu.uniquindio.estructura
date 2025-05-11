package org.example;

import org.example.abrolBinario.BinaryTree;
import org.example.abrolBinario.Node;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private BinaryTree binaryTree;

    public TreePanel(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (binaryTree.getRoot() != null) {
            dibujar(g, binaryTree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void dibujar(Graphics g, Node nodo, int x, int y, int separacion) {
        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(nodo.getValue()), x - 5, y + 5);

        g.setColor(Color.BLACK);
        if (nodo.getLeftNode() != null) {
            int xIzq = x - separacion;
            int ySig = y + 50;
            g.drawLine(x, y, xIzq, ySig);
            dibujar(g, nodo.getLeftNode(), xIzq, ySig, separacion / 2);
        }
        if (nodo.getRightNode() != null) {
            int xDer = x + separacion;
            int ySig = y + 50;
            g.drawLine(x, y, xDer, ySig);
            dibujar(g, nodo.getRightNode(), xDer, ySig, separacion / 2);
        }
    }
}
