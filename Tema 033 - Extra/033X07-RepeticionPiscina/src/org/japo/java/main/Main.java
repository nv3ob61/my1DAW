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
        //Creamos boolean para cada objeto, a lo rústico
        boolean toalla = false;
        boolean chanclas = false;
        boolean gafas = false;
        boolean tapones = false;
        boolean gel = false;
        boolean gorro = false;
        //boolean para comprobar que lo llevamos todo.
        boolean todoOk;
        //boolean en caso de que falte algo si queremos repetir la lista.
        boolean repite = false;

        String respuesta;
        do {

            //muestraBanner();
            System.out.printf("%n***********************%n");
            System.out.printf("   CHECKLIST PISCINA%n");
            System.out.printf("***********************%n%n");

            //Bucle para introducir el dato TOALLA
            do {
                System.out.print("¿Llevas la toalla? (SI o NO) ..: ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    toalla = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Bucle para introducir el dato CHANCLAS
            do {
                System.out.print("¿Llevas las chanclas? (SI o NO): ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    chanclas = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Bucle para introducir el dato GAFAS
            do {
                System.out.print("¿Llevas las gafas? (SI o NO) ..: ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    gafas = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Bucle para introducir el dato TAPONES
            do {
                System.out.print("¿Llevas los tapones? (SI o NO) : ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    tapones = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Bucle para introducir el dato GEL
            do {
                System.out.print("¿Llevas el gel? (SI o NO) .....: ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    gel = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Bucle para introducir el dato GORRO
            do {
                System.out.print("¿Llevas el gorro? (SI o NO) ...: ");
                respuesta = SCN.nextLine().toUpperCase();

                if (respuesta.equals("SI")) {
                    gorro = true;
                }
            } while (!respuesta.equals("SI") && !respuesta.equals("NO"));

            //Condición que muestra si llevamos la bolsa completa
            todoOk = toalla && chanclas && gafas && tapones && gel && gorro;

            //Si todo va bien
            if (todoOk) {
                System.out.printf("%nBIEN: Lo llevamos todo%n");
                repite = false;
                // En caso contrario
            } else {
                System.out.printf("%nERROR: Revisa la bolsa%n%n");

                //Condiciones que muestra lo que nos falta por coger...
                if (!toalla) {
                    System.out.println("Te falta coger la toalla");
                }
                if (!chanclas) {
                    System.out.println("Te falta coger las chanclas");
                }
                if (!gafas) {
                    System.out.println("Te falta coger las gafas");
                }
                if (!tapones) {
                    System.out.println("Te falta coger los tapones");
                }
                if (!gel) {
                    System.out.println("Te falta coger el gel");
                }
                if (!gorro) {
                    System.out.println("Te falta coger el gorro");
                }

                //Si algo falla podemos ejecutar el programa otra vez...
                do {
                    System.out.printf("%n¿Deseas repetir la lista de nuevo? "
                            + "(SI o NO) : ");
                    respuesta = SCN.nextLine().toUpperCase();

                    if (respuesta.equals("SI")) {
                        repite = true;
                    }
                } while (!respuesta.equals("SI") && !respuesta.equals("NO"));
            }
        } while (repite);
    }
}
