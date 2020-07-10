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
import java.util.Scanner;
import org.japo.java.entities.Contacto;

/**
 *
 * @author mon_mo
 */
public final class App {

    // Instanciar Scanner
    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public final void launchApp() {
        String nombre;
        int edad;

        Contacto cont = new Contacto();

        System.out.println("Introdusca su edad: ");
        edad = SCN.nextInt();

        cont.setEdad(edad);
        System.out.println("Introdusca su nombre: ");
        nombre = SCN.next();
        cont.setAlias(nombre);
        
        System.out.println(cont.toString());

        if (cont.esMayorDe()) {
            System.out.printf("La persona %s tiene %d años, es MAYOR de 18.",
                    cont.getAlias(), cont.getEdad());
        } else {
            System.out.printf("La persona %s solo tiene %d años, es MENOR de 18.",
                    cont.getAlias(), cont.getEdad());
        }
    }
}
