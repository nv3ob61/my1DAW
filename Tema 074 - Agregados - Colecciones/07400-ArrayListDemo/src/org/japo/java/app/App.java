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
    // Instancia un objeto ArrayList
    ArrayList<String> lista = new ArrayList<>();

// Añade cosas
    lista.add("Texto 01");
    lista.add("Texto 02");
    lista.add("Texto 03");
//añadimos el elemento en la posición dos, desplaza "Texto 03"
// Define el iterador
    Iterator<String> it = lista.iterator();

// Muestra la lista
    while (it.hasNext()) {
      System.out.printf("Elemento ...: %s%n", it.next());
    }
//añadimos el texto 22 en la pos 2
    lista.add(2, "Texto 22");

    //redefine el iterador.
    it = lista.listIterator();
    
    
    // Muestra la lista
    while (it.hasNext()) {
      System.out.printf("Elemento ...: %s%n", it.next());
    }
  }
}
