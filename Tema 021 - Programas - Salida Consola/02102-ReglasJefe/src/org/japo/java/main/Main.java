/* 
 * Copyright 2019 mon-mode - 0mon.mode@gmail.com
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
package org.japo.java.main;

/**
 *
 * @author mon-mode
 */
public class Main {

    public static void main(String[] args) {
        
        final String REGLA1 = "Artículo %d. ";
        final String REGLA2 = "El jefe%s tiene la razón.";
        final String REGLA3 = "En caso de duda se aplicará el artículo dos. ";
        
        System.out.printf(REGLA1 + REGLA2 + "%n", 1, "");
        System.out.printf(REGLA1 + REGLA2 + "%n", 2, " SIEMPRE");
        System.out.printf(REGLA1 + REGLA3 + "%n", 3);
        System.out.println();
        System.out.println("Aplicamos el método fácil ahora: \n");
        System.out.println("Artículo 1. El jefe tiene la razón.");
        System.out.println("Artículo 2. El jefe SIEMPRE tiene la razón.");
        System.out.println("Artículo 3. En caso de duda se aplicará el "
                + "Artículo dos. ");
    }
}
