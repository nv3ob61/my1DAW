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
package org.japo.java.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class App {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    //Errores y Strings de salida
    public static final String MSG_DATOS = "ERROR: Datos introducidos erróneos.";
    public static final String MSG_DIGITOS = "ERROR: Núm de dígitos incorrecto.";
    public static final String MSG_INTRO = "Introduce la longitud de la contraseña: ";
    public static final String MSG_OUT = "DNI ......: ";
    public static final String PACO = "---";
    public static final String PACO_LONG = "-----------------";
    public static final int RND_MIN = 1;
    public static final int RND_MAX = 4;
    public static final int PASS_MIN = 4;
    public static final int NUM_MIN = 0;
    public static final int NUM_MAX = 9;
    public static final char LETRA_INI = 'a';
    public static final char LETRA_FIN = 'z';
    public static final char LETRA_MAY_INI = 'A';
    public static final char LETRA_MAY_FIN = 'Z';
    public static final String TOTAL = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPAS"
            + "DFGHJKLZXCVBNM1234567890!·$%&/()=?¿`´-.,;:_-";
    //Dec de la 33 a la 47
    public static final char CARAC_INI = '!';
    public static final char CARAC_FIN = '/';

    public final void launchApp() {
        //Variables
        int longitudMax;
        String shuffled;
        boolean isOk = false;
        //Concatenamos la generación de los 4 primeros valores con una
        //segunda secuencia random a partir del String TOTAL si la 
        //longitud de la contraseña es > 4

        //con lo obtenido volvemos a hacerlo random.
        do {
            try {
                do {
                    isOk = false;
                    longitudMax = pideLong();
                    isOk = true;
                } while (longitudMax < PASS_MIN);
                shuffled = shuffleString(randomGen().concat(randomGenExtra(
                        longitudMax - PASS_MIN)));
                //mensaje
                muestraSalida(shuffled);
            } catch (Exception e) {
                System.out.println(MSG_DATOS);
            } finally {
                SCN.nextLine();
            }
        } while (!isOk);
    }

    public final int pideLong() {
        int longitudMax;
        System.out.println(PACO_LONG);
        System.out.printf(MSG_INTRO);
        longitudMax = SCN.nextInt();
        return longitudMax;
    }

    public final String randomGen() {
        Random RND = new Random();
        //Generamos una minúscula, mayúscula, número y randomchar
        char letraMin = (char) (RND.nextInt(LETRA_FIN - LETRA_INI + 1) + LETRA_INI);
        char letraMays = (char) (RND.nextInt(LETRA_MAY_FIN - LETRA_MAY_INI + 1) + LETRA_MAY_INI);
        int numero = RND.nextInt(NUM_MAX - NUM_MIN + 1) + NUM_MIN;
        char rndChar = (char) (RND.nextInt(CARAC_FIN - CARAC_INI + 1) + CARAC_INI);

        //Aquí "pegamos" lo obtenido de los 4 valores aleatorios
        String pass = Character.toString(letraMin) + Character.toString(letraMays)
                + numero + Character.toString(rndChar);

        return pass;
    }

    //Método si el password es de más de 5 valores
    public final String randomGenExtra(int n) {
        StringBuilder outBuilder = new StringBuilder();

        //Genera el total de datos menos los cuatro iniciales.
        for (int i = 0; i < n; i++) {
            // Genera un número random entre 0  
            // y la longitud de la constante TOTAL
            int index = (int) (TOTAL.length() * Math.random());
            // y construye char a char el String final
            outBuilder.append(TOTAL.charAt(index));
        }
        return outBuilder.toString();
    }

    //Pasamos el String que ha capturado todo el pass para hacerlo random ya que
    //inicialmente se genera con los valores (May + Min + Num + Char) en las cuatro
    //primeras posiciones.
    public static final String shuffleString(String concatPass) {
        //Creamos una lista con los char
        List<Character> characters = new ArrayList<>();
        //Para cada posición la añade al array
        for (char c : concatPass.toCharArray()) {
            characters.add(c);
        }
        //Usamos aquí la utilidad Collections y el método shuffle para el random.
        Collections.shuffle(characters);
        //Objeto StringBuilder que nos permitirá reconstruir el String de nuevo.
        StringBuilder sb = new StringBuilder();
        characters.forEach((c) -> {
            sb.append(c);
        });
        String shuffled = sb.toString();
        return shuffled;
    }

    public final static void muestraSalida(String exit) {
        System.out.println(PACO);
        System.out.printf("La contraseña generada es: %s%n", exit);
        System.out.println(PACO_LONG);
    }
}
