/*
 * Copyright 2019 mon_mode    0mon.mode@gmail.com
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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public class UtilesDNI {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final String PACO = "---";
    // Secuencia letras DNI
    public static final String SECUENCIA = "TRWAGMYFPDXBNJZSQVHLCKE";
    //Mensajes varios
    public static final String ERR_LEN = "PEIMM: Longitud no válida.";
    public static final String ERR_LET = "TUTUTUTU: DNI introducido no válido.";
    public static final String ERR_NIE = "AIII: NIE introducido no válido.";
    //longitud de las id's
    public static final int DNI_LEN = 9;
    //String que recoge el valor cuando el nie cambia la letra por el num.

    // Consola >> Texto  Controla también la salida con la Q
    public static final String obtener(String msgUsr) {
        boolean dniOk;
        String dni;
        do {
            System.out.print(msgUsr);
            dni = SCN.nextLine().toUpperCase();
            dniOk = UtilesDNI.validar(dni);
            //porque yo lo valgo.
        } while (!dniOk && !dni.equals("Q"));

        return dni;
    }

    //Al lío
    public static final boolean validar(String dni) {
        String str = "";
        //boolean de validación de la letra.
        boolean isValid = false;
        //boolean para los NIE
        boolean nieOk = dni.startsWith("X")
                || dni.startsWith("Y") || (dni.startsWith("Z"));

        //Loop principal. Si la longitud es diferente a la constante DNI_LEN
        if (dni.length() != DNI_LEN) {
            //y su hemos elegido la opción de salir deja un mensaje en blanco
            if (dni.equals("Q")) {
                //mensaje en blancoo o o oooo . . ... ..
            } else {
                //Salida por defecto al error de longitud
                System.out.println(PACO);
                System.out.println(ERR_LEN);
                System.out.println(PACO);
            }
        } else {
            //VALIDAMOS NIE, primero cambiamos el valor de la letra.
            if (nieOk) {
                //Si empieza por X, cambiar el primer valor por un 0 y pa alante.
                //lo mismo para Y y Z. Acabar
                if (dni.startsWith("X")) {
                    str = dni.substring(0, 0)
                            + "0"
                            + dni.substring(1, 8);
                } else if (dni.startsWith("Y")) {
                    str = dni.substring(0, 0)
                            + "1"
                            + dni.substring(1, 8);
                } else if (dni.startsWith("Z")) {
                    str = dni.substring(0, 0)
                            + "2"
                            + dni.substring(1, 8);
                }

                isValid = validar(str, dni, isValid, ERR_NIE);
                //ESTE ES EL ELSE para condiciones de DNI. 
            } else {
                isValid = validar(str, dni, isValid, ERR_LET);
            }
        }
        //Retorna isValid que definirá la salida en el método muestraSalida()
        return isValid;
    }

    public static boolean validar(String str, String dni, boolean isValid, String error) {
        int numDniInt = 0;
        //El mogollón para que compruebe si cada char del NIE es dígito.
        //Empieza en charAt(1) para leer correctamente el formato..
        boolean checkNIE = Character.isDigit(dni.charAt(1))
                && Character.isDigit(dni.charAt(2))
                && Character.isDigit(dni.charAt(3))
                && Character.isDigit(dni.charAt(4))
                && Character.isDigit(dni.charAt(5))
                && Character.isDigit(dni.charAt(6))
                && Character.isDigit(dni.charAt(7));

        //El mogollón para que compruebe si cada char del DNI es dígito.
        boolean checkDNI = Character.isDigit(dni.charAt(0))
                && Character.isDigit(dni.charAt(1))
                && Character.isDigit(dni.charAt(2))
                && Character.isDigit(dni.charAt(3))
                && Character.isDigit(dni.charAt(4))
                && Character.isDigit(dni.charAt(5))
                && Character.isDigit(dni.charAt(6))
                && Character.isDigit(dni.charAt(7));

        //Para el NIE
        if (dni.startsWith("X") || dni.startsWith("Y") || dni.startsWith("Z")) {
            // Si se cumple la cond. de validar todos los dígitos hace el parse
            if (checkNIE) {
                numDniInt = Integer.parseInt(str);
            }
            //Sino no pasa nada y salta al DNI, lo mismo que checkNIE...
        } else if (checkDNI) {
            numDniInt = Integer.parseInt(dni.substring(0, 8));
        }

        //con el int ya podemos calcular el módulo
        int modulo = numDniInt % 23;
        //buscamos en el "array" de letras la que corresponde con nuestro int
        char letra = SECUENCIA.charAt(modulo);
        //Comprueba si la letra coincide con la del usuario
        if (letra == dni.charAt(dni.length() - 1)) {
            isValid = true;
        } else {
            System.out.println(PACO);
            System.out.println(error);
            System.out.println(PACO);
        }
        return isValid;
    }

}
