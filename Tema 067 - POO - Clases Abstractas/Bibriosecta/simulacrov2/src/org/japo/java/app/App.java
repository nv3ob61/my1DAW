/*
 * Copyright 2019 Aitor Sanchez - aitor.sanchez.alum@iescamp.es.
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

import org.japo.java.entities.AlumnoAsir;
import org.japo.java.entities.AlumnoDaw;


/**
 *
 * @author Aitor Sanchez - aitor.sanchez.alum@iescamp.es
 */
public final class App {

    public final void launchApp() {
        AlumnoDaw a1 = new AlumnoDaw();
        System.out.println("Alumno DAW 1");
        System.out.println("==========");
        a1.setNombre("Aitor");
        System.out.printf("Mi nombre es %s%n",a1.getNombre());
        a1.saludar();
        a1.tomarApuntes();
        System.out.println("---");
        
        AlumnoDaw a2 = new AlumnoDaw();
        System.out.println("Alumno DAW 2");
        System.out.println("==========");
        a2.setNombre("Chechu");
        a2.setTipo('f');
        System.out.printf("Mi nombre es %s%n",a2.getNombre());
        a2.saludar();
        a2.tomarApuntes();
//        System.out.println("Alumno ASIR");
//        System.out.println("==========");
//        AlumnoAsir a3 = new AlumnoAsir();
//        a3.setNombre("Xexu");
//        System.out.printf("Mi nombre es %s%n",a3.getNombre());
//        a3.saludar();
//        a3.tomarApuntes();
        System.out.println("---");
        System.out.println("Comparacion");
        System.out.println("===========");
        System.out.println(a1.equals(a2));
        
        AlumnoAsir asir1 = new AlumnoAsir();
        System.out.println();
    }
}
