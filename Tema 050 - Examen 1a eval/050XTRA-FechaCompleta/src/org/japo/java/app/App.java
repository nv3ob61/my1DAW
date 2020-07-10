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
package org.japo.java.app;

import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final String PACO = "---";
    public static final String MSG_D = "Introduzca el día: ";
    public static final String MSG_M = "Introduzca el mes: ";
    public static final String MSG_Y = "Introduzca el año: ";
    public static final String MSG_ERR = "ERROR: Dato introducido incorrecto.";

    public final void launchApp() {
        int year;
        int month;
        int day = 0;
        //variable del switch que elige el máximo de días que tiene el mes.
        int max_month = 0;

        //PROGRAMA PRINCIPAL. Solo se ejecuta una vez. TODO.- Hay que cambiar la 
        //entrada manual de datos por la fecha del sistema.
        muestraBanner();
        //Entrada del año, limitada de 1000 a 3000, suficiente, no?
        do {
            year = UtilesEntrada.leerEntero(MSG_Y, MSG_ERR);
            System.out.println(PACO);
        } while (year < 1000 && year > 3000);
        //Entrada del mes
        do {
            month = UtilesEntrada.leerEntero(MSG_M, MSG_ERR);
        } while (month > 12 || month < 1);

        //Switch para delimitar el nº de días, lo ponemos antes que el día porque
        //este filtro determina el máximo de días que tiene el mes, así como
        //validar si el año es bisiesto o no.
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                //Todos estos casos son meses con 31 días
                System.out.println(PACO);
                System.out.printf("Meses con 31 días máx.%n");
                max_month = 31;
                break;
            //Caso para febrero, comprueba si el año es bisiesto llamando
            // a isLeap(year);  Si es bisiesto max_month = 29, else ... = 28;
            case 2:
                System.out.println(PACO);
                System.out.printf("Febrero, es bisiesto o no? --> ");
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
                System.out.println(PACO);
                System.out.println("Meses con 30 días test");
                max_month = 30;
                break;
            default:
                break;
        }

        //Validamos el día
        do {
            day = UtilesEntrada.leerEntero(MSG_D, MSG_ERR);
        } while (day > max_month || day < 1);
        System.out.println("------------------------------------");
        System.out.printf("%s - %d de %s de %d %n",
                obtenerNombreDia(day, month, year), day, obtenerNombreMes(month), year);
    }

    private String obtenerNombreDia(int day, int month, int year) {
        String stringDia = " ";
        //int para sumar 1 al módulo para sacar el día. NO ES BOOLEAN!
        int isBisiesto;
        //módulo para sacar el día.. Empieza cogiendo un valor si el año es Leap
        // o no.
        if (isLeap(year) == true) {
            isBisiesto = 1;
        } else {
            isBisiesto = 0;
        }

        //cálculos para el módulo del día de la semana.
        moduloMes(month, isBisiesto);
        //Definimos a lo guarro las variables aquí. MODIFICAR.
        int a = (year - 1) % 7;
        int d = day % 7;
        int dm = (((year - 1) / 4) - (3 * ((year - 1) / 100 + 1) / 4)) % 7;
        int resultado = (a + d + moduloMes(month, isBisiesto) + dm) % 7;
        //no comment here.
        switch (resultado) {
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
        }

        return stringDia;
    }

    private String obtenerNombreMes(int mes) {
        //Array de strings para cambiar por en la salida final
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo",
            "junio", "julio", "agosto", "septiembre", "octubre", "noviembre",
            "diciembre"};

        //está claro, no?
        return meses[mes - 1];
    }

    private void muestraBanner() {
        System.out.println("*************************************");
        System.out.println(" VALIDA UNA FECHA MUESTRA QUÉ DÍA FUE");
        System.out.println("*************************************");
        System.out.println();
    }

    public static boolean isLeap(int year) {
        //Método para esBiesto...

        boolean leap = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));

        return leap;
    }

    public static int moduloMes(int mes, int bisiesto) {
        //Método que pasando el nº de mes y si es bisiesto calcula el módulo para
        // determinar el día de la semana de la fecha a validar.
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
