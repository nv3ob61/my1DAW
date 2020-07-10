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
import java.util.List;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {

    ArrayList<String> lista = new ArrayList<>();

    lista.add("Juanito");
    lista.add("Pakito");
    lista.add("Jorgito");
    lista.add("Pakito");
    lista.add("Jaimito");

    //Pasamos array a arrayList
    List<String> listaNombres = (List<String>) (lista);

    //Cabezal
    System.out.println("Sobrinos de Donald");
    //Separador
    System.out.println("==================");
    //Muestra por pantalla el numero de sobrinos
    System.out.printf("Sobrinos ..: %d%n", listaNombres.size());

    //for para mostrar el nombre de los sobrinos
    for (String s : listaNombres) {
      System.out.printf("Sobrino ...: %s%n", s);
    }

    //Eliminador de pakitos
    for (int i = 0; i < listaNombres.size(); i++) {

      String elemento = listaNombres.get(i);

      if (elemento.equals("Pakito")) {
        listaNombres.remove(i);
      }
    }

    //Separador
    System.out.println("--------");

    //Muestra sobrinos verdaderos
    System.out.printf("Sobrinos ..: %d%n", listaNombres.size());

    //Muestra los sobrinos verdaderos
    for (int i = 0; i < listaNombres.size(); i++) {
      String elemento = listaNombres.get(i);
      System.out.printf("Sobrino ...: %s%n", elemento);

    }
  }
}
