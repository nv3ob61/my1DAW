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

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import org.japo.java.libraries.UtilesPrimitivos;

/**
 *
 * @author mon_mo
 */
public final class App {

    //CONSTANTES DE CLASE, generadas a partir del siguiente static.
    public static final int N1;
    public static final int N2;
    public static final int OP;

    //Dentro de este static generamos los valores random para N1, N2, y OP.
    static {
        final Random RND = new Random();
        final int MIN = 1;
        final int MAX = 10;
        final int MIN_OP = 0;
        final int MAX_OP = 7;

        N1 = RND.nextInt(MAX - MIN + 1) + MIN;
        N2 = RND.nextInt(MAX - MIN + 1) + MIN;
        OP = RND.nextInt(MAX_OP - MIN_OP + 1) + MIN_OP;
    }


    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public final void launchApp() {
        double result;

        result = UtilesPrimitivos.operar(N1, N2, OP);
        mensajeSalida(N1, N2, result, OP);
    }

    public final void mensajeSalida(double n1, double n2, double result,
            int op) {
        //Definimos la salida de datos aquí para que complete la frase del 
        // resultado de la operación que hace dentro del switch para el formato:
        /* OPERACIÓN NUMÉRICA
        ==================
        Número 1 ....: 3
        Número 2 ....: 7
        ---
        El MAYOR es .: 7 */

        System.out.printf("%n------------------%n");
        System.out.println("OPERACIÓN NUMÉRICA");
        System.out.println("------------------");
        System.out.printf("Número 1 ....: %.0f%n", n1);
        System.out.printf("Número 2 ....: %.0f%n", n2);
        System.out.println("---");
        switch (op) {
            case UtilesPrimitivos.OP_SUM:
                System.out.printf("La SUMA es de: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_RES:
                System.out.printf("La RESTA es de: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_MUL:
                System.out.printf("El PRODUCTO es de: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_DIV:
                if (n2 == 0) {
                    System.out.printf("ERROR: división por 0%n");
                } else {
                    System.out.printf("El COCIENTE es: %.0f%n", result);
                }
                break;
            case UtilesPrimitivos.OP_MOD:
                System.out.printf("El RESTO es: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_MED:
                System.out.printf("La MEDIA es: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_MAY:
                System.out.printf("El MAYOR es: %.0f%n", result);
                break;
            case UtilesPrimitivos.OP_MEN:
                System.out.printf("El MENOR es: %.0f%n", result);
                break;
        }
        //Línea separadora del final.
        System.out.println("------------------");
        System.out.println("Gracias por utilizar el programa");
    }
}
