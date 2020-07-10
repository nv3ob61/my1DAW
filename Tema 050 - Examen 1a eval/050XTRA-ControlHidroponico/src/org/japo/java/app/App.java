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

    public static final int H_MIN = 71;
    public static final int H_MAX = 86;
    public static final int T_MIN = 19;
    public static final int T_MAX = 22;
    public static final int I_MIN = 2;
    public static final int I_MAX = 13;
    public static final String PACO = "---";
    public static final String MSG_HUM = "Introduzca un valor para "
            + "la humedad ...: ";
    public static final String MSG_TEM = "Introduzca un valor para "
            + "la temperatura: ";
    public static final String MSG_ILU = "Introduzca un valor para "
            + "la iluminación: ";
    public static final String MSG_ERR = "ERROR: Valor introducido NO válido";
    public static final String MSG_ALR = "ALARMA";

    public final void launchApp() {
        int humedad;
        int tempera;
        int ilumina;

        muestraBanner();
        humedad = UtilesEntrada.leerInt(MSG_HUM, MSG_ERR);
        System.out.println(PACO);
        tempera = UtilesEntrada.leerInt(MSG_TEM, MSG_ERR);
        System.out.println(PACO);
        ilumina = UtilesEntrada.leerInt(MSG_ILU, MSG_ERR);
        System.out.println(PACO);
        System.out.printf("%n ... RESUMEN DE LA ALARMA ...%n%n");
        System.out.printf("Humedad ......:   %d %%     – %s%n", humedad, 
                analizarEntero(humedad, H_MIN, H_MAX) ? "OK" : "ALARMA");
        System.out.printf("Temperatura ..:   %d ºC    – %s%n", tempera, 
                analizarEntero(tempera, T_MIN, T_MAX) ? "OK" : "ALARMA");
        System.out.printf("Iluminación ..:   %d kLux  – %s%n", ilumina, 
                analizarEntero(ilumina, I_MIN, I_MAX) ? "OK" : "ALARMA");
    }

    public static final void muestraBanner() {
        String cultivo = "Die Farben der Blumen GmbH";
        System.out.println(cultivo);
        for (int i = 0; i < cultivo.length(); i++) {
            System.out.printf("=");
        }
        System.out.printf("%n%n");
    }

    private boolean analizarEntero(int num, int min, int max) {

        // Semaforo validacion
        boolean rangoOK;

        // Validar Entero
        rangoOK = num >= min && num <= max;

        // Devolver número
        return rangoOK;
    }
}
