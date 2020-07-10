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
        double acumulaNotas = 1;
        int contador = -1;
        int suspensos = 0;
        int aprobados = 0;
        int notables = 0;
        int sobresalientes = 0;
        double nota = 0;
        double mediaNotas;
        //Boolean para
        boolean isOk = false;
        boolean salida = false;

        while (nota != -1) {

            do {
                // Cuarentena
                try {
                    // Entrada dato
                    System.out.println("Nota de APROBADO del alumno, "
                            + "RECUERDA USAR -1 para salir: ");
                    nota = SCN.nextDouble();

                    // Actualizar semáforo si el valor no es un numérico
                    isOk = true;
                } catch (Exception e) {
                    // Entrada incorrecta
                    System.out.println("ERROR: Entrada incorrecta");
                } finally {
                    // Vaciar buffer
                    SCN.nextLine();
                }
                acumulaNotas += nota;
            } while (!isOk);

            contador++;
            // Validación paridad
            if (nota == -1) {
                salida = true;
            } else if (nota < 0 || nota > 10) {
                System.out.println("ERROR: Nota incorrecta");
            } else if (nota >= 5 && nota < 7) {
                System.out.println("SOUT: aprobado");
                aprobados++;
            } else if (nota >= 7 && nota < 9) {
                System.out.println("SOUT: notable");
                notables++;
            } else if (nota >= 9) {
                System.out.println("SOUT: sobresaliente");
                sobresalientes++;
            } else {
                System.out.println("SOUT: suspenso");
                suspensos++;
            }
        }
        //Saca la media de todas las notas.
        mediaNotas = acumulaNotas / contador;
        //Salida con el contador de notas y la media
        System.out.println("Contador de notas introducidas: " + contador);
        System.out.printf("La media introducida es de : %.2f%n", mediaNotas);
        System.out.println("Núm suspensos: " + suspensos);
        System.out.println("Núm aprobados: " + aprobados);
        System.out.println("Núm notables: " + notables);
        System.out.println("Núm sobresalientes: " + sobresalientes);

    }
}
