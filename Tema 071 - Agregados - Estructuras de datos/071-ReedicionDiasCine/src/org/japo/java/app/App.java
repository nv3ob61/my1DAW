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

import java.util.Random;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final int DIA_MIN = 1;
    public static final int DIA_MAX = 7;
    public static final int AFORO_MAX = 1234;

    public static final Random RND = new Random();

    public final void launchApp() {
        
        int maxExp = 0;
        int maxDia = 0;
        
        
        for (int i = 0; i < DIA_MAX; i++) {
            int numEspec = RND.nextInt(AFORO_MAX);
            
            if(i == 0) {
                maxDia = 1;
                maxExp = numEspec;
            } else if (numEspec > maxExp){
                maxDia = 1;
                maxExp = numEspec;

            }
            
            System.out.printf("Dia %d - %s %4d Espectadores%n", i + 1,
                    obtenerNombreDia(i + 1), numEspec);
        }
        
        System.out.println(obtenerNombreDia(maxDia +1) + " "+ maxExp);
    }

    public static final String obtenerNombreDia(int numDia) {
        String nombreDia;
        switch (numDia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Mi'ercoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sabado";
                break;
            case 7:
                nombreDia = "Dominguete";
                break;
            default:
                throw new AssertionError();
        }
        return nombreDia;
    }
}
