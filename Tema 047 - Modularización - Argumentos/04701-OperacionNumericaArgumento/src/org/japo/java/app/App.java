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

/**
 *
 * @author mon_mo
 */
public final class App {
// Todos los objetos que se instalen en una clase comparten lo que esté marcado
// como static.

    /* Todos los coches de la misma marca comparten la marca pero el volante no.
    
     */
    public static final int OP_SUM = 0; // Suma
    public static final int OP_RES = 1; // Resta
    public static final int OP_MUL = 2; // Producto
    public static final int OP_DIV = 3; // Cociente
    public static final int OP_MOD = 4; // Resto
    public static final int OP_MED = 5; // Media
    public static final int OP_MAY = 6; // Mayor
    public static final int OP_MEN = 7; // Menor

    public static final String ASTER = "***************************";
    public static final String SEPARA_LARGO = "------------------";
    
    public static final String MSG_RANGO = "ERROR: valor fuera de rango";
    public static final String MSG_OUT = "Número introducido ...: ";

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public final void launchApp() {
        int opcion;
        double n1;
        double n2;
        double result;
        boolean isOk = false;

        do {
            muestraMenu();
            opcion = pideOpcion();
            if (opcion == 99) {
                isOk = true;
            } else if (opcion < 0 || opcion > 7) {
                System.out.println(ASTER);
                System.out.println(MSG_RANGO);
                System.out.println(ASTER);
            } else {
                n1 = pideNum();
                n2 = pideNum();
                result = operar(n1, n2, opcion);
                mensajeSalida(n1, n2, result, opcion);
            }
        } while (!isOk);

        System.out.println("Gracias por utilizar el programa");
    }

    public final void muestraMenu() {
        System.out.printf("   MENÚ  INICIO %n");
        System.out.println(SEPARA_LARGO);
        System.out.printf(" ¿Qué desea hacer? %n%n");
        System.out.println("0 ......... Suma");
        System.out.println("1 ......... Resta");
        System.out.println("2 ......... Producto");
        System.out.println("3 ......... Cociente");
        System.out.println("4 ......... Resto");
        System.out.println("5 ......... Media");
        System.out.println("6 ......... Mayor");
        System.out.println("7 ......... Menor");
        System.out.printf("99 ........ SALIR%n%n");
        System.out.print("Introduzca una opción: ");
    }
//FALTA PROTEGER DE ERRORES pideOpcion() y pideNum() *****************************

    public final int pideOpcion() {
        int opcion;

        opcion = SCN.nextInt();
        return opcion;
    }

    public final double pideNum() {
        double num;

        System.out.println("---");
        System.out.printf("Introduzca un número: ");
        num = SCN.nextDouble();
        return num;
    }

    public final double operar(double n1, double n2, int op) {
        //variable que generará el resultado
        double result = 0;

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

    public final void mensajeSalida(double n1, double n2, double result,
            int op) {
        //Definimos la salida de datos aquí para que complete la frase del 
        // resultado de la operación que hace dentro del switch para el formato:
        /* OPERACIÓN NUMÉRICA
        ==================
        Número 1 ....: 3
        Número 2 ....: 7
        ---
        El MAYOR es .: 7 */

        System.out.printf(SEPARA_LARGO);
        System.out.println("OPERACIÓN NUMÉRICA");
        System.out.println(SEPARA_LARGO);
        System.out.printf("Número 1 ....: %.0f%n", n1);
        System.out.printf("Número 2 ....: %.0f%n", n2);
        System.out.println("---");
        switch (op) {
            case OP_SUM:
                System.out.printf("La SUMA es de: %.0f%n", result);
                break;
            case OP_RES:
                System.out.printf("La RESTA es de: %.0f%n", result);
                break;
            case OP_MUL:
                System.out.printf("El PRODUCTO es de: %.0f%n", result);
                break;
            case OP_DIV:
                if (n2 == 0) {
                    System.out.printf("ERROR: división por 0%n");
                } else {
                    System.out.printf("El COCIENTE es: %.0f%n", result);
                }
                break;
            case OP_MOD:
                System.out.printf("El RESTO es: %.0f%n", result);
                break;
            case OP_MED:
                System.out.printf("La MEDIA es: %.0f%n", result);
                break;
            case OP_MAY:
                System.out.printf("El MAYOR es: %.0f%n", result);
                break;
            case OP_MEN:
                System.out.printf("El MENOR es: %.0f%n", result);
                break;
        }
        //Línea separadora del final.
        System.out.println(SEPARA_LARGO);
    }
}
