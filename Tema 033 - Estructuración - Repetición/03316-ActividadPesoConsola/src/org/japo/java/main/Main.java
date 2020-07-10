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
        //Constantes
        final int MAX_DIAS = 7;
        final int MIN_PESO = 0;
        final int MAX_PESO = 250;

        int dia = 1;
        double pidePeso;
        double media;
        double sumaPeso = 0;
        boolean isOk = true;

        //muestraBanner();  
        System.out.printf("....PROGRAMA CONTROL DE PESO.... %n");

        do {
            try {
                System.out.printf("%nDía nº %d%n", dia);
                System.out.printf("Introduzca el peso deseado: ");
                pidePeso = SCN.nextDouble();

                if (pidePeso <= MAX_PESO && pidePeso >= MIN_PESO) {
                    isOk = false;
                    dia++;
                    sumaPeso += pidePeso;

                } else {
                    System.out.printf("%nERROR: Peso introducido incorrecto."
                            + "%n");
                }
            } catch (Exception e) {
                System.out.printf("%nERROR: Dato introducido no válido%n");
            } finally {
                SCN.nextLine();
            }

        } while (isOk || (dia <= MAX_DIAS));
        // SALIDA DE LA MEDIA. Sacamos la media de la semana
        media = sumaPeso / MAX_DIAS;
        //Salida de la media con dos decimales
        System.out.println("----------------------------");
        System.out.printf("%nEl peso medio es de %.2f Kg.%n", media);
    }
}
