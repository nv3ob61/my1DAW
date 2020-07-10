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
        // Declaramos constante
        final String SALUDO_CONSTANTE = "¡Hola Mundo!";
        
        //Added another different output 
        String saludoConstante;
        saludoConstante = "Hola";
        
        System.out.println(saludoConstante);
        
        //Esto es un simple ejemplo de lo que pasa si cambiamos el valor
        //de una variable una vez inicializado al principio del programa.
        
        //Con este saludoConstante el valor inicial que era Hola pasa a ser Adios
        saludoConstante = "Adios";
        

        // Mensaje. Imprime constante SALUDO_CONSTANTE
        // y el nuevo valor de saludoConstante
        
        System.out.println(SALUDO_CONSTANTE);
        System.out.println(saludoConstante);
        

        

    }
}
