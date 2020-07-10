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

public class Main {

    public static final Random RND = new Random();
    //Constantes
    public static final int COD_MAX = 46550;
    public static final int COD_MIN = 46450;

    public static void main(String[] args) {
        //Ponemos valores máximo al array para que no sea muy grande
        int totals[] = new int[46590];

        for (int index = COD_MIN; index < COD_MAX; index++) {
            totals[index] = 0;
        }
        //Van 100 mil clientes, más menos 1000 por población xD
        for (int roll = 1; roll <= 100000; roll++) {
            totals[generaCod()]++;
        }
        // FIN DEL PROGRAMA
        muestraSalida(totals);
    }

    public static int generaCod() {
        //Variables
        int codigo;
        //Generamos dato rango de 0 hasta 100, el local puede estar vacío.
        codigo = RND.nextInt(COD_MAX - COD_MIN + 1) + COD_MIN;
        return codigo;
    }

    public static void muestraSalida(int totals[]) {
        System.out.printf("%3s%12s%12s%n",
                "CodPostal", "Cientes", "   Porcentaje");
        System.out.println("----------------------------------");
        for (int i = COD_MIN; i <= COD_MAX; i++) {
            double percent = (double) totals[i] / 1000;
            System.out.printf("%3d\t%12d%12.02f%%%n", i, totals[i], percent);
        }
    }
}
