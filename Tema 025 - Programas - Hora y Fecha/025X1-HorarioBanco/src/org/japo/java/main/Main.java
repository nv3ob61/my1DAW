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
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public class Main {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    // Random
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Límites del día    (Duplicar línea   Mays + Ctrl + Abajo)
        final int H_MIN = 0;
        final int M_MIN = 0;
        final int H_MAX = 23;
        final int M_MAX = 59;

        //Límites AATT bancaria. De 10:30 a 12:15   (Ctrl + H) Replace
        final int H_INI = 10;
        final int M_INI = 30;
        final int H_FIN = 12;
        final int M_FIN = 15;

        //Pasamos el tiempo a minutos
        final int TMP_INI = H_INI * 60 + M_INI;
        final int TMP_FIN = H_FIN * 60 + M_FIN;

        // Hora aleatoria
        int hRnd = RND.nextInt(H_MAX - H_MIN + 1) + H_MIN;
        int mRnd = RND.nextInt(M_MAX - M_MIN + 1) + M_MIN;
        int tmpRnd = hRnd * 60 + mRnd;

        // Hora Usuario
        int hUsr = 0;
        int mUsr = 0;
        int tmpUsr;
        boolean isOk = false;
        boolean isOk2 = false;
        do {

            do {
                try {
                    System.out.print("Hora inicio.......: ");
                    hUsr = SCN.nextInt();
                    SCN.nextLine();
                    isOk = true;
                } catch (Exception e) {
                    System.out.println("OOOOPS!");
                    //Borrar buffer
                    SCN.nextLine();
                }
            } while (!isOk);

            do {
                try {
                    System.out.print("Mins inicio.......: ");
                    mUsr = SCN.nextInt();
                    SCN.nextLine();
                    isOk2 = true;
                } catch (Exception e) {
                    System.out.println("OOOOPS!");
                    //Borrar buffer
                    SCN.nextLine();
                }
            } while (!isOk2);
            //Una vez validado el tiempo del usuario lo pasamos a minutos.
            tmpUsr = hUsr * 60 + mUsr;

            //Antes de decir si estamos en el horario mostramos hora Aleatorua
            System.out.printf("Hora Aleatoria... : %02d:%02d%n", hRnd, mRnd);

            //Antes de decir si estamos en el horario mostramos hora manual
            System.out.printf("Hora Manual ......: %02d:%02d%n", hUsr, mUsr);

            System.out.printf("Hora Aleatoria ...: %s%n",
                    tmpRnd >= TMP_INI && tmpRnd <= TMP_FIN ? "Atención Disponible"
                            : "Atención NO disponible");

            //Análisis hora usuario, lo pasamos todo a minutos.
            System.out.printf("Hora Manual ......: %s%n",
                    tmpUsr >= TMP_INI && tmpUsr <= TMP_FIN ? "Atención Disponible"
                            : "Atención NO disponible");
        } while (!isOk || !isOk2);
    }

}
