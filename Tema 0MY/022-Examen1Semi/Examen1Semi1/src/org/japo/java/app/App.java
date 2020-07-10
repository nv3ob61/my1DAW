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

import java.util.Locale;
import java.util.Scanner;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 *
 * @author mon_mo
 */
public final class App {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String PACO_LONG = "----------------------------";
    public static final String PACO = "---";
    public static final String MSG_USR = "Introduzca su nombre: ";
    public static final String MSG_EDAD = "Introduzca su edad: ";
    public static final String MSG_WAGE = "Introduzca su sueldo: ";
    public static final String MSG_ERR = "ERROR: Número introducido incorrecto";

    public final void launchApp() {

        boolean isOk = false;
        String nombre;
        String nombreEdadMen = "";
        String nombreEdadMay = "";
        int edad = 0;
        int edadMay = 0;
        int edadMen = 0;
        int contadorPers = 0;
        int menosMileurista = 0;
        int acumulaEdad = 0;
        double sueldo = 0;
        double acumulaSueldo = 0;
        double mediaSueldo;
        double mediaEdad;
        double sueldoMayorEdad = 0;
        double sueldoMenorEdad = 0;

        System.out.println(PACO_LONG);
        System.out.println("  MENÚ PRINCIPAL  ");
        while (!isOk) {
            System.out.println(PACO_LONG);
            nombre = UtilesEntrada.leerTexto(MSG_USR);
            if (!nombre.equals("FIN")) {
                edad = UtilesEntrada.leerEntero(MSG_EDAD, MSG_ERR);
                sueldo = UtilesEntrada.leerReal(MSG_WAGE, MSG_ERR);
                contadorPers++;
                acumulaSueldo += sueldo;
                acumulaEdad += edad;
                //control para contar las personas que cobran menos de mil euros.
                if (sueldo < 1000) {
                    menosMileurista++;
                }
            } else {
                isOk = true;
                System.out.println("GRacias por utilizar el programa");
            }

            // Evaluación MENOR
            if (contadorPers == 1) {
                edadMen = edad;
                nombreEdadMen = nombre;
                sueldoMenorEdad = sueldo;
            } else if (edad < edadMen) {
                nombreEdadMen = nombre;
                edadMen = edad;
                sueldoMenorEdad = sueldo;
            }

            // Evaluación MAYOR
            if (contadorPers == 1) {
                edadMay = edad;
                nombreEdadMay = nombre;
                sueldoMayorEdad = sueldo;
            } else if (edad > edadMay) {
                nombreEdadMay = nombre;
                edadMay = edad;
                sueldoMayorEdad = sueldo;
            }

        }
        mediaSueldo = acumulaSueldo / contadorPers;
        mediaEdad = acumulaEdad / contadorPers;

        System.out.println("SALIDA FINAL");
        System.out.println(PACO_LONG);
        System.out.printf("1.- El nombre de la persona de más edad es %s y cobra "
                + "%.2f €%n%n", nombreEdadMay, sueldoMayorEdad);
        System.out.printf("2.- El nombre de la persona de menor edad es %s y cobra "
                + "%.2f €%n%n", nombreEdadMen, sueldoMenorEdad);
        System.out.printf("3.- El sueldo medio es de: %.2f € y la edad media de: "
                + "%.0f años. %n%n", mediaSueldo, mediaEdad);
        System.out.printf("4.- Hay %d personas que cobran menos de 1000€%n%n", menosMileurista);
        System.out.printf("5.- La edad de la persona que más cobra es de %d años.%n", edadMay);
    }
}
