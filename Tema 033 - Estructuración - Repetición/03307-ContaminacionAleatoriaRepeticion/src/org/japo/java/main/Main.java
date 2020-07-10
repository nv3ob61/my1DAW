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
        //Constantes
        final int ESTA_MIN = 1;
        final int ESTA_MAX = 4;
        final double MIN_MICRO = 0;
        final double MAX_MICRO = 700;
        double gramos;
        //muestraBanner();
        System.out.println("Nivel de contaminación");
        System.out.println("----------------------");
        
        //Bucle para sacar las cuatro estaciones.
        for (int i = ESTA_MIN; i <= ESTA_MAX; i++) {
            //Random double para los microgramos.
            gramos = RND.nextDouble() * (MAX_MICRO - MIN_MICRO) - MIN_MICRO;
            //Salida
            System.out.printf("Estación %d ...: %6.2f mcg NO2%n", i, gramos);
        }
    }
}
