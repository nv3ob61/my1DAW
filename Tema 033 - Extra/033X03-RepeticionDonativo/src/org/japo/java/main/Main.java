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

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
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

//Inicio Random
    public static final Random RND = new Random();

//Como trabajamos con dinero solo necesitamos dos decimales
//Usamos la clase formato decimal
    public static final DecimalFormat DF = new DecimalFormat("#.##");

    public static void main(String[] args) {
        //Variables
        double donativo;
        double suma = 0;
        //Usamos el String para cambiar el "." del formato por nuestra ","
        String donativoPunto;

        //Bucle for para los 13247 donativos para la parroquia local.
        for (int i = 1; i < 13248; i++) {
            donativo = RND.nextDouble();
            // System.out.printf("Total %d, %.2f%n", i, donativo);
            suma += donativo;
        }

        //Pasamos a String el valor resultante de la suma de donativos.
        donativoPunto = String.valueOf(DF.format(suma));
        //Cambiamos el punto por la coma
        String donativoComa = donativoPunto.replaceAll("\\.", ",");

        //Mensaje salida, seguro que hay otra forma mejor de hacerlo.
        System.out.printf("%n--------------------------------------------------%n");
        System.out.println("---- MARATÓN SOLIDARIO DE NAVIDAD RADIO RAHIM ----");
        System.out.printf("\tEl total recaudado es de " + donativoComa + " € %n");
        System.out.println("--------------------------------------------------");
        System.out.println("------------ Patrocina: Negu Gorriak -------------");
        System.out.println("--------------------------------------------------");
    }
}
