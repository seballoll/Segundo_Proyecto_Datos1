package com.sample.arbol;

public class nodo {
    String data;
    nodo left,right;

    public nodo(String data) {
        this.data = data;
        this.left= null;
        this.right= null;
    }

    public nodo(String data, nodo left, nodo right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}