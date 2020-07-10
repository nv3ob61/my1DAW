/*
 * Copyright 2019 mon_mo.     0mon.mode@gmail.com
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

import static java.lang.Double.isNaN;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author mon_mo
 */
public final class App {

    public final static String USR_MSG = "Parametro %c...: ";
    public final static String ERR_MSG = "ERROR: Entrada incorrecta";

    public final void launchApp() {
        System.out.println("SOLUCIONES EQUACIONES 2º GRADO");
        System.out.println("==============================");
        System.out.println("---");
        System.out.println("ax\u00b2 + bx + c = 0");
        System.out.println("---");
        double a = UtilesEntrada.obtener(String.format(USR_MSG, 'a'), ERR_MSG);
        double b = UtilesEntrada.obtener(String.format(USR_MSG, 'b'), ERR_MSG);
        double c = UtilesEntrada.obtener(String.format(USR_MSG, 'c'), ERR_MSG);
        System.out.println("---");

        // OPERACIONES
        double x1;
        double x2;
        double r = Math.sqrt(b * b - 4 * a * c);
        if (isNaN(r)) {
            System.out.println("Solución imaginaria");
        } else {
            x1 = (-b + r) / 2 * a;
            x2 = (-b - r) / 2 * a;
            System.out.printf("Solucion 1....%2f%n", x1);
            System.out.printf("Solucion 2....%2f%n", x2);
        }
    }
}
