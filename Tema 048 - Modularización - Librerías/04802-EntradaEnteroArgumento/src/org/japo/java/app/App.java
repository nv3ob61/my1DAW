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

import org.japo.java.libraries.UtilesEntrada;
/**
 *
 * @author mon_mo
 */
public final class App {

    public final void launchApp() {
        //solo hace el programa una vez...
        muestraBanner();
        //PIM PAM!
        muestraNumero(Math.floor(UtilesEntrada.obtener()));
    }

    public final void muestraBanner() {
        System.out.println("INTRODUCCIÓN ENTERO");
        System.out.println(UtilesEntrada.PACO_LONG);
    }


    public final void muestraNumero(double numero) {
        System.out.println(UtilesEntrada.PACO);
        System.out.printf("%s%.0f%n", UtilesEntrada.MSG_OUT, numero);
    }
}
