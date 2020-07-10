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
        //Constante PASSWORD
        final int PASSWORD = 1234;
        //Definimos variable de entrada de pass y boolean de control si es OK.
        int tryPass;
        boolean passOk = false;
        //Centinela que cubre el trycatch si no son números
        boolean isOk = true;

        //Bucle externo para que acabe con un valor válido y no se rompa el progr.
        do {
            try {
                //Bucle que se repite 3 veces. La condición --> i < 3 && !passOk 
                // quiere decir que el pass introducido no es true
                for (int i = 0; i < 3 && !passOk; i++) {
                    System.out.printf("Introduzca la contraseña: ");
                    tryPass = SCN.nextInt();
                    //Si el dato introducido es bueno, sale del loop
                    isOk = false;

                    //Si el password es bueno, passOk es true. Lógicamente...
                    if (tryPass == PASSWORD) {
                        passOk = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("ERROR: Pedimos un dato numérico");
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }
        } while (isOk);

        //Mensajes de salida
        if (passOk) {
            System.out.println("--------------------------------------");
            System.out.println("Súbeme la arradio, dale decibeliossss!");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("¡Sofía vas to pedo! Hoy no hay música.");
            System.out.println("************ ¡A DORMIRLA! ************");
        }
    }

}
