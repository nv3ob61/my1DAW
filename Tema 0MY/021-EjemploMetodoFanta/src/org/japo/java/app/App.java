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

    public final void launchApp() {

        String fantaNaranja = "Dame fanta de naranja";
        String fantaLimon = "Toma fanta de limón";

        System.out.println(dameFanta(fantaLimon));
        stringToChar(fantaNaranja);
    }

    public final String dameFanta(String fantaNaranja) {
        
        return fantaNaranja.replace('a', 'e');
    }

    public final String dameCola(String cola) {

        return cola;
    }
    
    public final String stringToChar (String fantaNaranja) {
        //Crea un array de la longitud del String
        char [] ch = new char[fantaNaranja.length()];
        //Copia char por char en el array
        for (int i = 0; i < fantaNaranja.length(); i++) {
            ch[i] = fantaNaranja.charAt(i);
        }
        //Salida del contenedor del array
        for (char c : ch) {
            System.out.print(c);
        }
        System.out.println();
        //Aquí creamos la variable que contiene el "mismo" mensaje de entrada.
        //para que el método la devuelva
        String copy = String.copyValueOf(ch);

        return copy;
    }
}
