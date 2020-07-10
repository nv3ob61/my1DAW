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
 * @author mon-mode
 */
public class testClass {
// Instanciar Scanner

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(final String[] args) {
        //Declaramos array de 10000 elementos, tantos como códigos postales
        int codPost[];
        codPost = new int[9999];
        //Variable num para llenar el array
        int num;
        int numArray;
        String respuesta = "";

        numArray = codPost.length;
        //Cabecera del programa
        muestraBanner();

        do {
            muestraOpciones();
            num = pideOpciones();
            switch (num) {
                case 1:
                    nuevoCP(codPost, respuesta, numArray);
                    ordenaCP(codPost);
                    break;
                case 2:
                    todosCP(codPost);
                    break;
                case 0:
                    System.out.printf("%nFIN DEL PROGRAMA%n%n");
                    break;
                default:
                    System.out.println("Opción introducida incorrecta");
            }
        } while (num != 0);
    }

    public static void muestraBanner() {
        System.out.println("--------------------------------------");
        System.out.println("     PROGRAMA DE CÓDIGOS POSTALES");
        System.out.println("--------------------------------------");
    }

    public static void muestraOpciones() {
        /* 
         * Mostramos el menú en pantalla con las diferentes opciones.
         */
        System.out.printf("%n   ........ MENÚ PRINCIPAL .........%n%n");
        System.out.println("1. ....... Añadir código postal.");
        //System.out.println("2. Eliminar CP.");
        //System.out.println("3. Calculo medio, máximo y mínimo.");
        System.out.println("2. ...... Mostrar todos los códigos postales.");
        System.out.println("0. ...... FIN.");
        System.out.println("");
    }

    public static int pideOpciones() {
        /* 
         * Se solicita un número al usuario que se comprobará en el main.
         */
        //Entrada de teclado
        int numero = 0;
        boolean isOk = true;

        //Bucle externo para que acabe con un valor válido y no se rompa el progr.
        do {
            try {
                //Entrada de datos
                System.out.print("Elije una opción del 1 al 4. (0 para salir): ");
                numero = SCN.nextInt();

                //Si el dato introducido es bueno, sale del loop
                isOk = false;
            } catch (Exception e) {
                System.out.println("ERROR: Valor introducido incorrecto");
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }
        } while (isOk);

        return numero;
    }

    public static void nuevoCP(int num[], String respuesta, int numArray) {
        /* 
         * Se comprueba que la lista no esté llena.
         * Si no está llena se introduce un numero de cuenta válidado
         */
        if (num[(num.length - 1)] != 0) {
            System.out.println("No se pueden introducir más CP");
            System.out.println("...Memoria llena...");
        } else {

            System.out.printf("%n-----------------------------%n");
            System.out.println("     NUEVO CÓDIGO POSTAL");
            System.out.printf("-----------------------------%n%n");
            try {
                System.out.print("Introduce el código en formato XXXXX : ");
                num[(num.length - 1)] = SCN.nextInt();
                if (num[(num.length - 1)] > 99999 || num[(num.length - 1)] < 1) {
                    System.out.println("El número no puede ser ni menor que 1 ni mayor que 99999.");
                }
            } catch (Exception e) {
                System.out.printf("%nERROR: Valor introducido incorrecto%n");
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }

        }
    }

    public static void ordenaCP(int num[]) {
        /* 
         * Organizamos almacenando el valor que no tiene que estar es ese sitio, 
        en una variable para despues colocarlo en su puesto 
          y así recorremos el vector tantas veces como celdas tiene para realizar esta comprobación.
         */
        int almaNum;
        for (int f = 0; f < (num.length - 1); f++) {
            for (int g = f + 1; g < num.length; g++) {
                if (num[f] < num[g]) {
                    almaNum = num[f];
                    num[f] = num[g];
                    num[g] = almaNum;
                }
            }
        }
    }

    //método que no se utiliza de momento
    public static String otroCP() {

        String respuesta;

        do {
            System.out.println("\n...¿Desea introducir otro código? ... Escriba si/no");
            respuesta = SCN.next();
            respuesta = respuesta.toUpperCase();
            if (respuesta.equals("SI") && respuesta.equals("NO")) {
                System.out.println("Respuesta no válida.");
            }
        } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

        return respuesta;
    }

    public static void todosCP(int num[]) {
        /* 
         * Se muestran todos los códigos introducidos.
         */
        if (num[0] == 0) {
            System.out.println("No se pueden mostrar CP");
            System.out.println(".....Memoria Vacía.....");
        } else {
            System.out.println("--------------------------------");
            System.out.println(" TODOS LOS CÓDIGOS POSTALES");
            System.out.println("--------------------------------");
            System.out.println("");

            for (int f = 0; f < num.length; f++) {
                if (num[f] != 0) {
                    System.out.println("CP: " + num[f]);
                }
            }
        }
    }
}

