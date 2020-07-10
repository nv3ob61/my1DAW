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
        //Variables
        double nota = 0;

        do {
            try {
                //Entrada del dato nota
                System.out.printf("Introduza su nota a validar ....: ");
                nota = SCN.nextDouble();

                //Condición si es mayor que 5.00 hasta 10.0
                if (nota >= 5 && nota <= 10) {
                    //Salida
                    System.out.println("--------------------------------");
                    System.out.printf("El alumno ha APROBADO con ......: %.2f%n", nota);
                    //Alerta si la nota está entre 0 y 5, no aprobado
                } else if (nota >= 0 && nota < 5) {
                    System.out.println("La nota no es suficiente para aprobar.");
                    //Avisa si el valor se sale del rango 0-10    
                } else {
                    System.out.println("Valor introducido fuera del rango 0-10");
                }

                //Repite bucle hasta que la entrada sea una nota APROBADO.
            } catch (Exception e) {
                System.out.println("ERROR: Valor introducido incorrecto");
            } finally {
                SCN.nextLine();
            }
        } while (nota < 5 || nota > 10);
    }
}
