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

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {
        final int LOTERIA_MIN = 1;
        final int LOTERIA_MAX = 49;
        final int NUM1 = 1;
        final int NUM2 = 2;
        final int NUM3 = 3;
        final int NUM4 = 4;
        final int NUM5 = 5;
        final int NUM6 = 6;

        int rndNum1, rndNum2, rndNum3, rndNum4, rndNum5, rndNum6;
        int usrNum1, usrNum2, usrNum3, usrNum4, usrNum5, usrNum6;
        int aciertos = 0;

        boolean equalsRnd;
        boolean equalsUsr = false;
        boolean rangoOk = false;
        boolean rango1Ok = false;

        //muestraBanner();
        System.out.println("NÚMEROS ALEATORIOS DE LA PRIMITIVA");
        System.out.println("----------------------------------");

//*******************************************************************************        
// GENERAMOS LOS 6 RANDOM DE LA LOTERIA TENIENDO EN CUENTA QUE SEAN DISTINTOS
//*******************************************************************************
        do {
            rndNum1 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            rndNum2 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            rndNum3 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            rndNum4 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            rndNum5 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            rndNum6 = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;

            equalsRnd = rndNum1 == rndNum2 || rndNum1 == rndNum3 || rndNum1 == rndNum4
                    || rndNum1 == rndNum5 || rndNum1 == rndNum6
                    || rndNum2 == rndNum3 || rndNum2 == rndNum4 || rndNum2 == rndNum5
                    || rndNum2 == rndNum6 || rndNum3 == rndNum4
                    || rndNum3 == rndNum5 || rndNum3 == rndNum6
                    || rndNum4 == rndNum5 || rndNum4 == rndNum6
                    || rndNum5 == rndNum6;

        } while (equalsRnd);

        System.out.printf("Número %d ...: %d%n", NUM1, rndNum1);
        System.out.printf("Número %d ...: %d%n", NUM2, rndNum2);
        System.out.printf("Número %d ...: %d%n", NUM3, rndNum3);
        System.out.printf("Número %d ...: %d%n", NUM4, rndNum4);
        System.out.printf("Número %d ...: %d%n", NUM5, rndNum5);
        System.out.printf("Número %d ...: %d%n", NUM6, rndNum6);
        System.out.println("---");

            do {
                System.out.printf("Introduzca su primer número ....: ");
                usrNum1 = SCN.nextInt();
                if (usrNum1 > 49 || usrNum1 < 1) {
                    System.out.println("Error rango no válido");
                    //Sería necesario el else aquí? o con otro if basta? THX!
                } else if (usrNum1 == rndNum1 || usrNum1 == rndNum2 || usrNum1 == rndNum3
                        || usrNum1 == rndNum4 || usrNum1 == rndNum5 || usrNum1 == rndNum6) {
                    aciertos++;
                }
            } while (rangoOk);

            do {
                System.out.printf("%nIntroduzca su segundo número .: ");
                usrNum2 = SCN.nextInt();
                if (usrNum2 > 49 || usrNum2 < 1 || usrNum2 == usrNum1) {
                    System.out.println("Error rango no válido");

                    //Sería necesario el else aquí? o con otro if basta? THX!
                } else if (usrNum2 == rndNum1 || usrNum2 == rndNum2 || usrNum2 == rndNum3
                        || usrNum2 == rndNum4 || usrNum2 == rndNum5 || usrNum2 == rndNum6) {
                    aciertos++;
                }
            } while (rangoOk);

            System.out.printf("%nIntroduzca su tercer número ..: ");
            usrNum3 = SCN.nextInt();
            if (usrNum3 == rndNum1 || usrNum3 == rndNum2 || usrNum3 == rndNum3
                    || usrNum3 == rndNum4 || usrNum3 == rndNum5 || usrNum3 == rndNum6) {
                aciertos++;
            }
            System.out.printf("%nIntroduzca su cuarto número ..: ");
            usrNum4 = SCN.nextInt();
            if (usrNum4 == rndNum1 || usrNum4 == rndNum2 || usrNum4 == rndNum3
                    || usrNum4 == rndNum4 || usrNum4 == rndNum5 || usrNum4 == rndNum6) {
                aciertos++;
            }
            System.out.printf("%nIntroduzca su quinto número ..: ");
            usrNum5 = SCN.nextInt();
            if (usrNum5 == rndNum1 || usrNum5 == rndNum2 || usrNum5 == rndNum3
                    || usrNum5 == rndNum4 || usrNum5 == rndNum5 || usrNum5 == rndNum6) {
                aciertos++;
            }
            System.out.printf("%nIntroduzca su sexto número  ..: ");
            usrNum6 = SCN.nextInt();
            if (usrNum6 == rndNum1 || usrNum6 == rndNum2 || usrNum6 == rndNum3
                    || usrNum6 == rndNum4 || usrNum6 == rndNum5 || usrNum6 == rndNum6) {
                aciertos++;
            }
            equalsUsr = usrNum1 == usrNum2 || usrNum1 == usrNum3 || usrNum1 == usrNum4
                    || usrNum1 == usrNum5 || usrNum1 == usrNum6
                    || usrNum2 == usrNum3 || usrNum2 == usrNum4 || usrNum2 == usrNum5
                    || usrNum2 == usrNum6 || usrNum3 == usrNum4
                    || usrNum3 == usrNum5 || usrNum3 == usrNum6
                    || usrNum4 == usrNum5 || usrNum4 == usrNum6
                    || usrNum5 == usrNum6;
        

        System.out.println("Núm aciertos: " + aciertos);
    }
}
