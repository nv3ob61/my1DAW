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
        int numero;
        //Constantes
        final int PRIM_MAX = 49;
        final int PRIM_MIN = 1;

        //Generamos dato 
        try {
            System.out.println("Número primitiva...: ");
            numero = SCN.nextInt();

            
            boolean testOK = numero >= PRIM_MIN && numero <= PRIM_MAX;
            System.out.println(testOK ? "Número correcto" : "Número NO correcto");
            
        } catch (Exception e) {
            System.out.println("OOOOPPS!");
        
        }finally {
            // Borrar buffer
            SCN.nextLine();

        }
    }
}