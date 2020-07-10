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
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constantes para los valores del random
        final int NUM_MIN = 1;
        final int NUM_MAX = 10;
        //Declaramos variables con el núm de intentos
        int intentos = 3;
        //Variables del random a adivinar y el que introduce el usuario.
        int numRnd;
        int numUser = 0;
        //Boolean de control y para indicar si el pass es el correcto
        boolean isOk = false;
        boolean passOk = false;

        //Generamos el número a adivinar
        numRnd = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
//        System.out.println("Muestra del random, borrar luego");
//        System.out.println(numRnd);

        //Cabecera del programa
        System.out.println("MEGA ADIVINATOR (c) 2019 - JAPO Labs");
        System.out.println("------------------------------------");
        System.out.println("Se ha generado un número entre 1 y 10");
        System.out.println("---");
        //Bucle while para que acabe con un valor válido y no se rompa el progr.
        //Acaba si se agotan los 3 intentos o si numUser == numRnd
        while (intentos != 0 && numUser != numRnd) {
            do {
                try {
                    //Mensaje para el usuario
                    System.out.printf("Quedan %d intentos - Número: ", intentos);
                    numUser = SCN.nextInt();
                    //Si el dato introducido es bueno, sale del loop
                    isOk = false;
                    intentos--;
                    //Si el número es bueno, passOk es true.
                    if (numUser == numRnd) {
                        passOk = true;
                        //Generamos dos else if para dar pistas al user.
                    } else if (numUser > numRnd) {
                        System.out.println("Prueba un número MENOR.");
                        System.out.println("---");
                    } else if (numUser < numRnd) {
                        System.out.println("Prueba un número MAYOR.");
                        System.out.println("---");
                    }
                } catch (Exception e) {
                    System.out.println("ERROR: Entrada incorrecta");
                } finally {
                    //borra el buffer, si no entra en bucle sin fin.
                    SCN.nextLine();
                }
            } while (isOk);

        }
        if (passOk) {
            System.out.printf("Era el %d - ¡Enhorabuena! %n", numRnd);
        } else {
            System.out.printf("Era el %d - ¡Otra vez será! %n", numRnd);
        }
    }
}
