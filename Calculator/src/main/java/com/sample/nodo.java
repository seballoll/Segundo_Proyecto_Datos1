package com.sample;
public class nodo {

    public static class numNodo extends nodo {
        public int num;
    }

    public static class OperacionNodo extends nodo {
        public char operacion;
        public nodo calcIzquierda;
        public nodo calcDerecha;

    }
    public void create_node(){

    }
    public int calcular(nodo nodo) {
        if (nodo instanceof numNodo) {
            return ((numNodo) nodo).num;

        } else {

            OperacionNodo operacionNodo = (OperacionNodo) nodo;
            int numIzquierda = calcular(operacionNodo.calcIzquierda);
            int numDerecha = calcular(operacionNodo.calcDerecha);

            switch (operacionNodo.operacion) {
                case '+':
                    return numIzquierda + numDerecha;

                case '-':
                    return numIzquierda - numDerecha;

                case '*':
                    return numIzquierda * numDerecha;

                case '/':
                    return numIzquierda / numDerecha;

                default:
                    throw new RuntimeException("Operación inválida: " + operacionNodo.operacion);
            }
        }
    }
}
