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
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    //Declaramos lista para usarla tras obtener el módulo.
    public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
    //Cambiamos la introducción del entero por un String, al convertirlo
    //a int lo validará si los 8 char son números. 
    // Gestionado en parseInt dentro del método validar();

    // Probamos como CONSTANTES ARBITRARIAS: núm "010" y letra 'X'     :J
    // también valida el formato "00000010"  (hasta 8 dígitos)
    public static final String DNI_NUM = "00000010";
    public static final int DNI_MINCHAR = 1;
    public static final int DNI_MAXCHAR = 8;
    public static char DNI_CTR = 'X';

    //Errores y Strings de salida
    public static final String MSG_DATOS = "ERROR: Datos introducidos erróneos.";
    public static final String MSG_DIGITOS = "ERROR: Núm de dígitos incorrecto.";
    public static final String MSG_OK = "Validez ..: Correcto";
    public static final String MSG_NO = "Validez ..: Incorrecto";
    public static final String MSG_INTRO = "VALIDACIÓN DE DNI";
    public static final String MSG_OUT = "DNI ......: ";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------";
    public static boolean dniComp;
    /* **********************************************************************
                            INICIO DEL POGRAMA
    ********************************************************************** */
    public final void launchApp() {
        //Variable boolean que recibirá del método validar();

        //Variable definida por las cnstantes del inicio del programa que
        //comprueba la longitud del String que forma el número (máximo de 8)
        dniComp = DNI_NUM.length() <= DNI_MAXCHAR
                && DNI_NUM.length() >= DNI_MINCHAR;

        //PRIMER MÉTODO
        muestraBanner();
        try {
            //Si es válido O si NO ES válido y el rango de digitos es ok
            if (validar() || !validar() && dniComp) {
                muestraSalida(validar());
            } else {
                System.out.println(MSG_DIGITOS);
            }
        } catch (NumberFormatException e) {
            System.out.println(MSG_DATOS);
        }
    }

    public final void muestraBanner() {
        System.out.println(MSG_INTRO);
        System.out.println(PACO_LONG);
    }

    public final boolean validar() {
        //MÉTODO que VALIDA que los 8 primeros char son dígitos además de 
        //comprobar que la letra correspondiente al módulo coincide con la 
        //del usuario.
        //variables para el cambio de String a núm, calcular el módulo y elegir
        //la posición de la letra que corresponde en LETRAS.
        int numDni;
        int modulo;
        char letra;
        //boolean de validación de la letra.
        boolean isValid = false;

        //Pasamos el número introducido COMO String a int (valida que es correcto)
        numDni = Integer.parseInt(DNI_NUM);
        //con el int ya podemos calcular el módulo
        modulo = numDni % 23;
        //buscamos en el "array" de letras la que corresponde con nuestro DNI
        letra = LETRAS.charAt(modulo);
        //Unica condición es si tiene 1 a 8 dígitos y las letras coinciden
        if (dniComp) {
            if (letra == DNI_CTR) {
                isValid = true;
            }
        }
        //Retorna isValid que definirá la salida en el método muestraSalida()
        return isValid;
    }

    public final void muestraSalida(boolean isValid) {
        //Salida del sistema...
        System.out.printf("%s%s%C%n", MSG_OUT, DNI_NUM, DNI_CTR);
        System.out.println(PACO);
        if (isValid == true) {
            System.out.println(MSG_OK);
        } else {
            System.out.println(MSG_NO);
        }
    }
}
