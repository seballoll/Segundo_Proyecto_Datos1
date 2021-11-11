package com.sample.arbol;
import java.util.*;

public class arbolcalc {
    private class nodo {
        private char contenido;
        private nodo left;
        private nodo right;

        private boolean isLeaf() {
            return (left == null && right == null);
        }
    }

    private nodo root;
    private Scanner in;

    public arbolcalc() {
        root = null;
        in = new Scanner(System.in);
    }

    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);
        }
    }

    private static void inorderPrintTree(nodo root) {
        if (root.isLeaf())
            System.out.print(root.contenido);
        else {

            System.out.print("(");
            inorderPrintTree(root.left);
            System.out.print(" " + root.contenido + " ");
            inorderPrintTree(root.right);
            System.out.print(")");
        }
    }

    public void preorderPrint() {
        if (root != null) {
            preorderPrintTree(root);
        }
    }

    private static void preorderPrintTree(nodo root) {
        if (root.isLeaf()) {
            System.out.print(root.contenido);
        } else {

            switch (root.contenido) {
                case '+':
                    System.out.print("sumar");
                    break;
                case '-':
                    System.out.print("restar");
                    break;
                case '*':
                    System.out.print("multiplicar");
                    break;
                case '/':
                    System.out.print("dividir");
                    break;
                case '%':
                    System.out.print("porcentaje");
                    break;
            }

            System.out.print("(");
            preorderPrintTree(root.left);
            System.out.print(", ");
            preorderPrintTree(root.right);
            System.out.print(")");
        }
    }

    public void postorderPrint() {
        if (root != null) {
            postorderPrintTree(root, 0);
        }
    }

    private static void postorderPrintTree(nodo root, int margin) {
        if (root.isLeaf()) {
            printMargin(margin);
            System.out.print(root.contenido + "  ");
        } else {
            postorderPrintTree(root.left, margin + 1);
            postorderPrintTree(root.right, margin + 1);

            printMargin(margin);
            switch (root.contenido) {
                case '+':
                    System.out.print("añade encima de");
                    break;
                case '-':
                    System.out.print("suma encima de");
                    break;
                case '*':
                    System.out.print("multiplica encima de");
                    break;
                case '/':
                    System.out.print("divide encima de");
                    break;
                case '%':
                    System.out.print("saca el porcentaje de sobre");
                    break;
            }
        }
    }

    private static void printMargin(int margin) {
        System.out.println();
        for (int i = 1; i <= margin; i++) {
            System.out.print("    ");
        }
    }

    public void read() {
        root = readTree();
    }

    private nodo readTree() {
        nodo n = new nodo();

        char ch = in.findInLine("(\\S)").charAt(0);
        if ((ch >= 'a') && (ch <='z')) {

            n.contenido = ch;
            n.left = null;
            n.right = null;
        } else if (ch == '(') {

            n.left = readTree();
            n.contenido = in.findInLine("(\\S)").charAt(0);
            n.right = readTree();
            ch = in.findInLine("(\\S)").charAt(0);
            if (ch != ')') {
                System.out.print("esperado ) - } asumido...");
            }
        } else {
            System.out.print("esperado ( - error");
            System.exit(1);
        }

        return n;
    }

    public static void main(String[] args) {

        System.out.println("\nescriba la expresión " +
                "usando +,-,*,/, %");

        arbolcalc tree = new arbolcalc();
        tree.read();

        System.out.println("\n* INFIX NOTATION:");
        tree.inorderPrint();
        System.out.print("\n\n* PREFIX NOTATION:\n");
        tree.preorderPrint();
        System.out.print("\n\n* POSTFIX NOTATION:");
        tree.postorderPrint();
        System.out.println();
    }
}