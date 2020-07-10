/*
 * Copyright 2016 José A. Pacheco Ondoño - joanpaon@gmail.com.
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
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesDNI {

    // Secuencia letras DNI
    public static final String SECUENCIA = "TRWAGMYFPDXBNJZSQVHLCKE";

    // Limites Número DNI
    public static final int NUM_MIN = 10000000;
    public static final int NUM_MAX = 99999999;

    // Número Caracteres DNI
    public static final int DNI_LEN = 9;

    // Calcular Control de DNI
    public static final char calcular(int num) {
        return SECUENCIA.charAt(num % SECUENCIA.length());
    }

    // Validar DNI ( Número + Control )
    public static final boolean validar(int num, char ctr) {
        return validar(num) && validar(ctr) && calcular(num) == ctr;
    }

    // Validar Número DNI
    public static final boolean validar(int num) {
        return num >= NUM_MIN && num <= NUM_MAX;
    }

    // Validar Control DNI
    public static final boolean validar(char ctr) {
        boolean testOK = false;
        for (int i = 0; i < SECUENCIA.length(); i++) {
            if (SECUENCIA.charAt(i) == ctr) {
                testOK = true;
            }
        }
        return testOK;
    }

    // Validar DNI ( String )
    public static final boolean validar(String dni) {
        // Semáforo
        boolean dniOK = true;

        // valuación
        if (dni.length() != DNI_LEN) {
            dniOK = false;
        } else if (!validar(dni.charAt(DNI_LEN - 1))) {
            dniOK = false;
//        } else if (dni.charAt(0) == 'X'
//                || dni.charAt(0) == 'Y'
//                || dni.charAt(0) == 'Z'
//                || dni.charAt(0) >= '0'
//                && dni.charAt(0) <= '9') {
        } else if (!"XYZ123456789".contains(dni.charAt(0) + "")) {
            dniOK = false;
//        } else if (dni.substring(1, DNI_LEN - 1).matches("\\d{7}") ) {
        } else if (!Character.isDigit(dni.charAt(1))
                && !Character.isDigit(dni.charAt(2))
                && !Character.isDigit(dni.charAt(3))
                && !Character.isDigit(dni.charAt(4))
                && !Character.isDigit(dni.charAt(5))
                && !Character.isDigit(dni.charAt(6))
                && !Character.isDigit(dni.charAt(7))) {
            dniOK = false;
        } else {
            int num = extraerNumero(dni);
            char ctr = dni.charAt(DNI_LEN - 1);
            
            dniOK = validar(num, ctr);
        }

        return dniOK;
    }

    public static final int extraerNumero(String dni) {
        // Referencias
        final int BAD_VALUE = -1;

        // Extraer Parte numérica
        int num;

        // Transforma Digito 1
        switch (dni.charAt(0)) {
            case 'X':
                dni = "0" + dni.substring(1);
                break;
            case 'Y':
                dni = "1" + dni.substring(1);
                break;
            case 'Z':
                dni = "2" + dni.substring(1);
        }
        try {
            num = Integer.parseInt(dni.substring(0, DNI_LEN - 1));
        } catch (NumberFormatException e) {
            num = BAD_VALUE;
        }

        return num;
    }
}
