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
        /* Definimos constantes... ¿Por qué no crear una clase Animal   :j ? 
        
        Usamos el método "substring​(int beginIndex, int endIndex)" de
        la clase String en lugar de crear uno diferente para cada animal.
        */
        final String ANIMALES = "Vaca, Oveja, Burro, Gallina";
        final int BIPED = 2;
        final int CUADRUPED = 4;
        
        //variable
        int totalVaca = 3;
        int totalOveja = 14;
        int totalBurro = 2;
        int totalGallina = 18;
        int totalPatas;
        int totalPares;
        
        totalPatas = (totalVaca + totalOveja + totalBurro) * CUADRUPED +
                totalGallina * BIPED;
        
        totalPares = totalPatas / 2;
        
        //Salida consola
        System.out.println("Secuencia de Patas");
        System.out.printf("==================%n");
        
        //longitud del string  System.out.println(ANIMALES.length());
        //Vaca  substring (0-4)
        System.out.printf("Animal ..........: %s %n", ANIMALES.substring(0, 4));
        System.out.printf("Cantidad ........: %d%n", totalVaca);
        System.out.printf("Patas ............ %d%n", totalVaca * CUADRUPED);
        System.out.printf("---%n");
        
        //Oveja  substring (6-11)
        System.out.printf("Animal ..........: %s %n", ANIMALES.substring(6, 11));
        System.out.printf("Cantidad ........: %d%n", totalOveja);
        System.out.printf("Patas ...........: %d%n", totalOveja * CUADRUPED);
        System.out.printf("---%n");
        
        //Burro  substring (13-18)
        System.out.printf("Animal ..........: %s %n", ANIMALES.substring(13, 18));
        System.out.printf("Cantidad ........: %d%n", totalBurro);
        System.out.printf("Patas ............ %d%n", totalBurro * CUADRUPED);
        System.out.printf("---%n");
        
        //Gallina  substring (20-27)
        System.out.printf("Animal ..........: %s %n", ANIMALES.substring(20, 27));
        System.out.printf("Cantidad ........: %d%n", totalGallina);
        System.out.printf("Patas ...........: %d%n", totalGallina * BIPED);
        System.out.printf("---%n");
        
        //Total 
        System.out.printf("Total de Patas ..: %d%n", totalPatas);
        System.out.printf("Total de Pares ..: %d%n", totalPares);
        
    }
}
