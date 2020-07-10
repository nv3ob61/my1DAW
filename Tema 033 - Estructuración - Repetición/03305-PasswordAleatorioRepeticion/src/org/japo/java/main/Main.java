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

/**
 *
 * @author mon-mode
 */
public class Main {

    //Random final
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constantes
        final char LETRA_INI = 'A';
        final char LETRA_FIN = 'Z';
        final int NUMERO_LETRAS = 8;
        //Variable letra
        char letra;

        //Salida
        System.out.printf("Password ...: ");

        //Generamos contraseña aleatoria 8 char A-Z
        for (int i = 0; i < NUMERO_LETRAS; i++) {
            //Variable letra
            letra = (char) (RND.nextInt(LETRA_FIN - LETRA_INI + 1) + LETRA_INI);
            System.out.print(letra);
        }
        //Separador final del BUILD SUCCESSFUL...
        System.out.println();
    }
}
