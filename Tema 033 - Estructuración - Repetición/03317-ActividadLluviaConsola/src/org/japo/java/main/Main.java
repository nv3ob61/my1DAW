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
        //Constantes de max/min días y lluvia
        final int DIA_INI = 0;
        final int DIA_FIN = 7;
        final int LLU_MIN = 0;
        final int LLU_MAX = 500;

        //Constantes para el switch de días de la semana
        final String NOMBRE_DIA1 = "lunes";
        final String NOMBRE_DIA2 = "martes";
        final String NOMBRE_DIA3 = "miércoles";
        final String NOMBRE_DIA4 = "jueves";
        final String NOMBRE_DIA5 = "viernes";
        final String NOMBRE_DIA6 = "sábado";
        final String NOMBRE_DIA7 = "domingo";

        //Variables dia y la que genera el RND lluvia.
        int lluviaAct;

        //Variable para el switch del día de la semana
        String nombreAct = "Desconocido";
        String nombreMen = "Desconocido";
        String nombreMay = "Desconocido";

        //Asignamos valores para que saque los días de más y menos lluvia
        int diaMay = 0;
        int diaMen = 0;

        //Igual que diaMayor y diaMenor pero con la lluvia.
        int lluviaMay = 0;
        int lluviaMen = 0;

        //Valores para sacar la media de la semana.
        int lluviaAcu = 0;
        double lluviaMed;
        //muestraBanner();  
        System.out.printf("\t..PROGRAMA ACTIVIDAD LLUVIA..%n%n");

        //Bucle for para toda la semana
        for (int diaAct = DIA_INI; diaAct < DIA_FIN; diaAct++) {
            //Random que genera el valor de la lluvia diaria.
            lluviaAct = RND.nextInt(LLU_MAX - LLU_MIN + 1)
                    + LLU_MIN;

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

            //Mensaje de salida con el día y lo que ha llovido
            System.out.printf("\tEl %s han caido %03d L/m^2 %n",
                    nombreAct, lluviaAct);

            //Sumatorio de las lluvias introducidas
            lluviaAcu += lluviaAct;

            //Comparamos para ver qué valor es el mayor y el menor
            //también para los días
            // Evaluación MENOR
            if (diaAct == DIA_INI) {
                diaMen = diaAct;
                lluviaMen = lluviaAct;
            } else if (lluviaAct < lluviaMen) {
                lluviaMen = lluviaAct;
                diaMen = diaAct;
            }

            // Evaluación MAYOR
            if (diaAct == DIA_INI) {
                diaMay = diaAct;
                lluviaMay = lluviaAct;
            } else if (lluviaAct > lluviaMay) {
                lluviaMay = lluviaAct;
                diaMay = diaAct;
            }
        }

        //Hacemos switch para cambiar el valor del día menor
        switch (diaMen + 1) {
            case 1:
                nombreMen = NOMBRE_DIA1;
                break;
            case 2:
                nombreMen = NOMBRE_DIA2;
                break;
            case 3:
                nombreMen = NOMBRE_DIA3;
                break;
            case 4:
                nombreMen = NOMBRE_DIA4;
                break;
            case 5:
                nombreMen = NOMBRE_DIA5;
                break;
            case 6:
                nombreMen = NOMBRE_DIA6;
                break;
            case 7:
                nombreMen = NOMBRE_DIA7;
        }
        
        //Hacemos switch para cambiar el valor del día mayor
        switch (diaMay + 1) {
            case 1:
                nombreMay = NOMBRE_DIA1;
                break;
            case 2:
                nombreMay = NOMBRE_DIA2;
                break;
            case 3:
                nombreMay = NOMBRE_DIA3;
                break;
            case 4:
                nombreMay = NOMBRE_DIA4;
                break;
            case 5:
                nombreMay = NOMBRE_DIA5;
                break;
            case 6:
                nombreMay = NOMBRE_DIA6;
                break;
            case 7:
                nombreMay = NOMBRE_DIA7;
        }

        //Operamos la media
        lluviaMed = lluviaAcu / DIA_FIN;

        //Salida de la media con dos decimales
        System.out.printf("%nLa lluvia media es de ........................: %.2f"
                + " L/m^2 %n", lluviaMed);

        //Salida de los valores menor y mayor.
        System.out.printf("El %s ha sido el día que menos ha llovido con: %03d "
                + "L/m^2 %n", nombreMen, lluviaMen);
        System.out.printf("El %s ha sido el día que más ha llovido con: %03d "
                + "L/m^2 %n%n", nombreMay, lluviaMay);
    }
}
