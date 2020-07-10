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

    //programa que suma los pares e impares separados desde el 100 al 200 (inclus)
    public static void main(String[] args) {
        final int NUM_MAX = 200;
        final int NUM_MIN = 100;
        int pares = 0;
        int impares = 0;

        for (int cont = NUM_MIN; cont <= NUM_MAX; cont++) {
            
            if (cont % 2 == 0) {
                pares += cont;
            } else {
                impares += cont;
            }
        }
            System.out.println("Contador pares " + pares);
            System.out.println("Contador impares " + impares);

        }
    }
