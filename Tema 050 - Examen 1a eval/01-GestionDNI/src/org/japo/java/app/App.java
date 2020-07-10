/*
 * Copyright 2019 José Luis Alegre Llopis - 1º DAW Presencial 2019/2020
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

import org.japo.java.libraries.UtilesDNI;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author José Luis Alegre Llopis
 */
public final class App {

    public static final String PACO = "---";
    public static final String PACO_LONG = "==============";
    public static final String MSG_USR = "Número de DNI ...: ";
    public static final String MSG_CTRL = "Control de DNI ..: ";
    public static final String MSG_ERR = "ERROR: DNI incorrecto";
    public static final String MSG_FIN = "DNI introducido .: ";
    public static final int NUM_MIN = 10000000;
    public static final int NUM_MAX = 99999999;

    public final void launchApp() {
        int numero;
        char charUsr;
        boolean numOk = false;
        boolean charOk = false;

        muestraBanner();

        do {
            numero = (int) UtilesEntrada.obtenerNumero(MSG_USR, MSG_ERR,
                    NUM_MIN, NUM_MAX);
            numOk = UtilesDNI.validar(numero);
            
            charUsr = UtilesEntrada.obtenerCaracter(MSG_CTRL, MSG_ERR);
            charOk = UtilesDNI.validar(numero, charUsr);
            System.out.println(PACO);
        } while (!numOk && !charOk);

        System.out.printf("%s%d%c%n", MSG_FIN, numero, charUsr);
    }

    public final void muestraBanner() {
        System.out.println("Validación DNI");
        System.out.println(PACO_LONG);

    }
}
