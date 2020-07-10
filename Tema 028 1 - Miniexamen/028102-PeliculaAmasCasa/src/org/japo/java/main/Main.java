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
        //Declaramos constantes y variables
        final int AFORO_MAX = 500;
        final int AFORO_MIN = 0;
        final int DIAS_SEMANA = 7;
        double aforo1, aforo2, aforo3, aforo4, aforo5, aforo6, aforo7;
        double aforoMedio, aforoTotal;

        System.out.printf("CINES DEL CENTRO COMERCIAL%n");
        System.out.printf("==========================%n%n");
        System.out.printf(" CONTROL DE AFORO SEMANAL %n");
        System.out.printf(" ------------------------ %n%n");

        //Calculamos los aforos diarios asignando un valor Random
        aforo1 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo2 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo3 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo4 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo5 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo6 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        aforo7 = RND.nextInt(AFORO_MAX - AFORO_MIN + 1) + AFORO_MIN;
        
        //salida sistema
        System.out.printf("Aforo día 1 ....:    %3.0f personas %n", aforo1);
        System.out.printf("Aforo día 2 ....:    %3.0f personas %n", aforo2);
        System.out.printf("Aforo día 3 ....:    %3.0f personas %n", aforo3);
        System.out.printf("Aforo día 4 ....:    %3.0f personas %n", aforo4);
        System.out.printf("Aforo día 5 ....:    %3.0f personas %n", aforo5);
        System.out.printf("Aforo día 6 ....:    %3.0f personas %n", aforo6);
        System.out.printf("Aforo día 7 ....:    %3.0f personas %n%n", aforo7);
        
        //Calculamos el aforo total
        aforoTotal = aforo1 + aforo2 + aforo3 + aforo4 + aforo5 + aforo6 + aforo7;
        System.out.printf("Aforo total ....:   %.0f personas %n%n", aforoTotal);
        
        //Media del aforo
        aforoMedio = aforoTotal / DIAS_SEMANA;
        System.out.printf("Aforo medio ....:    %.0f personas %n", aforoMedio);
        
    }
}
