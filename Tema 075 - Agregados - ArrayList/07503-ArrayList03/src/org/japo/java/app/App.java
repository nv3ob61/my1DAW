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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {
    // hacemos array
    String[] nombres = {"Juanito", "Pakito", "Jorgito", "Pakito", "Jaimito"};

    //Pasamos array a lista
    List<String> listaNombres = Arrays.asList(nombres);

    //La lista la convertimos a un ArrayList
    ArrayList<String> lista = new ArrayList<>(listaNombres);

    //Define iterador
    Iterator<String> iter = lista.iterator();

    System.out.println("Sobrinos de Donald");
    System.out.println("==================");
    System.out.printf("Sobrinos ..: %d%n", lista.size());

    while (iter.hasNext()) {
      System.out.printf("Sobrino ...: %s%n", iter.next());
    }

    System.out.println("--------");

    //Redefinir iterador
    iter = lista.iterator();

    while (iter.hasNext()) {
      String elemento = iter.next();

      if (elemento.equals("Pakito")) {
        iter.remove();
      }
    }
    //Redefinir iterador
    iter = lista.iterator();

    System.out.printf("Sobrinos ..: %d%n", lista.size());
    while (iter.hasNext()) {
      System.out.printf("Sobrino ...: %s%n", iter.next());

    }
  }
}
