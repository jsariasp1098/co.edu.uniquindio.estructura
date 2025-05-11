package org.example;

import org.example.abrolBinario.BinaryTree;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TreeInterface treeInterface = new TreeInterface();

        frame.setContentPane(treeInterface.getTreeInterface());
        frame.setSize(800, 600);
        frame.setVisible(true);


    }
}