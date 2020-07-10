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
        final int DIA_INI = 0;
        final int DIA_FIN = 7;
        final int AFORO_MIN = 0;
        final int AFORO_MAX = 1234;
        //Constantes para el switch de días de la semana
        final String NOMBRE_DIA1 = "Lunes";
        final String NOMBRE_DIA2 = "Martes";
        final String NOMBRE_DIA3 = "Miércoles";
        final String NOMBRE_DIA4 = "Jueves";
        final String NOMBRE_DIA5 = "Viernes";
        final String NOMBRE_DIA6 = "Sábado";
        final String NOMBRE_DIA7 = "Domingo";
        
        //Variable random
        int aforo;

        //Variable para el switch del día de la semana
        String nombreAct = "Desconocido";
        String nombreMin = "Desconocido";
        String nombreMax = "Desconocido";

        //Asignamos valores para que saque los días de más y menos aforo
        int diaMax = 0;
        int diaMin = 0;

        //Igual que diaMaxor y diaMinor pero con el num de aforo
        int aforoMax = 0;
        int aforoMin = 0;

        //Valores para sacar la media de la semana.
        int aforoAcum = 0;
        double aforoMedio;
        double porcenAfor;
        double porcenAforMax;
        double porcenAforMin;
        
        //muestraBanner();  
        System.out.printf("CINES DEL CENTRO COMERCIAL XeKeBó – CONTROL DE AFORO%n");
        System.out.printf("====================================================%n");
        
        //Bucle principal que muestra los valores aleatorios del cine
        for (int diaAct = DIA_INI; diaAct < DIA_FIN; diaAct++) {
            aforo = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
            aforoAcum += aforo;
            //Hacemos switch para cambiar el valor del día
            switch (diaAct + 1) {
                case 1:
                    nombreAct = NOMBRE_DIA1;
                    break;
                case 2:
                    nombreAct = NOMBRE_DIA2;
                    break;
                case 3:
                    nombreAct = NOMBRE_DIA3;
                    break;
                case 4:
                    nombreAct = NOMBRE_DIA4;
                    break;
                case 5:
                    nombreAct = NOMBRE_DIA5;
                    break;
                case 6:
                    nombreAct = NOMBRE_DIA6;
                    break;
                case 7:
                    nombreAct = NOMBRE_DIA7;
                    break;
            }
            //Salida aleatoria del aforo semanal
            System.out.printf("%-9s - Aforo ....: %4d personas %n", nombreAct, aforo);

            //Comparamos para ver qué valor es el mayor y el menor
            // Evaluación MENOR
            if (diaAct == DIA_INI) {
                diaMin = diaAct;
                aforoMin = aforo;
            } else if (aforo < aforoMin) {
                aforoMin = aforo;
                diaMin = diaAct;
            }

            // Evaluación MAYOR
            if (diaAct == DIA_INI) {
                diaMax = diaAct;
                aforoMax = aforo;
            } else if (aforo > aforoMax) {
                aforoMax = aforo;
                diaMax = diaAct;
            }
        }

        //Hacemos switch para cambiar el valor del día menor
        switch (diaMin + 1) {
            case 1:
                nombreMin = NOMBRE_DIA1;
                break;
            case 2:
                nombreMin = NOMBRE_DIA2;
                break;
            case 3:
                nombreMin = NOMBRE_DIA3;
                break;
            case 4:
                nombreMin = NOMBRE_DIA4;
                break;
            case 5:
                nombreMin = NOMBRE_DIA5;
                break;
            case 6:
                nombreMin = NOMBRE_DIA6;
                break;
            case 7:
                nombreMin = NOMBRE_DIA7;
        }

        //Hacemos switch para cambiar el valor del día mayor
        switch (diaMax + 1) {
            case 1:
                nombreMax = NOMBRE_DIA1;
                break;
            case 2:
                nombreMax = NOMBRE_DIA2;
                break;
            case 3:
                nombreMax = NOMBRE_DIA3;
                break;
            case 4:
                nombreMax = NOMBRE_DIA4;
                break;
            case 5:
                nombreMax = NOMBRE_DIA5;
                break;
            case 6:
                nombreMax = NOMBRE_DIA6;
                break;
            case 7:
                nombreMax = NOMBRE_DIA7;
        }
        
        //Hacemos las operaciones.
        aforoMedio = aforoAcum / DIA_FIN;
        porcenAfor = aforoMedio * 100 / AFORO_MAX;
        porcenAforMax = (double) aforoMax * 100 / AFORO_MAX;
        porcenAforMin = (double) aforoMin * 100 / AFORO_MAX;
        
        //Salida
        System.out.println("---");
        System.out.printf("Aforo semanal ........: %d personas %n", aforoAcum);
        System.out.printf("Aforo medio diario ...: %4.0f personas (%5.2f%%) %n",
                aforoMedio, porcenAfor);
        System.out.println("---");
        System.out.printf("Día de máximo aforo ..: %4d personas (%5.2f%%) - %s%n",
                aforoMax, porcenAforMax, nombreMax);
        System.out.printf("Día de mínimo aforo ..: %4d personas (%5.2f%%) - %s%n",
                aforoMin, porcenAforMin, nombreMin);
    }

}
