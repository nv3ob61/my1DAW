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

import org.japo.java.entities.Arcon;
import org.japo.java.entities.Armario;
import org.japo.java.entities.Horno;
import org.japo.java.entities.Nevera;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {
    //Nevera 1
    Nevera n1 = new Nevera();
    System.out.println("NEVERA 1");
    System.out.println("========");
    System.out.println(n1.toString());
    n1.instalar();
    n1.enfriar();
    n1.conectar(n1.getClass().getSimpleName());
    n1.desconectar(n1.getClass().getSimpleName());

    //separador
    System.out.println();

    //Horno 1
    Horno h1 = new Horno();
    System.out.println("HORNO 1");
    System.out.println("=======");
    System.out.println(h1.toString());
    h1.instalar();
    h1.calentar();
    h1.conectar(h1.getClass().getSimpleName());
    h1.desconectar(h1.getClass().getSimpleName());

    //separador
    System.out.println();

    //Armario 1
    Armario a1 = new Armario();
    System.out.println("ARMARIO 1");
    System.out.println("=======");
    System.out.println(a1.toString());
    a1.instalar();
    a1.almacenar("Pantucos");
    a1.extraer("Carzoncillos");

    //separador
    System.out.println();

    //Arcon 1
    Arcon c1 = new Arcon();
    System.out.println("ARCON 1");
    System.out.println("=======");
    System.out.println(c1.toString());
    c1.instalar();
    c1.almacenar("Psicoanalís, con azento en la í.");
    c1.extraer("Más carisma para Joanpaon");

    //separador
    System.out.println();
  }
}
