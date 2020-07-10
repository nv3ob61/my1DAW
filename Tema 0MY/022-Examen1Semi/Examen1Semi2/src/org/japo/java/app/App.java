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
    public static final String MSG_FIN = "Gracias por utilizar el programa";
    public static final String MSG_OPCION = "ERROR: Opción incorrecta.";
    public static final String MSG_ERR = "ERROR: Número introducido incorrecto";
    public static final String MSG_USR = "Elije una opción del 1 al 3. (3 para salir): ";
    public static final String MSG_DIVI = "Elige un número para mostrar sus divisores: ";
    public static final String MSG_DIVI2 = "Elige el mínimo divisor: ";
    public static final String MSG_FAM = "Introduce el nº de miembros: ";
    public final static String USR_MSG = "Miembro nº %d...: ";
    
    public final void launchApp() {

        int opcion;
        boolean sw = false;

        //Inicio del programa main
        muestraBanner();
        while (!sw) {
            muestraOpciones();
            opcion = UtilesEntrada.leerEntero(MSG_USR, MSG_ERR);
            switch (opcion) {
                case 1:
                    System.out.println(PACO);
                    System.out.println("Muestra divisores de un número");
                    System.out.println(PACO_LONG);
                    esDivisor();
                    System.out.println(PACO);
                    break;
                case 2:
                    System.out.println(PACO);
                    System.out.println("Calcula coste billetes de autobús");
                    pideBilletes();
                    System.out.println(PACO_LONG);
                    break;
                case 3:
                    System.out.println(PACO);
                    sw = salir();
                    break;
                default:
                    System.out.println(MSG_OPCION);
                    break;
            }
        }
        System.out.println(MSG_FIN);
    }

    public final void muestraBanner() {
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t Programa que hace cosas");
        System.out.printf("-----------------------------------------------------%n%n");
    }

    public final void muestraOpciones() {
        System.out.printf(".. MENÚ PRINCIPAL .. %n%n");
        System.out.printf("1: Opción 1: Divisores%n");
        System.out.printf("2: Opción 2: Billete autobús %n");
        System.out.printf("3: SALIR%n%n");
    }

    public final boolean salir() {
        boolean sw = false;
        System.out.printf("%n¿Desea realizar otro ejercicio s/n ?: ");
        char salida = SCN.next().charAt(0);

        if (salida == 'n' || salida == 'N') {
            sw = true;
        }
        return sw;
    }

    public final void esDivisor() {
        int n;
        int from;
        
        n = UtilesEntrada.leerEntero(MSG_DIVI, MSG_ERR);
        from = UtilesEntrada.leerEntero(MSG_DIVI2, MSG_ERR);
        System.out.println(PACO);
        for (int i = from; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
    
    public final void pideBilletes() {
        //primero pedimos el nº de miembros y luego las edades en un bucle for
        //con el acumulador del coste total.
        int num;
        int edad;
        double billete;
        double acumulador = 0;
        
        num = UtilesEntrada.leerEntero(MSG_FAM, MSG_ERR);
        
        for (int i = 0; i < num; i++) {
            edad = UtilesEntrada.leerEntero(String.format(USR_MSG, i+1), MSG_ERR);
            billete = 60;
            
            if (edad >= 60) {
                billete = 36.30;
            } else if (edad >= 10 && edad <= 16){
                billete = 25.00;
            } else if (edad >= 4 && edad <= 10) {
                billete = 20.00;
            } else if (edad < 4) {
                billete = 0;
            }
            
            acumulador += billete;
        }
        System.out.println(PACO_LONG);
        System.out.printf(Locale.ENGLISH,"%nEl total a pagar es de %.2f €%n", 
                acumulador);       
    }
}
