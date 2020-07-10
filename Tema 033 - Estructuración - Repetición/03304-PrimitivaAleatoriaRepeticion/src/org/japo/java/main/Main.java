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
        //Constantes aleatorias de la lotería
        final int LOTERIA_MIN = 1;
        final int LOTERIA_MAX = 49;
        final int NUM_BOLAS = 6;

        //Variables, inicializamos número de los números
        int numero = 1;
        int randomNum;

        //Demo cabecera FUERA del bucle.
        System.out.println("NÚMEROS ALEATORIOS DE LA PRIMITIVA");
        System.out.println("----------------------------------");

        //Ejecución del bucle, repetido 6 veces.
        for (int i = 0; i < NUM_BOLAS; i++) {
            //Hacemos el random dentro del bucle, cada vez diferente. ¿O no?
            randomNum = RND.nextInt(LOTERIA_MAX - LOTERIA_MIN + 1) + LOTERIA_MIN;
            //Salida para cada número o NUM_BOLAS
            System.out.printf("Número %d ...: %d%n", i + 1, randomNum);
        }
    }
}
