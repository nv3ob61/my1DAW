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

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        //Constantes
        final String NOMBRE = "Ruperta";
        final int TOTAL_CANICAS = 5;

        /* Decido que las canicas finales sea variable ya que es puntual que a 
        Rigoberto le saliera un agujero en el pantalón ese día. */
        int canicasFinal = 1;

        //Salida
        System.out.printf("Secuencia de Canicas%n");
        System.out.printf("====================%n");
        System.out.printf("Nombre de la canica ........: %s%n", NOMBRE);
        System.out.printf("---%n");
        System.out.printf("Número de canicas inicial ..: %d%n", TOTAL_CANICAS);
        System.out.printf("Número de canicas final ....: %d%n", canicasFinal);
        System.out.printf("---%n");
        System.out.printf("Número de canicas perdidas .: %d%n",
                TOTAL_CANICAS - canicasFinal);
    }
}
