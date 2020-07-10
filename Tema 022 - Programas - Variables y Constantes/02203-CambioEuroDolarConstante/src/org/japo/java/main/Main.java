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

        final double CAMBIO_EURO_DOLAR = 1.10925;
        
        /*Mensaje: Ponemos 08 para sacar 8 "espacios" en lo que displaya.
        si intentamos poner menos espacios, como 3, siempre va a sacar los
        mínimos que haya que mostrar*/
        
        System.out.printf("El cambio de hoy es 1€ por %08.2f$. "
                + "(Añadimos 4 ceros por la izquierda)%n%n", CAMBIO_EURO_DOLAR);
    }
}
