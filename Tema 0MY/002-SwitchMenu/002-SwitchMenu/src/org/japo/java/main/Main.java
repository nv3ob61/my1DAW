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
import org.japo.java.libraries.UtilesEntrada;
/**
 *
 * @author mon-mode
 */
public final class Main {

    //Errores y Strings de salida
    public static final String MSG_DATOS = "ERROR: Datos introducidos erróneos.";
    public static final String MSG_USER = "Elije una opción del 1 al 6. (0 para salir): ";
    public static final String MSG_ROWS = "Introduzca el número de columnas: ";
    public static final String MSG_CHAR = "Introduzca una letra: ";
    public static final String MSG_OPCION = "ERROR: Opción incorrecta.";
    public static final String MSG_OUT = "Gracias por utilizar el programa";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------";
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Iniciamos variables
        int opcion;
        
        //INICIO DEL PROGRAMA
        muestraFrontBanner();
        do {
            muestraOpciones();
            opcion = UtilesEntrada.leerEntero(MSG_USER, MSG_DATOS);
            switch (opcion) {
                case 1:
                    piramid1(UtilesEntrada.leerEntero(MSG_ROWS, MSG_DATOS));
                    break;
                case 2:
                    piramid2(UtilesEntrada.leerEntero(MSG_ROWS, MSG_DATOS));
                    break;
                case 3:
                    piramidChar();
                    break;
                case 0:
                    System.out.println(MSG_OUT);
                    break;
                default:
                    System.out.println(MSG_OPCION);
                    break;
            }
        } while (opcion != 0);

    }

    public static void muestraFrontBanner() {
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t Programa de pirámides!");
        System.out.printf("-----------------------------------------------------%n%n");
    }

    public static void muestraOpciones() {
        /* 
         * Mostramos el menú en pantalla con las diferentes opciones.
         */
        System.out.printf("%n..........MENÚ PRINCIPAL.........: %n%n");
        System.out.printf("1.....Pirámides con asteriscos...: %n");
        System.out.printf("2...............con números......: %n");
        System.out.printf("3...............con char.........: %n%n");
        System.out.printf("4. opciónvacia.............: %n");
        System.out.printf("5. opciónvacia.............: %n");
        System.out.printf("6. opciónvacia.............: %n%n");
        System.out.printf("0. FIN.%n");
        System.out.println("");
    }

    public static void piramid1(int rows) {
        /* 
         * Se solicita un número al usuario que se comprobará en el main.
         */
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void piramid2(int rows) {
        /* 
         * Se solicita un número al usuario que se comprobará en el main.
         */
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void piramidChar() {
        //Elige letra inicio y final para formar la pirámide.
        
        char letra = UtilesEntrada.leerCaracter(MSG_CHAR, MSG_DATOS);
        char last = letra,
                alphabet = 'A';
        for (int i = 0; i <= (last - 'A'); ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(alphabet + " ");
            }
            ++alphabet;
            System.out.println();
        }
    }
}
