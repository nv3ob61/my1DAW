/*
 * Copyright 2019 mon_mo.    0mon.mode@gmail.com
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

import org.japo.java.libraries.UtilesCalculos;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author mon_mo
 */
public final class App {

    public final static String USR_INT = "Número entero ...: ";
    public final static String USR_PAR = "Paridad .........: ";
    public final static String USR_POS = "Positividad .....: ";
    public final static String USR_PRI = "Primitiva .......: ";
    public final static String USR_IVA = "Tipo IVA ........: ";
    public final static String USR_CUA = "Cuadrado ........: ";
    public final static String ERR_MSG = "ERROR: Entrada incorrecta";

    public final void launchApp() {
        int number;

        System.out.println("Demo Librería UtilesCalculos");
        System.out.println("============================");
        number = (int) UtilesEntrada.obtener(USR_INT, ERR_MSG);
        System.out.println(USR_PAR + UtilesCalculos.validarParidad(number));
        System.out.println(USR_POS + UtilesCalculos.validarPositivo(number));
        System.out.println(USR_PRI + UtilesCalculos.validarNumeroPrimitiva(number));
        System.out.println(USR_IVA + UtilesCalculos.validarTipoIVA(number));
        System.out.println(USR_CUA + UtilesCalculos.calculaCuadrado(number));      
    }
}
