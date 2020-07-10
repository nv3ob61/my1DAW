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

    public static void main(String[] args) {
        //Variables
        int opcion = 0;

        boolean isOk = true;
        
        int contador = 0;
        int tallaS = 0;
        int tallaL = 0;
        int tallaXXL = 0;

        //muestraBanner();  
        System.out.printf("%n..........MENÚ PRINCIPAL......... %n%n");

        //Bucle externo para que acabe con un valor válido y no se rompa el progr.
        do {
            do {
                try {
                    System.out.println("Introduzca talla camiseta:");
                    System.out.printf("   1  ...Talla S..... %n");
                    System.out.printf("   2  ...Talla L..... %n");
                    System.out.printf("   3  ...Talla XXL... %n");
                    System.out.printf("   0  ..... FIN .....%n%n");

                    System.out.printf("Elije una opción del 1 al 3. (0 para salir): ");
                    opcion = SCN.nextInt();

                    //Si el dato introducido es bueno, sale del loop
                    isOk = false;
                    
                    switch (opcion) {
                        case 1:
                            System.out.printf("%nCamiseta S añadida%n%n");
                            tallaS++;
                            contador++;
                            break;
                        case 2:
                            System.out.printf("%nCamiseta L añadida%n%n");
                            tallaL++;
                            contador++;
                            break;
                        case 3:
                            System.out.printf("%nCamiseta XXL añadida%n%n");
                            tallaXXL++;
                            contador++;
                            break;
                        case 0:
                            System.out.printf("%nGracias por utilizar el programa%n");
                            break;
                        default:
                            System.out.printf("%nERROR: Opción incorrecta%n");
                            break;
                    }
                } catch (Exception e) {
                    System.out.printf("%n**** ERROR: Valor introducido incorrecto "
                            + "****%n%n");
                } finally {
                    //borra el buffer, si no entra en bucle sin fin.
                    SCN.nextLine();
                }
            } while (isOk);
        } while (opcion != 0);
        
        //Salida fuera del bucle, falta apañar!
        System.out.println("Total camisetas ... " + contador);
        System.out.println("Total talla S ....: " + tallaS);
        System.out.println("Total talla L ....: " + tallaL);
        System.out.println("Total talla XXL ..: " + tallaXXL);
    }
}
