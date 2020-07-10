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
        int number = 0;
        //Boolean uno para validar el dato numérico y otro para definir si es par
        boolean isOk = false;
        boolean esPar = false;

        //Bucle si es impar o 0 
        do {
            //Bucle para validar dato numérico: isOk
            do {
                try {
                    //Entrada del número
                    System.out.printf("Introduzca un número ...: ");
                    number = SCN.nextInt();
                    //Si es válido cambia la condición.
                    isOk = true;

                    //Boolean para verificar que es par.
                    esPar = number % 2 == 0;
                    //Contemplamos la opción del 0 como la ausencia de pares/impares.
                    if (number == 0) {
                        System.out.println("El 0 no representa nada");
                    } else if (esPar) {
                        //Salida consola del programa
                        System.out.println("-------------------------");
                        System.out.printf("Número par .............: %d%n",
                                number);
                        //Solo nos queda que es impar
                    } else {
                        System.out.printf("%nEl número introducido es impar.%n%n");
                    }
                } catch (Exception e) {
                    System.out.printf("%nERROR: Entrada incorrecta.%n%n");
                } finally {
                    SCN.nextLine();
                }
            } while (!isOk);

        } while (!esPar || number == 0);
    }
}
