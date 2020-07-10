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

import java.util.Locale;

/**
 *
 * @author mon_mo
 */
public final class App {
    public static final double N1 = 3.4;
    public static final double N2 = 5.6;

    public final void launchApp() {

        double suma = sumar(N1, N2);
        suma += sumar(N1, N2);
        suma += sumar(N1, N2);
        suma += sumar(N1, N2);
        
        System.out.printf(Locale.ENGLISH, "%.1f y %.1f suman %.1f%n", N1, N2, suma);
    }
    
    public final double sumar(double a, double b) {
        return a + b;
    }
}
