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
import java.util.Random;
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

    // Random
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //constante
        final double TARIFA = 0.15;
        //Límites del día    (Duplicar línea   Mays + Ctrl + Abajo)
        final int H_MIN = 0;
        final int M_MIN = 0;
        final int H_MAX = 23;
        final int M_MAX = 59;

        //variable tiempo
        int hEnt, mEnt, hRnd, mRnd, tmpEnt, tmpRnd, minDis, hourDis, minDif;
        double coste;

        try {
            //pedimos momento entrada y salida del párking
            System.out.println("Párking Morvedre");
            System.out.printf("================%n");
            System.out.print("Hora entrada .......: ");
            hEnt = SCN.nextInt();
            SCN.nextLine();
            System.out.print("Minuto entrada .....: ");
            mEnt = SCN.nextInt();
            SCN.nextLine();

            //Generamos hora y minuto random
            hRnd = RND.nextInt(H_MAX - H_MIN + 1) + H_MIN;
            mRnd = RND.nextInt(M_MAX - M_MIN + 1) + M_MIN;

            //Calculamos tiempos
            tmpEnt = hEnt * 60 + mEnt;
            tmpRnd = hRnd * 60 + mRnd;
            minDis = tmpRnd - tmpEnt;
            //minutos

            // horas
            hourDis = minDis / 60;
            minDif = minDis % 60;

            //importe
            coste = minDis * TARIFA;

            System.out.println("---");
            System.out.printf("Momento entrada ....: %02d:%02dh - Manual%n", hEnt, mEnt);
            System.out.printf("Momento salida .....: %02d:%02dh - Aleatorio %n", hRnd, mRnd);
            System.out.println("---");
            System.out.printf("Tarifa .............: %.2f €/min %n", TARIFA);
            System.out.printf("Tiempo Facturado ...: %d minutos (%02dh + %02dm) %n", minDis, hourDis, minDif);

            //Math.abs para quitarle el signo a coste.
            //coste = Math.abs(coste);
            System.out.printf("Importe ............: %.2f €%n", coste);

        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta");
            //Borrar buffer
            SCN.nextLine();
        }

    }
}
