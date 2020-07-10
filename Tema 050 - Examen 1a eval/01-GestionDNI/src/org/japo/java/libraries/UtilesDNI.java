/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    // Calcula letra a partir del número de DNI
    public static final char calcular(int dni) {
        return SECUENCIA.charAt(dni % SECUENCIA.length());
    }

    public static final boolean validar(int num) {
        boolean numValid;
        numValid = num <= DNI_MAXCHAR
                && num >= DNI_MINCHAR;
        return numValid;
    }

    public static final boolean validar(int num, char ctr) {

        int modulo;
        char letra;
        //boolean de validación de la letra.
        boolean isValid = false;
        

        //con el int ya podemos calcular el módulo
        modulo = num % 23;
        //buscamos en el "array" de letras la que corresponde con nuestro DNI
        letra = SECUENCIA.charAt(modulo);
        //Unica condición es si tiene 1 a 8 dígitos y las letras coinciden

            if (letra == ctr) {
                isValid = true;
            }

        //Retorna isValid que definirá la salida en el método muestraSalida()
        return isValid;
    }
}
