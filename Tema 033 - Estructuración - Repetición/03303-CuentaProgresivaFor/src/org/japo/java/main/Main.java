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
        //Variable number inicializada con el primer número de salida
        int number = 0;

        //Salida con bucle for que se repite desde el 0, despreciando el 10.
        for (int i = 0; i < 10; i++) {
            System.out.println(number);
            //Actualización de la variable number
            number++;
        }
    }
}
