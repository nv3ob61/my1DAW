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

import org.japo.java.utils.UtilesEntrada;
import org.japo.java.utils.UtilesIdioma;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final String MSG_DIA = "Número de día ....: ";
  public static final String MSG_IDIOM = "Idioma elegido ...: ";
  public static final String MSG_ERR = "MEEEEEC!";

  public final void launchApp() {
    
    System.out.printf("Nombre de día ....: %s%n", 
            UtilesIdioma.generarNombreDia(
                    UtilesEntrada.leerEntero(MSG_DIA, MSG_ERR), 
                    UtilesEntrada.leerEntero(MSG_IDIOM, MSG_ERR)));
  }
}
