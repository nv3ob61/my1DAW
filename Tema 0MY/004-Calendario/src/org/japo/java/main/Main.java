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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {
// Instanciar Scanner

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
//Contador del programa
    public static int contadorInicio = 0;
//Clase Calendar
    public static Calendar CAL = Calendar.getInstance();

    public static void main(String[] args) {
        // TODO code application logic here!
        //Variables
        String entradaTecla;
        boolean loopInicio = true;

        try {
            //El programa pide por primera vez si se quiere empezar o no.
            do {
                if (contadorInicio == 0) {
                    System.out.printf("Would you like to start the program? ......... Y/N: ");
                } else {
                    System.out.printf("Start again? ................................. Y/N: ");
                }

                //entrada SCN Yes o No
                entradaTecla = SCN.nextLine();
                entradaTecla = entradaTecla.toLowerCase();

                switch (entradaTecla) {
                    case "y":
                        //Si es la primera vez, contadorInicio == 1;
                        contadorInicio++;
                        System.out.printf("%nProgram number.. .....................: %d%n%n", contadorInicio);
                        fechaCalendario();
                        System.out.println("END... ");
                        //Borra buffer
                        SCN.nextLine();
                        break;
                    case "n":
                        //Siempre sale aquí al ser loopInicio = false;
                        System.out.println("Thanks, see you soon!");
                        loopInicio = false;
                        break;
                    default:
                        System.out.println("Wrong Option");
                }
            } while (loopInicio == true);

        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }

    //método para introducir y validar la fecha
    public static void fechaCalendario() {
        //Variables
        int day, month, year;
        String term = null;

        //Introduce el año
        do {
            System.out.printf("Enter the year in XXXX format.....................: ");
            year = SCN.nextInt();
            //Pasa al método para ver si es bisiesto
            boolean isLeap = isLeap(year);

            if (year > 9999 || year < 0) {
                System.out.printf("The year entered is not correct.%n%n");
            }
            if (isLeap) {
                System.out.printf("Leap year.%n");
            }
        } while (year > 9999 || year < 0);
        SCN.nextLine();

        //Introduce mes
        do {
            System.out.printf("%nEnter the number of the month (range from 1 to 12): ");
            month = SCN.nextInt();
            if (month > 12 || month < 1) {
                System.out.printf("The month entered is not correct. %n");
            }
        } while (month > 12 || month < 1);

        //Introduce año
        do {
            System.out.printf("%nEnter the day range 0-31 (max)................... : ");
            day = SCN.nextInt();
            if (day > 32 || day < 1) {
                System.out.printf("The day entered is not correct.%n");
            }
            
        //Condición si el día se pasa de 31, si el año es bisiesto y día > 29
        //Si no es bisiesto y día > 28, o los meses de 30 se pasan de días.
        } while ((day > 31 || day < 1) || (isLeap(year) && month == 2 && day > 29) ||
               (!isLeap(year) && month == 2 && day > 28) ||
                ((day == 31) && (month == 4 || month == 6 || month == 9 || month == 11)));

        //Añadimos condición para las terminaciones del sout final.
        if (day == 1 || day == 11 || day == 21 || day == 31) {
            term = "st";
        } else if (day == 2 || day == 12 || day == 22) {
            term = "nd";
        } else if (day == 3 || day == 13 || day == 23) {
            term = "rd";
        } else if (day != 1 || day != 11 || day != 21 || day != 31
                || day != 2 || day != 12 || day != 22
                || day != 3 || day != 13 || day != 23) {
            term = "th";
        }

        //un sout guarro para aclarar esto...
        String paco = calculaDia(day, month - 1, year);
        System.out.println("\n--------------------------------------------------- ");
        System.out.println("\t\tDay of the week : " + paco);
        System.out.println("--------------------------------------------------- ");
        System.out.printf("\tThe date entered is %d the %d%s of %d %n", month, day, term, year);
        System.out.println("--------------------------------------------------- \n");
    }

    //Método para año bisiesto
    public static boolean isLeap(int year) {

        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        return isLeap;
    }

    //Método calcula el día de la semana con la clase Calendar.
    public static String calculaDia(int day, int month, int year) {
        //Pasamos nuestras variables del método fecha
        CAL.set(year, month, day); //año, mes, día  
        SimpleDateFormat SDF = new SimpleDateFormat("EEEE");
        String fecha = SDF.format(CAL.getTime());

        return fecha;
    }

}
