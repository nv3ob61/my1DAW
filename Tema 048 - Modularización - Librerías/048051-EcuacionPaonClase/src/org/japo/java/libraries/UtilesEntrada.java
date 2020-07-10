/*
 * Copyright 2019 mon_mo.     0mon.mode@gmail.com
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
public final class UtilesEntrada {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    
    // Constantes
    public static final String MSG_USR = "Introduce un número ..:";
    public static final String MSG_OUT = "Número introducido ...: ";
    public static final String MSG_ERR = "ERROR: Entrada incorrecta";
    
    public static double obtener = 0;

      public static final double obtener(String mgsUsr, String mgsErr) {
        // NUMERO A DEVOLVER
        double numero = 0;

        // PROCESO DE ENTRADA
        boolean errorOK = true;
        do {
            try {
                // REALIZA LA PETICION
                System.out.print(MSG_USR);
                numero = SCN.nextDouble();

                // ACTUALIZAR BUCLE
                errorOK = false;
            } catch (Exception e) {
                // MENSAJE DE ERROR
                System.out.println(MSG_ERR);
                // SEPARADOR

            } finally {
                SCN.nextLine();
            }
        }while (errorOK);
        // DEVUELVE EL NUMERO
        return numero;
    }
    
    public static final int leerEntero (String msgUsr, String msgErr) {
        return(int)obtener(msgUsr,msgErr);
    }
}
