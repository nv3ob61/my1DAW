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

import org.japo.java.libraries.UtilesPrimitivos;

/**
 *
 * @author mon_mo
 */
public final class App {

    public final void launchApp() {

        salidaRango(UtilesPrimitivos.analizarRango(UtilesPrimitivos.RND_NUM, 
                UtilesPrimitivos.MAX, UtilesPrimitivos.MIN));
    }
 
    public final void salidaRango(int valor){
        System.out.println("ANÁLISIS DE RANGO");
        System.out.println("=================");
        System.out.printf("Número ......: %d%n", UtilesPrimitivos.RND_NUM);
        System.out.println("---");
        System.out.printf("Mínimo ......: %d%n", UtilesPrimitivos.MIN);
        System.out.printf("Máximo ......: %d%n", UtilesPrimitivos.MAX);
        System.out.println("---");
        
        switch (valor) {
            case 0:
                System.out.println("Análisis ....: DENTRO");
                break;
            case 1:
                System.out.println("Análisis ....: FUERA ( Abajo )");
                break;
            case 2:
                System.out.println("Análisis ....: FUERA ( Arriba )");
                break;
            default:
                break;
        }
    }
}
