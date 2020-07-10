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

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final Scanner SCN = new Scanner(System.in, "Windows-1252");
  public static final Random RND = new Random();
  public static final int NUM_STR = 5;

  public final void launchApp() {

    final String[] lista = {"Paco", "Mer", "Antonio", "Lu", "María"};

    try {
      System.out.println("Buscar el String: ");
      String target = SCN.nextLine();

      for (int i = 0; i < lista.length; i++) {
        System.out.printf("Nombre %d ...: %s%n", i + 1, lista[i]);
      }

      //Buscar el String
      boolean testOk = false;
      int posicion = -1;
      for (int i = 0; i < lista.length; i++) {
        if (lista[i].equals(target)) {
          testOk = true;
          posicion = i;
          i = lista.length;
        }
      }
      //separador

      System.out.printf("%n---%n");

      //Resultado de la bísqueda
      if (testOk == true) {
        System.out.printf("Nombre .....: %s - ENCONTRADO - Pos: %d%n",
                target, posicion + 1);
      } else {
        System.out.printf("Nombre .....: %s - NO ENCONTRADO%n",
                target);
      }

    } catch (Exception e) {
      System.out.println("ERROR: Entrada incorrecta");
    }

  }
}
