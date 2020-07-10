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

    // Probamos como CONSTANTES ARBITRARIAS: núm 10 y letra X     :J
    public static final String DNI_NUM = "10";
    public static char DNI_CTR = 'Z';

    public final void launchApp() {
        //Variable boolean que recibirá del método validar();
        boolean isValid;
        //Inicio del programa
        try {
            muestraBanner();
            isValid = validar(DNI_NUM, LETRAS, DNI_CTR);
            muestraSalida(DNI_NUM, DNI_CTR, isValid);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Datos introducidos erróneos");
        }
    }

    public final void muestraBanner() {
        System.out.println("VALIDACIÓN DE DNI");
        System.out.println("-----------------");
    }

    public final boolean validar(String DNI_NUM, String LETRAS, char DNI_CTR) {
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
        
        //Generador del valor del boolean si letra == DNI_CTR
        if (letra == DNI_CTR) {
            isValid = true;
        }
        //Retorna isValid que definirá la salida en el método muestraSalida()
        return isValid;
    }

    public final void muestraSalida(String DNI_NUM, char DNI_CTR, boolean isValid) {
        //Salida del sistema...
        System.out.printf("DNI ......: %s%C%n", DNI_NUM, DNI_CTR);
        System.out.println("---");
        if (isValid == true) {
            System.out.println("Validez ..: Correcto");
        } else {
            System.out.println("Validez ..: Incorrecto");
        }
    }
}
