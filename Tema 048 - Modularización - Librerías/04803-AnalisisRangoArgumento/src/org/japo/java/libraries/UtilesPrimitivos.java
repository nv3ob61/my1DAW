/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author mon_mo
 */
public class UtilesPrimitivos {

    public static final int OP_SUM = 0; // Suma
    public static final int OP_RES = 1; // Resta
    public static final int OP_MUL = 2; // Producto
    public static final int OP_DIV = 3; // Cociente
    public static final int OP_MOD = 4; // Resto
    public static final int OP_MED = 5; // Media
    public static final int OP_MAY = 6; // Mayor
    public static final int OP_MEN = 7; // Menor
    public static final int RANGE_IN = 0; // Dentro de Rango
    public static final int RANGE_BELOW = 1; // Debajo de Rango
    public static final int RANGE_ABOVE = 2; // Encima de Rango

    public static final int RND_NUM;
    //Dentro de este static generamos los valores random para NUM

    static {
        final Random RND = new Random();
        //Valores arbitrarios para el random
        final int NUM_MIN = -3;
        final int NUM_MAX = 14;

        RND_NUM = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
    }
    public static final int MIN = 0;
    public static final int MAX = 10;

    public final static double operar(double n1, double n2, int op) {
        //variable que generará el resultado
        double result = 0;

        //Switch para la operación.
        switch (op) {
            case OP_SUM:
                result = n1 + n2;
                break;
            case OP_RES:
                result = n1 - n2;
                break;
            case OP_MUL:
                result = n1 * n2;
                break;
            case OP_DIV:
                if (n2 == 0) {
                    //No hace nada para posteriormente mostrar la OP del error
                } else {
                    result = n1 / n2;
                }
                break;
            case OP_MOD:
                result = n1 % n2;
                break;
            case OP_MED:
                result = (n1 + n2) / 2;
                break;
            case OP_MAY:
                result = n1 > n2 ? n1 : n2;
                break;
            case OP_MEN:
                result = n1 < n2 ? n1 : n2;
        }
        //envia resultado de la operación
        return result;
    }
    
        public final static int analizarRango(int num, int max, int min) {
        int valor = 0;

        if (num > max) {
            valor = 2;
        } else if (num < min) {
            valor = 1;
        }
        return valor;
    }
}
