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
        //Definimos constantes
        final String NOMBRE = "Marta";
        final String ARTICULO = "Pulsera hippy";
        final double PAGA = 1.00;
        final double PRECIO_ART = 0.70;
        
        //Variamos un poco entre printf y println.
        System.out.println("Secuencia de Pulsera");
        System.out.println("====================");
        System.out.printf("Nombre de la niña ...: %s%n", NOMBRE);
        System.out.println("Dinero inicial ......: " + PAGA + " €");
        System.out.println("---");
        System.out.println("Artículo a comprar ..: " + ARTICULO);
        System.out.printf("Precio artículo .....: %.2f €%n", PRECIO_ART);
        System.out.println("---");
        System.out.printf("Dinero restante .....: %.2f €%n", PAGA - PRECIO_ART);
        
    }
}
