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
    //Declaración
    ArrayList<String> lista = new ArrayList<>();

    //Generador del contenido del arraylist
    for (int i = 0; i < 4; i++) {
      lista.add("Texto 0" + i);
    }

    //Definir Iterador
    Iterator<String> iter = lista.iterator();

    //Muestra lista
    while (iter.hasNext()) {
      System.out.printf("Elemento ...: %s%n", iter.next());
    }

    //Separador
    System.out.println("---");

    //Añadimos un elemento en la posicion 2
    lista.remove(1);

    //Redefine el iterador
    iter = lista.iterator();

    //Iterador
    while (iter.hasNext()) {

      System.out.printf("Elemento ...: %s%n", iter.next());
    }

    System.out.printf("posiciones .: %d%n", lista.size());
  }
}
