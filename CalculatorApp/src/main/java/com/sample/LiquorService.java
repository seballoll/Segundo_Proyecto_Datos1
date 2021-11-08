package com.sample;

import com.sample.model.LiquorType;

import java.util.*;

/**
 * Created by kasun on 5/24/17.
 */
public class LiquorService {

    public String printoperacion(String operacion){
        System.out.println("la operacion es:");
        System.out.println(operacion);

        return operacion;
    }
    public String doOperation(String operacion){
        char[] charsFromString = operacion.toCharArray();
        //for(){

        //}
        int[] numbers = new int[2];
        numbers[0] = (Integer.parseInt(String.valueOf(charsFromString[0])));
        numbers[1]=(Integer.parseInt(String.valueOf(charsFromString[2])));
        int first = numbers[0] + numbers[1];
        operacion = Integer.toString(first) ;

        return operacion;
    }

    public List getAvailableBrands(LiquorType type) {

        List brands = new ArrayList();

        if (type.equals(LiquorType.WINE)) {
            brands.add("Adrianna Vineyard");
            brands.add(("J. P. Chenet"));

        } else if (type.equals(LiquorType.WHISKY)) {
            brands.add("Glenfiddich");
            brands.add("Johnnie Walker");

        } else if (type.equals(LiquorType.BEER)) {
            brands.add("Corona");

        } else {
            brands.add("No Brand Available");
        }
        return brands;
    }
}