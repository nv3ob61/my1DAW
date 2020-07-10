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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mon-mode
 */
public class Main {
// A falta de pan, bueno es un Buffered... Una opción para solucionar el prob
// de los acentos con el Scanner. Sacamos el tanque a pasear.

    public static final BufferedReader BUF = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final String NOMBRE_AMO = "Sócrates";
        final String MSG_SI = "¡Ave César!";
        final String MSG_NO = "¡Sócrates Socorro!";

        String nombrePersona, mensajeLoro;

        //Cabecera
        System.out.println("Alternativa Loro");
        System.out.println("----------------");

        //Introduce la persona que se acerca
        System.out.printf("Persona que se acerca ..: ");
        nombrePersona = BUF.readLine();
        System.out.println("---");

        //Analiza la persona que se acerca
        if (nombrePersona.equals(NOMBRE_AMO)) {
            mensajeLoro = MSG_SI;
        } else {
            mensajeLoro = MSG_NO;
        }
        
        //Salida
        System.out.printf("Dueño del loro .........: %s%n", NOMBRE_AMO);
        System.out.println("---");
        System.out.println("Mensaje Loro ...........: " + mensajeLoro);
    }
}
