/* 
 * Copyright 2019 mon_mode  - 0mon.mode@gmail.com
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
package org.japo.java.libraries;

/**
 *
 * @author mon_mo
 */
public class UtilesDNI {

    public static final String PACO = "---";

    // Secuencia letras DNI
    public static final String SECUENCIA = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static final int DNI_MINCHAR = 1;
    public static final int DNI_MAXCHAR = 8;
    public static final int NUM_MIN = 10000000;
    public static final int NUM_MAX = 99999999;

    // Calcula letra a partir del número de DNI
    public static final char calcular(int dni) {
        return SECUENCIA.charAt(dni % SECUENCIA.length());
    }

    //Método que valida la long del DNI.
    public static final boolean validar(int num) {
        return num <= DNI_MAXCHAR
                && num >= DNI_MINCHAR;
    }

    //método que valida que la letra está en la secuencia
    public static final boolean validar(char ctr) {
        boolean testOk = false;

        for (int i = 0; i < SECUENCIA.length(); i++) {
            if (SECUENCIA.charAt(i) == ctr) {
                testOk = true;
            }
        }
        return testOk;
    }

    //métdo que pasa un boolean si el DNI es correcto (en número y letra)
    public static final boolean validar(int num, char ctr) {
        return calcular(num) == ctr;
    }
}
