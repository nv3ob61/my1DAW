/*
 * Copyright 2019 mon_mo.
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
package org.japo.java.app;

import java.util.Random;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final int NUM;
        //Dentro de este static generamos los valores random para NUM
    static {
        final Random RND = new Random();
        //Valores arbitrarios para el random
        final int NUM_MIN = -3;
        final int NUM_MAX = 14;

        NUM = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
    }
    public static final int MIN = 0;
    public static final int MAX = 10;

    public final void launchApp() {

        int valor;

        valor = analizarRango(NUM, MAX, MIN);
        salidaRango(NUM, MIN, MAX, valor);
    }

    public final int analizarRango(int num, int max, int min) {
        int valor = 0;

        if (num > max) {
            valor = 2;
        } else if (num < min) {
            valor = 1;
        }
        return valor;
    }
    
    public final void salidaRango(int num, int min, int max, int valor){
        System.out.println("ANÁLISIS DE RANGO");
        System.out.println("=================");
        System.out.printf("Número ......: %d%n", NUM);
        System.out.println("---");
        System.out.printf("Mínimo ......: %d%n", MIN);
        System.out.printf("Máximo ......: %d%n", MAX);
        System.out.println("---");
        
        switch (valor) {
            case 0:
                System.out.println("Análisis ....: DENTRO");
                break;
            case 1:
                System.out.println("Análisis ....: FUERA ( Abajo )");
                break;
            case 2:
                System.out.println("Análisis ....: FUERA ( Arriba )");
                break;
            default:
                break;
        }
    }
}
