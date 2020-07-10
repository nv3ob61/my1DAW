/*
 * Copyright 2019 mon_mo    - 0mon.mode@gmail.com
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
 * @author mon_mo
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
        char ctr;
        boolean dniOk;

        muestraBanner();
        
        // Bucle consola > DNI
        do {
            // Intro número
            numero = (int)UtilesEntrada.obtenerNumero(MSG_USR, MSG_ERR, 
                    UtilesDNI.NUM_MIN, UtilesDNI.NUM_MAX);
            
            //Intro CONTROL
            ctr = UtilesEntrada.obtenerCaracter(MSG_CTRL, MSG_ERR);
            if(UtilesDNI.validar(ctr)) {
                System.out.println(PACO);
                System.out.println(MSG_ERR);
                System.out.println(PACO);
            }
            
            //Actualiza semáforo
            dniOk = UtilesDNI.validar(numero, ctr);
            
        } while (!dniOk);

        System.out.printf("%s%d%c%n", MSG_FIN, numero, ctr);
    }

    public final void muestraBanner() {
        System.out.println("Validación DNI");
        System.out.println(PACO_LONG);

    }
}
