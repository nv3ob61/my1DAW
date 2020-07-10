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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author nv3ob61
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Variables
        int year;
        int month;
        int day = 0;
        int max_month = 0;

        //int para sumar 1 al módulo para sacar el día. NO ES BOOLEAN!
        int isBisiesto;

        /**
         * **********************************************************************
         * FALTA CONTROLAR PARÁMETROS DE ENTRADA....
         * /*********************************************************************
         */
        
        //Validamos año
        System.out.println("Introduzca año: ");
        year = SCN.nextInt();

        //Validamos mes
        do {
            System.out.println("Introduzca mes (1 a 12)");
            month = SCN.nextInt();
        } while (month > 12 || month < 1);

        //Switch para delimitar el nº de días
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                //Todos estos casos son meses con 31 días
                System.out.println("Meses con 31 días máx.");
                max_month = 31;
                break;
            //Caso para febrero, comprueba si el año es bisiesto llamando
            // a isLeap(year);  Si es bisiesto max_month = 29, else ... = 28;
            case 2:
                System.out.println("Febrero, es bisiesto o no?");
                System.out.println(isLeap(year));
                if (isLeap(year)) {
                    max_month = 29;
                } else {
                    max_month = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                //Todos estos casos son meses con 30 días
                System.out.println("Meses con 30 días test");
                max_month = 30;
                break;
            default:
                break;
        }

        //Validamos el día
        do {
            System.out.println("Introduce el día: ");
            day = SCN.nextInt();
        } while (day > max_month || day < 1);

        //módulo para sacar el día.. Empieza cogiendo un valor si el año es Leap
        // o no. 
        if (isLeap(year) == true) {
            isBisiesto = 1;
        } else {
            isBisiesto = 0;
        }

        //cálculos para el módulo del día de la semana.
        modulo_mes(month, isBisiesto);
        //Definimos a lo guarro las variables aquí. MODIFICAR.
        int a = (year - 1) % 7;
        int d = day % 7;
        int dm = (((year - 1) / 4) - (3 * ((year - 1) / 100 + 1) / 4)) % 7;
        int resultado = (a + d + modulo_mes(month, isBisiesto) + dm) % 7;

        //SALIDA: pasamos el resultado a un string y sout.
        String busca_dia = busca_dia(resultado);
        System.out.println(busca_dia);
    }

    //Método para esBiesto...
    public static boolean isLeap(int year) {

        boolean leap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

        return leap;
    }

    //Método que devuelve un string con el nombre del día que validamos
    public static String busca_dia(int day) {
        String stringDia = " ";

        switch (day) {
            case 1:
                stringDia = "Lunes";
                break;
            case 2:
                stringDia = "Martes";
                break;
            case 3:
                stringDia = "Miércoles";
                break;
            case 4:
                stringDia = "Jueves";
                break;
            case 5:
                stringDia = "Viernes";
                break;
            case 6:
                stringDia = "Sábado";
                break;
            case 0:
                stringDia = "Domingo";
                break;

        }
        return stringDia;
    }

    //Método que pasando el nº de mes y si es bisiesto calcula el módulo para
    // determinar el día de la semana de la fecha a validar.
    public static int modulo_mes(int mes, int bisiesto) {
        int modulo = 0;

        switch (mes) {
            case 1:
                modulo = 0;
                break;
            case 2:
                modulo = 3;
                break;
            case 3:
                if (bisiesto == 1) {
                    modulo = 4;
                } else {
                    modulo = 3;
                }
                break;
            case 4:
                if (bisiesto == 1) {
                    modulo = 0;
                } else {
                    modulo = 6;
                }
                break;
            case 5:
                if (bisiesto == 1) {
                    modulo = 2;
                } else {
                    modulo = 1;
                }
                break;
            case 6:
                if (bisiesto == 1) {
                    modulo = 5;
                } else {
                    modulo = 4;
                }
                break;
            case 7:
                if (bisiesto == 1) {
                    modulo = 0;
                } else {
                    modulo = 6;
                }
                break;
            case 8:
                if (bisiesto == 1) {
                    modulo = 3;
                } else {
                    modulo = 2;
                }
                break;
            case 9:
                if (bisiesto == 1) {
                    modulo = 6;
                } else {
                    modulo = 5;
                }
                break;
            case 10:
                if (bisiesto == 1) {
                    modulo = 0;
                } else {
                    modulo = 1;
                }
                break;
            case 11:
                if (bisiesto == 1) {
                    modulo = 4;
                } else {
                    modulo = 3;
                }
                break;
            case 12:
                if (bisiesto == 1) {
                    modulo = 6;
                } else {
                    modulo = 5;
                }
                break;
        }
        return modulo;
    }
}
