/*
 * Copyright 2019 nv3ob61.   0mon.mode@gmail.com
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
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public class Main {

    public static final String MSG_FIN = "Gracias por utilizar el programa";
    public static final String MSG_OPCION = "ERROR: Opción incorrecta.";
    public static final String PACO = "---";
    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        int opcion;
        boolean sw = false;

        //Inicio del programa main
        muestraBanner();
        while (!sw) {
            muestraOpciones();
            opcion = pideOpciones();
            switch (opcion) {
                case 1:
                    System.out.println("Opción 1: Contar palabras");
                    contarPalabras();
                    System.out.println(PACO);
                    break;
                case 2:
                    System.out.println(PACO);
                    System.out.println("Mensaje salida OPCIÓN 2");
                    System.out.println(PACO);
                    break;
                case 3:
                    System.out.println(PACO);
                    sw = salir();
                    System.out.println(PACO);
                    break;
                default:
                    System.out.println(MSG_OPCION);
                    break;
            }
        }
        System.out.println(MSG_FIN);
    }

    public static final void muestraBanner() {
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t Programa que hace cosas");
        System.out.printf("-----------------------------------------------------%n%n");
    }

    public static final void muestraOpciones() {
        System.out.printf("%n..........MENÚ PRINCIPAL.........: %n%n");
        System.out.printf(" 1................................: %n");
        System.out.printf(" 2................................: %n");
        System.out.printf(" 3................................: %n%n");
        System.out.printf("4. opciónvacia.............: %n");
        System.out.printf("5. opciónvacia.............: %n");
        System.out.printf("6. opciónvacia.............: %n%n");
        System.out.printf("0. FIN.%n%n");
    }

    public static final int pideOpciones() {
        int num;

        System.out.printf("Elije una opción del 1 al 3. (0 para salir): ");
        num = SCN.nextInt();

        return num;
    }

    public static final void contarPalabras() {
        String cadena;
        char car;
        int cont, total = 0;
        //Preguntar por qué tengo que instanciar un Scanner ahora, no acepta el 
        //SCN de toda la vida a pesar de ser static final. ¿Qué pasa aquí?
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe una cadena de caracteres: ");
        cadena = entrada.nextLine();
        
        if (cadena.length() > 0) {
            total = 1;
        }
        
        for (cont = 0; cont < cadena.length(); cont++) {
            car = cadena.charAt(cont);

            if (car == ' ') {
                total = total + 1;
            }
        }
        System.out.println("La cadena tiene " + total + " palabras.");
    }

    public static final boolean salir() {
        boolean sw = false;
        System.out.println("\n¿Desea realizar otro ejercicio s/n ?");
        char salida = SCN.next().charAt(0);

        if (salida == 'n' || salida == 'N') {
            sw = true;
        }
        return sw;
    }
}
