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

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon-mode
 */
public class Main {
// Instanciar Scanner

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

//Inicio Random
    public static final Random RND = new Random();

    public static void main(String[] args) {
        //Constante para los dados
        final int MIN_DADO = 1;
        final int MAX_DADO = 6;

        int numTiradas;
        int numero;
        int dadoUno;
        int dadoDos;
        int sumaDados;
        int contador = 0;
        double porcentSiete;
        boolean isOk = true;

        //Bucle centinela? para el control de la entrada de enteros.
        do {
            try {
                //Entrada de datos
                System.out.printf("Introduce las veces que quieres tirar los dados"
                        + " ........: ");
                numTiradas = SCN.nextInt();
                    do {
                    System.out.println("Número a adivinar: ");
                        numero = SCN.nextInt();
                    } while (numero>12 || numero < 2);

                //Si el dato introducido es bueno, sale del loop
                isOk = false;

                for (int i = 0; i < numTiradas; i++) {
                    dadoUno = RND.nextInt(MAX_DADO - MIN_DADO + 1) + MIN_DADO;
                    dadoDos = RND.nextInt(MAX_DADO - MIN_DADO + 1) + MIN_DADO;
                    sumaDados = dadoUno + dadoDos;

//                  Test de los valores de los dados 
//                  System.out.println(dadoUno);
//                  System.out.println(dadoDos);
                    System.out.printf("%nTotal dados de la tirada %02d : %d%n",
                            i + 1, sumaDados);
                    

                    if (sumaDados == numero) {
                        contador++;
                    }
                }
                porcentSiete = 100 * contador / numTiradas;

                //Valores de salida, mostramos la cantidad de veces que saca el 7
                System.out.printf("---------------------------------------%n");
                System.out.println("ESTADÍSTICAS: ");
                System.out.printf("%nVeces que los dados suman %d ...: %d de %d %n",
                        numero, contador, numTiradas);
                System.out.printf("Tanto %% de tiradas resultado %d : %.2f%% %n%n",
                        numero, porcentSiete);

            } catch (Exception e) {
                System.out.println("ERROR: Valor introducido incorrecto");
            } finally {
                //borra el buffer, si no entra en bucle sin fin.
                SCN.nextLine();
            }
        } while (isOk);
    }
}
