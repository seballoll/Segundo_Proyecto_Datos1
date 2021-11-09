package com.sample;

import java.util.Stack;

public class MathLogic {


    public boolean operador(String operator) {
        return (operator.equals("+")  ||operator.equals("/")
                || operator.equals("-") || operator.equals("+")
                || operator.equals("*") ||
                operator.equals("%"));
    }

    public nodo constructorTree(String postorderExpression) {

        String TempNum ="";

        Stack<nodo> pila = new Stack<>();

        String caracterEvaluado;

        for (int i=0; i<postorderExpression.length();i++) {

            caracterEvaluado = Character.toString(postorderExpression.charAt(i));

            if (caracterEvaluado.equals(" ")) {
                pila.add(new nodo(TempNum));
                TempNum="";
                continue;
            }

            if (operador(caracterEvaluado)) {

                nodo right = pila.pop();
                nodo left = pila.pop();

                nodo node = new nodo(caracterEvaluado, left, right);

                pila.add(node);

            }
            else if (caracterEvaluado.equals(" ")) {

                pila.add(new nodo(TempNum));
                TempNum="";
                continue;
            }

            else {
                TempNum = TempNum + caracterEvaluado;
            }
        }

        return pila.peek();
    }

    public double Resultado(nodo root) {
        double respuesta = 0;

        if (root.left==null && root.right==null){
            return Double.parseDouble(root.data);
        }

        switch (root.data){

            case "+":
                respuesta = Resultado(root.left) + Resultado(root.right);
                break;
            case "-":
                respuesta = Resultado(root.left) - Resultado(root.right);
                break;
            case "*":
                respuesta = Resultado(root.left) * Resultado(root.right);
                break;
            case "/":
                respuesta = Resultado(root.left) / Resultado(root.right);
                break;
            case "%":
                respuesta = Resultado(root.left) % Resultado(root.right);
                break;
        }
        return respuesta;
    }
}