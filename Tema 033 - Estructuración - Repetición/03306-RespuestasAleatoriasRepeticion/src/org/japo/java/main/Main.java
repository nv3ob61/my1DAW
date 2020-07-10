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
        //Referencias
        boolean resultado;
        final int NUMERO_RESPUESTAS = 10;

        //Bucle for con las salidas.
        for (int i = 0; i < NUMERO_RESPUESTAS; i++) {
            resultado = RND.nextBoolean();
            System.out.printf("Respuesta %02d ...: %b%n", i + 1, resultado);
        }
    }
}
