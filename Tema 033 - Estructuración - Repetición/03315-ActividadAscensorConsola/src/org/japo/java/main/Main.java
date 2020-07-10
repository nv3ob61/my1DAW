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

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes nº personas y definimos el nº de plantas
        final int MIN_PERS = 0;
        final int MAX_PERS = 4;
        final int MIN_PLANTA = 1;
        final int MAX_PLANTA = 10;

        //Bucle for para las X personas, cuenta de 0 a 3  (4 posiciones)
        for (int i = MIN_PERS; i < MAX_PERS; i++) {

            //Variable planta dentro del bucle for!
            int planta = 0;
            //Do-while para introducir los datos correctos
            do {
                try {
                    //Entrada datos
                    System.out.printf("Pasajero nº %d%n", i + 1);
                    System.out.printf("Introduzca la planta deseada: ");
                    planta = SCN.nextInt();

                    //Condiciones
                    if (planta > MAX_PLANTA || planta < MIN_PLANTA) {
                        System.out.printf("%nERROR: Planta introducida incorrecta"
                                + "%n%n");
                    } else {
                        System.out.printf("La planta introducida es ...: %02d%n%n",
                                planta);
                    }
                    //Se repite si la planta está fuera del rango 1-10
                } catch (Exception e) {
                    System.out.printf("%nERROR: Dato introducido no válido%n%n");
                } finally {
                    SCN.nextLine();
                }
            } while (planta > MAX_PLANTA || planta < MIN_PLANTA);
        }
    }
}
