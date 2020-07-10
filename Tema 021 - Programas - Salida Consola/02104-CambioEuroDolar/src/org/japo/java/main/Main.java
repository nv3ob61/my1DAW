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

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {

        final double DOLAR = 1.10;

        System.out.printf("Un euro son %.2f" + " dólares %n%n", DOLAR);
        System.out.println("FORMA alternativa");
        System.out.println();
        System.out.print("Un Euro se cambia por: ");
        /* Para cambiar la coma por el punto hay que cambiar la convención
        cultural con LOCALE y añadir una coma detrás.
        
        Escribimos el inicio: Loca. Pulsamos Ctrl + Space  (muestra sugerencias)
         */
        System.out.printf(Locale.ENGLISH, "%.2f", 1.0911);
        System.out.printf(" dólares.%n%n");
        System.out.printf("FORMA 3: %n%n");
        /* El 05.2f corresponde al total de caracteres que ocupará la salida*/

        System.out.printf(Locale.ENGLISH, "%05.2f", 1.0911);
        System.out.println(" dólares.");
    }

}
