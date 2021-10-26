package com.sample;

import com.sample.model.numcalc;
import com.sample.nodo;

import java.util.ArrayList;
import java.util.List;

public class MathLogic {

    public List identify(numcalc type){

        List brands = new ArrayList();

        if(type.equals(numcalc.division)){
            nodo.OperacionNodo nudo = new nodo.OperacionNodo();

        }else if(type.equals(numcalc.multiplicacion)){



        }else if(type.equals(numcalc.resta)){
            brands.add("Corona");

        }else if(type.equals(numcalc.suma)){
            brands.add("No Brand Available");
        }
        return brands;
    }
}
