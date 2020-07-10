 /*
 * Copyright 2019 mon_mode    0mon.mode@gmail.com
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

Validación DNI
==============
Número de DNI (Q para salir)...: Y1234567X

DNI introducido .: Y1234567X | Gracias por utilizar el programa. 

Validación DNI
==============
Número de DNI (Q para salir)...: X1234567L

DNI introducido .: X1234567L | Gracias por utilizar el programa.

Validación DNI
==============
Número de DNI (Q para salir)...: 12345678Z

DNI introducido .: 12345678Z | Gracias por utilizar el programa.
*/

package org.japo.java.app;

import org.japo.java.libraries.UtilesDNI;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final String PACO_LONG = "==============";
    public static final String MSG_USR = "Número de DNI (Q para salir)...: ";
    public static final String MSG_FIN = "DNI introducido .:";
    public static final String GRACIAS = "Gracias por utilizar el programa.";

    public final void launchApp() {
        String dni;

        muestraBanner();
        dni = UtilesDNI.obtener(MSG_USR);
        if (dni.equals("Q")) {
            System.out.println(GRACIAS);
        } else {
            System.out.printf("%n%s %s | %s%n%n",
                    MSG_FIN, dni, GRACIAS);
        }
    }

    public final void muestraBanner() {
        System.out.println("Validación DNI");
        System.out.println(PACO_LONG);

    }
}
