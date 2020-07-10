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
public class Main {
// Instanciar Scanner

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Variables
        //Implementamos el programa para que no solo saque la tabla del 9.

        int numero = 0;
        int result;
        boolean isOk = true;

        //Cabecera
        System.out.printf("Hola Manolito, este es tu programa básico para"
                + " aprender las tablas de multiplicar. %n%n");
        //Bucle centinela? para el control de la entrada de enteros.
        do {
            try {
                //Entrada de datos
                System.out.printf("Introduce un número entero ........: ");
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

        //Mostramos salida del programa
        System.out.printf("%n.. Mostrando la tabla del %d ..%n%n", numero);
        for (int i = 0; i < 11; i++) {
            result = numero * i;
            System.out.printf("\t%d x %02d = %d%n", numero, i, result);
        }

        //Footer de salida
        System.out.printf("%nGracias Manolito, vuelve cuando quieras! %n");
    }
}
