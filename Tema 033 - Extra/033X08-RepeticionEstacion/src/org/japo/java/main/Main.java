/* 
 * Copyright 2019 mon-mode - 0mon.mode@gmail.com
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
package org.japo.java.main;

import java.util.Random;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Declaramos constantes y variables
        final int DIA_INI = 1;
        final int DIA_FIN = 31;
        final int TEMP_MIN = 15;
        final int TEMP_MAX = 40;

        //Variable random
        int tempM = 0;
        int tempm = 0;

        //Asignamos valores para que saque los días de más y menos aforo
        int diaMax = 0;
        int diaMin = 0;

        //Igual que diaMaxor y diaMinor pero con el num de aforo
        int tempMax = 0;
        int tempMin = 0;

        //Valores para sacar la media de la semana.
        int tempAcumM = 0;
        int tempAcumm = 0;
        int tempMediaM;
        int tempMediam;
        
        //boolean de control si la dif de temperatura no es correcta
        boolean difTemp;

        //muestraBanner();  
        System.out.printf("BALANCE DE TEMPERATURAS MES DE AGOSTO 2020 %n");
        System.out.printf("==========================================%n");

        //Bucle principal que muestra los valores aleatorios del cine
        for (int diaAct = DIA_INI; diaAct <= DIA_FIN; diaAct++) {
            //Hacemos condición que se repita si la máx es menor que la mínima.
            do {
                tempM = RND.nextInt(TEMP_MAX - TEMP_MIN + 1) + TEMP_MIN;
                tempm = RND.nextInt(TEMP_MAX - TEMP_MIN + 1) + TEMP_MIN;
                difTemp = tempM > tempm;
            } while (!difTemp);
            
            //Acumulador de temperaturas
            tempAcumM += tempM;
            tempAcumm += tempm;

            //Salida de las temperaturas
            System.out.printf("Día %-2s - Temp MÁXIMA ...: %2d"
                    + " | MÍNIMA ...: %4d %n", diaAct, tempM, tempm);
            
            //Comparamos para ver qué valor es el mayor y el menor
            // Evaluación MENOR
            if (diaAct == DIA_INI) {
                diaMin = diaAct;
                tempMin = tempm;
            } else if (tempm < tempMin) {
                tempMin = tempm;
                diaMin = diaAct;
            }

            // Evaluación MAYOR
            if (diaAct == DIA_INI) {
                diaMax = diaAct;
                tempMax = tempM;
            } else if (tempM > tempMax) {
                tempMax = tempM;
                diaMax = diaAct;
            }
        }
        
//        TEST; TEST, TEST...        
//        System.out.println(tempAcumM);
//        System.out.println(tempAcumm);

        //Hacemos las operaciones.
        tempMediaM = tempAcumM / DIA_FIN;
        tempMediam = tempAcumm / DIA_FIN;

        //Salida
        System.out.println("---");
        System.out.println("INT MEDIA M: " + tempMediaM);
        System.out.println("INT MEDIA m: " + tempMediam);
        
//SALIDA DEL DÍA MÁXIMO Y MÍNIMO, ESTÁ MAL!!!.....................................
        System.out.println("---");
        System.out.printf("Día de máxima temperatura ..: %2d%n", diaMax);
        System.out.printf("Día de mínima temperatura ..: %2d%n", diaMin);

    }

}
