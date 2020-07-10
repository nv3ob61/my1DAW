/*
 * Copyright 2019 mon_mo.    0mon.mode@gmail.com
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
 * @author mon_mo
 */
public class UtilesEntrada {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------------------";

    public static final double obtener(String msgUser, String msgErr) {
        //Entrada de teclado
        int numero = 0;
        boolean isOk = true;
        //Bucle externo para que acabe con un valor válido y no se rompa el progr.
        do {
            try {
                //Entrada de datos
                System.out.printf(msgUser);
                numero = SCN.nextInt();
                //Si el dato introducido es bueno, sale del loop
                isOk = false;
            } catch (Exception e) {
                System.out.println(PACO);
                System.out.println(msgErr);
                System.out.println(PACO);
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }
        } while (isOk);
        // DEVUELVE EL NUMERO
        return numero;
    }

    public static final String obtenerString() {
        String str;

        str = SCN.nextLine();

        return str;
    }
}
