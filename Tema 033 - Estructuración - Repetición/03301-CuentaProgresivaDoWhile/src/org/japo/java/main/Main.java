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

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        //Inicializamos variables.
        int numero = 0;
        
        //Ejecución del bucle
        do {
            //Salida
            System.out.println(numero);
            //Actualización de contadores
            numero++;
        } while (numero < 10);

        /*
        
        COMENTAMOS AQUÍ LA VERSIÓN DE CLASE.
          
        //Referencias
        final int CUENTA_INI = 0;
        final int CUENTA_FIN = 10;
        
        //Variables
        int i;
        
        //Inicializa
        i = CUENTA_INI;
        
        //Bucle
        do {
            //Salida
            System.out.println(i);
        
            //Actualización
            i++;
        
        } while(i< CUENTA_FIN);
        
         */
    }
}
