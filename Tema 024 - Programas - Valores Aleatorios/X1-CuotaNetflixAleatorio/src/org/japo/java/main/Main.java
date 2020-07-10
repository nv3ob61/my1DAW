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
        final double CUOTA = 30;

        //Variable
        double amigo1;
        double amigo2;

        /*Solo hay que sacar lo que paga el primer amigo. El segundo es la
        resta con la CUOTA */
        amigo1 = RND.nextDouble() * (30 - 0) + 0;
        amigo2 = CUOTA - amigo1;

        //Dato de salida
        System.out.printf("Cuota Netflix.....: %.2f euros %n", CUOTA);
        System.out.printf("Amigo 1 paga......: %.2f euros %n", amigo1);
        System.out.printf("Amigo 2 paga......: %.2f euros %n", amigo2);

    }
}
