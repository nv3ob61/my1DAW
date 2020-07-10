/*
 * Copyright 2019 mon_mo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author mon_mo
 */
public class UtilesPrimitivos {
    
    /* **********************************************************************
                                    Menú
    ********************************************************************** */ 
    public static final int OP_SUM = 0; // Suma
    public static final int OP_RES = 1; // Resta
    public static final int OP_MUL = 2; // Producto
    public static final int OP_DIV = 3; // Cociente
    public static final int OP_MOD = 4; // Resto
    public static final int OP_MED = 5; // Media
    public static final int OP_MAY = 6; // Mayor
    public static final int OP_MEN = 7; // Menor
    
    /* **********************************************************************
                                    RND y límites
    ********************************************************************** */ 
    public static final int RANGE_IN = 0; // Dentro de Rango
    public static final int RANGE_BELOW = 1; // Debajo de Rango
    public static final int RANGE_ABOVE = 2; // Encima de Rango

    //Dentro de este static generamos los valores random para NUM
    public static final int RND_NUM;

    static {
        final Random RND = new Random();
        //Valores arbitrarios para el random
        final int NUM_MIN = -3;
        final int NUM_MAX = 14;

        RND_NUM = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
    }

    //Definidos un máx y un mínimo por defecto
    public static final int MIN = 0;
    public static final int MAX = 10;  
    
     /* **********************************************************************
                                    DNI
    ********************************************************************** */   
    
    //String letras del módulo % 23;
    public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";  
    
   /* **********************************************************************
                            OTROS MENSAJES
    ********************************************************************** */    

    //Errores y Strings de salida. Algunos no deben estar aquí, modificar.
    public static final String MSG_DATOS = "ERROR: Datos introducidos erróneos.";
    public static final String MSG_DIGITOS = "ERROR: Núm de dígitos incorrecto.";
    public static final String MSG_OK = "Correcto";
    public static final String MSG_NO = "Incorrecto";
    public static final String MSG_INTRO = "VALIDACIÓN DE DNI";
    public static final String MSG_OUT = "DNI ......: ";
    public static final String VALIDEZ = "Validez ..: ";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------";

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

    public static final char calcularDNI(int num) {
        return LETRAS.charAt(num % 23);
    }

    public static final boolean validarDNI(int num, char ctr) {
        return ctr == calcularDNI(num);
    }
}
