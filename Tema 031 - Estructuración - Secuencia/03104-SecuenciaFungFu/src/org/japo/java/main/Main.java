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
        //Constantes
        final double P_ENTRADA = 1.30;
        final double P_PALOMITAS = 0.90;
     
        //Variables        
        double dineroInicial = 2;
        double numPersonas = 2;
        double partePalomitas;
        double dineroRestante;
        double gastosPersona;
        
        //Hacemos las operaciones aquí.
        partePalomitas = P_PALOMITAS / numPersonas;
        gastosPersona = P_ENTRADA + partePalomitas;
        dineroRestante = dineroInicial - gastosPersona;
        
        //Salida
        System.out.printf("Secuencia de Kung-Fu%n");
        System.out.printf("====================%n");
        System.out.printf("Dinero inicial .....: %.2f € %n", dineroInicial);
        System.out.printf("---%n");
        System.out.printf("Precio Película ....: %.2f € %n", P_ENTRADA);
        System.out.printf("Parte palomitas ....: %.2f € %n", partePalomitas);
        System.out.printf("---%n");
        System.out.printf("Gastos por persona .: %.2f € %n", gastosPersona);
        System.out.printf("---%n");
        System.out.printf("Dimero restante ....: %.2f €%n", dineroRestante);
    }
}
