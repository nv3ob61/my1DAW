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

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final Scanner SCN = new Scanner(System.in, "Windows-1252");
  public static final Random RND = new Random();
  public static final int NUM_DOUBLE = 5;
  public static final double PRECIO_MAX = 10.0;
  public static final double PRECIO_MIN = 0.0;

  public final void launchApp() {

    final double[] lista = new double[NUM_DOUBLE];
    DecimalFormat df = new DecimalFormat("#.##");
    
    //llenamos el array con valores reales y el formato de 2 decimales.
    for (int i = 0; i < lista.length; i++) {
      lista[i] = Double.valueOf(df.format(RND.nextDouble()* 
              (PRECIO_MAX - PRECIO_MIN) + PRECIO_MIN));
    }

    try {
      System.out.println("Buscar el precio: ");
      double target = SCN.nextDouble();

      for (int i = 0; i < lista.length; i++) {
        System.out.printf(Locale.ENGLISH, "Precio %d ...: %.2f€%n", 
                i + 1, lista[i]);
      }

      //Buscar el String
      boolean testOk = false;
      int posicion = -1;
      for (int i = 0; i < lista.length; i++) {
        if (lista[i] == (target)) {
          testOk = true;
          posicion = i;
          i = lista.length;
        }
      }
      //separador

      System.out.printf("%n---%n");

      //Resultado de la bísqueda
      if (testOk == true) {
        System.out.printf("Precio .....: %.2f - ENCONTRADO - Pos: %d%n",
                target, posicion + 1);
      } else {
        System.out.printf("Precio .....: %.2f - NO ENCONTRADO%n",
                target);
      }

    } catch (Exception e) {
      System.out.println("ERROR: Entrada incorrecta");
    }

  }
}
