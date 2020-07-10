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
import java.util.Iterator;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {
//Array de nombres
//instancia objeto Array List a partir de objeto List
    ArrayList<String> lista = new ArrayList<>();

    lista.add("Juanito");
    lista.add("Pakito");
    lista.add("Jorgito");
    lista.add("Pakito");
    lista.add("Jaimito");

// Define el iterador
    Iterator<String> it = lista.iterator();

    System.out.println("Sobrinos de Donald");
    System.out.println("==================");
    System.out.printf("Sobrinos ..: %d%n", lista.size());

    lista.forEach((_item) -> {
      System.out.printf("Sobrino ...: %s%n", it.next());
    });

    for (int i = 0; i < lista.size(); i++) {
      String element = lista.get(i);

      if (element.equals("Pakito")) {
        lista.remove(i);
      }
    }

    Object[] array = lista.toArray();

    System.out.println("==================");
    System.out.println("Sobrinos [auténticos] de Donald");
    System.out.printf("Sobrinos ..: %d%n", array.length);

    for (Object object : array) {
      System.out.printf("Sobrino ...: %s%n", object);
    }
  }
}
