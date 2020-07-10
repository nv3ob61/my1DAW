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
        //Constantes
        final double MULTA = 60;
        final int DIAS_DESCUENTO = 30;

        //Variables
        double importeFinal;
        double importeDirect = 0;
        //Cambio descuento a variable por que depende de los días de demora.
        //también podríamos haber definido dos constantes DENTRO y fuera de días.
        double descuento = 20;
        int diasDemora;

        try {
            System.out.println("Alternativa de Multa");
            System.out.println("====================");

            //Introducir dias de demora
            System.out.printf("Dias de demora ............: ");
            diasDemora = SCN.nextInt();

            //Separador
            System.out.println("---");

            //Salida
            System.out.printf(Locale.ENGLISH, "Importe inicial multa .....: %.2f €%n", MULTA);
            System.out.println("---");
            System.out.printf("Plazo con descuento .......: %d días%n", DIAS_DESCUENTO);

            //if else. Calcula si se ha pasado de fecha.
            if (diasDemora <= DIAS_DESCUENTO) {
                importeDirect = MULTA * (descuento / 100);
            } else {
                //descuento = 0 si nos pasamos de día
                descuento = 0;
            }
            
            //Salida del descuento. Si no existe se muestran a cero.
            System.out.printf("Tanto descuento ...........: %.0f %% %n", descuento);
            System.out.printf(Locale.ENGLISH, "Importe descuento .........: %.2f "
                    + "€ %n", importeDirect);
            
            //Separador
            System.out.println("---");

            //Calcula el importe final
            importeFinal = MULTA - importeDirect;
            System.out.printf(Locale.ENGLISH, "Importe final multa .......: %.2f "
                    + "€ %n", importeFinal);

        } catch (Exception e) {
            System.out.println("ERROR: Boing Boom Tschak!");
        } finally {
            SCN.nextLine();
        }
    }
}
