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
        // Variables y constantes
        final int BOLSA = 100;
        final double IMPORTE_BOLSA = 5;
        final double IMPORTE_SUELTOS = 0.07;
        final double IVA = 21;
        int caramelos;
        int bolsasCompletas;
        int caramelosSueltos;
        double importeTotal, importeSueltos, importePrevio, importePVP;
        double ivaTotal;

        System.out.printf("CARAMELOS PARA BAUTIZOS%n");
        System.out.printf("=======================%n%n");
        System.out.printf("Cantidad de caramelos ...: ");

        try {
            caramelos = SCN.nextInt();
            //metemos aquí el borrado del buffer ya que solo tenemos una entrada
            SCN.nextLine();
            
            //Desglose de los caramelos
            bolsasCompletas = caramelos / BOLSA;
            caramelosSueltos = caramelos % BOLSA;

            System.out.printf("Bolsas completas.........: %d %n", bolsasCompletas);
            System.out.printf("Caramelos sueltos........: %d %n%n", caramelosSueltos);
            
            //Importes de los caramelos
            importeTotal = bolsasCompletas * IMPORTE_BOLSA;
            importeSueltos = caramelosSueltos * IMPORTE_SUELTOS;
            System.out.printf(Locale.ENGLISH, "Importe bolsas ..........: %.2f € %n", importeTotal);
            System.out.printf(Locale.ENGLISH, "Importe suelto ..........: %.2f € %n%n", importeSueltos);
            
            // Sumamos para el importe total de bolsas y sueltos
            importePrevio = importeTotal + importeSueltos;
            System.out.printf(Locale.ENGLISH, "Importe previo...........: %.2f € %n", importePrevio);
            
            //Calculamos el IVA con la constante definida
            ivaTotal = importePrevio * IVA / 100;
            System.out.printf(Locale.ENGLISH, "IVA  ( 21 %% )............: %.2f € %n%n", ivaTotal);
            
            //Total PVP
            importePVP = importePrevio + ivaTotal;
            System.out.printf(Locale.ENGLISH, "Importe PVP .............: %.2f €%n", importePVP);

        } catch (Exception e) {
            System.out.println("Entrada errónea");
        }

    }
}
