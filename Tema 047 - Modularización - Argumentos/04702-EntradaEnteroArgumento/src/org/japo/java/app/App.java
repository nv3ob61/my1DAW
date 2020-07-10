/*
 * Copyright 2019 mon_mo.
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
package org.japo.java.app;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final String MSG_USR = "Introducir número ....: ";
    public static final String MSG_ERROR = "ERROR: Entrada incorrecta";
    public static final String MSG_OUT = "Número introducido ...: ";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-------------------";

// Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public final void launchApp() {
        int numero;
        //solo hace el programa una vez...
        muestraBanner();
        numero = obtener();
        muestraNumero(numero);
    }

    public final void muestraBanner() {
        System.out.println("INTRODUCCIÓN ENTERO");
        System.out.println(PACO_LONG);
    }

    public final int obtener() {
        //Validamos el entero
        int numero = 0;
        boolean isOk = false;
        do {
            try {
                System.out.printf("%s", MSG_USR);
                numero = SCN.nextInt();
                isOk = true;
            } catch (Exception e) {
                System.out.println(MSG_ERROR);
                System.out.println(PACO);
            } finally {
                SCN.nextLine();
            }
        } while (!isOk);
        return numero;
    }

    public final void muestraNumero(int numero) {
        System.out.println(PACO);
        System.out.printf("%s%d%n", MSG_OUT, numero);
    }
}
