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

import java.util.Random;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Variable
        int dado1, dado2;
        int acum1 = 0;
        int acum2 = 0;
        for (int i = 0; i < 3; i++) {

            dado1 = RND.nextInt(6) + 1;
            dado2 = RND.nextInt(6) + 1;

            //Representamos los dados en pantalla.
            System.out.println("         *****     ");
            System.out.println("         * " + dado1 + " *   <- DADO Nº 1");
            System.out.println("         *****     ");
            System.out.println();
            System.out.println("         *****     ");
            System.out.println("         * " + dado2 + " *   <- DADO Nº 2");
            System.out.println("         *****     ");
            System.out.println();
            acum1 = acum1 + dado1;
            acum2 = acum2 + dado2;
        }

        System.out.printf("Suma dado 1...............: %d%n"
                + "Suma dado 2...............: %d%n", acum1, acum2);

        if (acum1 != acum2) {
            if (acum1 > acum2) {
                System.out.printf("Gana el...................: 1 %n%n");
            } else {
                System.out.printf("Gana el...................: 2 %n%n");
            }
            }else {
            System.out.println("..........Empatee..........");
        }

        }
    }
