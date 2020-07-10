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
        //Constantes
        final double MAX_ALTURA = 2.5;
        final double MIN_ALTURA = 0.5;

        //Variable
        double altura;

        /*Si no especificamos el rango muestra un double entre [0-1]
        // Plantilla
        altura = MIN + (MAX - MIN) * RND.nextDouble();   ó
        altura = RND.nextDouble() * (MAX - MIN) + MIN;
        //Ejemplos de lo mismo
        altura = 0.5 + (2.5 - 0.5) * RND.nextDouble();     ó
        altura = RND.nextDouble() * (2.5 - 0.5) + 0.5        */
        
        altura = MIN_ALTURA + (MAX_ALTURA - MIN_ALTURA) * RND.nextDouble();

        //Dato de salida
        System.out.printf("Altura aleatoria......: %.2f metros %n", altura);

    }
}
