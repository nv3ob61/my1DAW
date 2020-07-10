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
    //Inicio Random
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Variables
        int balance;
        double balanceDouble;

        //Generar datos aleatorios, el Math random genera valores entre 0 y 1
        balance = RND.nextInt();
        balanceDouble = Math.random();

        //Mensajes de salida, usamos Math.abs para que sean todos positivos.
        System.out.printf("Balance de circulación.........: %d%n", Math.abs(balance));
        //Para sacar un número de 0 a 9
        System.out.printf("Balance de circulación (max 10): %d%n", Math.abs(balance) % 10);
        // Quitamos los decimales al Math.random
        System.out.printf("Balance con Math.random........: %.0f%n", balanceDouble  * 1E10);

    }
}
