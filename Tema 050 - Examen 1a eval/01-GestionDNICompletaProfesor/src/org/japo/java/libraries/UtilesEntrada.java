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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesEntrada {

    // Objeto Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    // Teclado > Número
    public static final double obtenerNumero(String msgUsr, String msgErr) {
        // Dato a introducir
        int dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextInt();

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            } finally {
                SCN.nextLine();
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Teclado > Número [min..max]
    public static final double obtenerNumero(String msgUsr, String msgErr,
            double min, double max) {
        // Número a devolver
        double dato;

        // Semáforo validación
        boolean rangoOK;

        // Bucle Validacion
        do {
            // Introducir Número
            dato = UtilesEntrada.obtenerNumero(msgUsr, msgErr);

            // Validar Número
            rangoOK = dato >= min && dato <= max;

            // Mensaje de error
            if (!rangoOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!rangoOK);

        // Devolver número
        return dato;
    }

    // Teclado > Caracter
    public static final char obtenerCaracter(String msgUsr, String msgErr) {
        // Dato a introducir
        char dato = 0;

        // Proceso de lectura
        boolean lecturaOK = false;
        do {
            try {
                // Entrada dato
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);

                // Marca el semáforo
                lecturaOK = true;
            } catch (Exception e) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!lecturaOK);

        // Devolver dato
        return dato;
    }

    // Teclado > Número DNI
    public static final int obtenerNumDNI(String msgUsr, String msgErr) {
        return (int) obtenerNumero(msgUsr, msgErr, UtilesDNI.NUM_MIN, UtilesDNI.NUM_MAX);
    }

    // Teclado > DNI ( Número + Control )
    public static final String obtenerDNI(String msgNum, String msgCtr, String msgErr) {
        // Variables 
        int num;
        char ctr;

        // Proceso de entrada
        boolean dniOK;

        do {
            // Componentes del DNI
            num = obtenerNumDNI(msgNum, msgErr);
            ctr = obtenerCaracter(msgCtr, msgErr);

            // Valida DNI
            dniOK = UtilesDNI.validar(num, ctr);

            // DNI Erróneo
            if (!dniOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dniOK);

        // Devolver dato
        return "" + num + ctr;
    }

    // Teclado > DNI ( String )
    public static final String obtenerDNI(String msgUsr, String msgErr) {
        // Variables 
        String dni;

        // Proceso de entrada
        boolean dniOK;

        do {
            // Consola > DNI
            System.out.print(msgUsr);
            dni = SCN.nextLine();

            // Valida DNI
            dniOK = UtilesDNI.validar(dni);

            // DNI Erróneo
            if (!dniOK) {
                System.out.println("---");
                System.out.println(msgErr);
                System.out.println("---");
            }
        } while (!dniOK);

        // Devolver dato
        return dni;
    }
}
