/*
 * Copyright 2019 mon_mo.   0mon.mode@gmail.com
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
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author nv3ob61
 */
public class UtilesEntrada {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String MSG_USR = "Introducir número .....: ";
    public static final String MSG_ERROR = "ERROR: Entrada incorrecta";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-------------------";

    public final static double obtener() {
        //Validamos el entero
        double numero = 0;
        boolean isOk = false;
        do {
            try {
                System.out.printf("%s", MSG_USR);
                numero = SCN.nextDouble();
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

}
