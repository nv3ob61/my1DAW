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
        //Constante del año. Modificamos el ejercicio y añadimos MSG
        final int ANY_LLEGADA_LUNA = 1969;
        final String MSG = "El Hombre llegó a la Luna en ";
        
        // Mensaje   %d (usando un entero con printf)   %n para siguiente línea
        System.out.printf("El hombre llegó a la Luna en %d.%n", + ANY_LLEGADA_LUNA);
        
        //Forma alternativa, con dos constantes
        System.out.println(MSG + ANY_LLEGADA_LUNA + ".");
        
    }
}
