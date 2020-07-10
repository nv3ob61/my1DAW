/*
 * Copyright 2019 mon_mo.     0mon.mode@gmail.com
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
package org.japo.java.libraries;
/**
 *
 * @author mon_mo
 */
public class UtilesPrimitivos {

    // constantes de analisis
    public static final int AN_PAR = 0;
    public static final int AN_IMPAR = 1;
    public static final int AN_POSITIVO = 2;
    public static final int AN_NEGATIVO = 3;

    public static final boolean validarPar(double n) {
        return analizar(n, AN_PAR);
    }
    
    public static final boolean validarPositivo(double n) {
        return analizar(n, AN_POSITIVO);
    }
    
    public static final boolean analizar(double n, int an) {
        boolean testOK = true;
        switch (an) {
            case AN_PAR:
                testOK = n % 2 == 0;
                break;
            case AN_IMPAR:
                testOK = n % 2 != 0;
                break;
            case AN_POSITIVO:
                testOK = n >= 0;
                break;
            case AN_NEGATIVO:
                testOK = n < 0;
                break;
        }
        return testOK;
    }

}
