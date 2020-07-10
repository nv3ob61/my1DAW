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

import java.util.Scanner;
import java.util.Locale;

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
        //Definimos variables
        int talla;

        //Cuarentena
        try {
            // Leer dato
            System.out.print("Introduzca su talla de zapato: ");
            talla = SCN.nextInt();

            //Mensaje de salida
            System.out.printf("Talla de zapato introducida..: %d%n", talla);
        } catch (Exception e) {

            //Mostramos mensaje de excepción
            System.out.println("ERROR: Dato introducido incorrecto");
        } finally {
            // Borramos buffer
            SCN.nextLine();
        }

    }
}
