/*
 * Copyright 2019 mon_mo.   0mon.mode@gmail.com
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
import java.util.Scanner;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesPrimitivos;

/**
 *
 * @author mon_mo
 */
public final class App {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    public static double valorA;
    public static double valorB;
    public static double valorC;

    public final void launchApp() {
        String respuesta;
        // Probados (3 -5  1)   (1  1  1)   (1  -4  4)  (1  4  0)  y (1  3  2)
        // (1  0 -1 Resultado: X1 = 1.0; X2 = -1.0);
        // Inicio del programa.
        muestraBanner();
        do {
            pideValores();
            UtilesPrimitivos.operarRaiz(valorA, valorB, valorC);
            respuesta = deseaCont();
        } while (respuesta.equals("S"));
    }

    public final void muestraBanner() {
        System.out.println("Dada la ecuación de 2º grado: Ax\u00b2 + Bx + C = 0");
        System.out.println("Introduce los valores para A, B y C:");
        System.out.println(UtilesPrimitivos.PACO_LONG);
    }

    public final void pideValores() {
        System.out.println("Introduce el valor de A:");
        valorA = UtilesEntrada.obtener();
        System.out.println("Introduce el valor de B:");
        valorB = UtilesEntrada.obtener();
        System.out.println("Introduce el valor de C:");
        valorC = UtilesEntrada.obtener();
    }

    public final String deseaCont() {
        String respuesta;
        //dowhile para introducir otra ecuación.
        do {
            System.out.print("¿Deseas continuar con otra ecuación? (S o N): ");
            respuesta = SCN.nextLine();
            respuesta = respuesta.toUpperCase();
        } while (!respuesta.equals("S") && !respuesta.equals("N"));
        return respuesta;
    }
}
