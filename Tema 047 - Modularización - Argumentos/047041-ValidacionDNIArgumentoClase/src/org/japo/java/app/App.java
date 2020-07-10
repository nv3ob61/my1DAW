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
/**
 *
 * @author mon_mo
 */
public final class App {

    //Secuencia Letras
    public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static final String MSG_INTRO = "VALIDACIÓN DE DNI";
    public static final String PACO_LONG = "=================";
    public static final String PACO = "---";

    //Datos Trabajo
    public static final int DNI_NUM = 10;
    public static final char DNI_CTR = 'Y';

    public final void launchApp() {
        //Había una variable boolean dniOk pero la podemos obviar con su valor:
        //  boolean dniOk = validar(DNI_NUM, DNI_CTR);
        //y pasarlo directamente por el método muestraSalida();
        muestraBanner();
        //Analisis
        muestraSalida(validar(DNI_NUM, DNI_CTR));
    }

    public static final void muestraBanner() {
        //Cabecera
        System.out.println(MSG_INTRO);
        System.out.println(PACO_LONG);

        //Mostrar DNI
        System.out.printf("DNI ......: %d%c%n", DNI_NUM, DNI_CTR);

        //Separador
        System.out.println(PACO);

    }

    public static final void muestraSalida(boolean dniOk) {

        //Mostrar resultados
        System.out.printf("Validez ..: %s%n", dniOk ? "Correcto" : "Incorrecto");
    }

    public static final char calcular(int num) {
        return LETRAS.charAt(num % 23);
    }

    public static final boolean validar(int num, char ctr) {
        return ctr == calcular(num);
    }
}
