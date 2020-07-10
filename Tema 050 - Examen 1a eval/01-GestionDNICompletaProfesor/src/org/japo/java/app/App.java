/*
 * Copyright 2016 José A. Pacheco Ondoño - joanpaon@gmail.com.
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
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class App {
    // Mensajes
    public static final String MSG_NUM = "Número de DNI ...: ";
    public static final String MSG_CTR = "Control de DNI ..: ";
    public static final String MSG_USR = "DNI .............: ";
    public static final String MSG_ERR = "ERROR: DNI incorrecto";
    public static final String MSG_DNI = "DNI introducido .: ";

    // Punto de entrada de la clase App.
    public void launchApp() {
        // Encabezado
        System.out.println("Validación DNI");
        System.out.println("==============");
        
        // Introducir DNI
//        String dni = UtilesEntrada.obtenerDNI(MSG_NUM, MSG_CTR, MSG_ERR);
        String dni = UtilesEntrada.obtenerDNI(MSG_USR, MSG_ERR);

        // Separador
        System.out.println("---");
        
        // Mostrar DNI
        System.out.printf(MSG_DNI + "%s%n", dni);
    }
}
