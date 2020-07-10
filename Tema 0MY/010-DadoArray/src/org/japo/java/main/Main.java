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
    //Inicio Random
    public static final Random RND = new Random();

    public static void main(final String[] args) {

        System.out.println("How many times should I roll the dice? ");
        int answer;
        try  {
            answer = SCN.nextInt();

            final int[] results = new int[11];
            for (int x = 0; x < answer; x++) {
                results[amount() - 2]++;
            }
            System.out.printf("Results for %s dice rolls ", answer);
            for (int i = 0; i < 11; i++) {
                System.out.printf("%s was rolled %s times %n", i + 2, results[i]);
            }
        } catch (Exception ex) {
            System.out.println("OPPPPS");
        }

    }

    public static int amount() {
        return RND.nextInt(6) + RND.nextInt(6) + 2;

    }

}
