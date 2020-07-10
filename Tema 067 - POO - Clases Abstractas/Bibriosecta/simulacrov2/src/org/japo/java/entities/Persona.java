/*
 * Copyright 2020 Aitor Sanchez - aitor.sanchez.alum@iescamp.es.
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
package org.japo.java.entities;

import java.io.Serializable;
import org.japo.java.interfaces.ISocial;

/**
 *
 * @author Aitor Sanchez - aitor.sanchez.alum@iescamp.es
 */
public abstract class Persona implements ISocial, Serializable {

    private static final long serialVersionUID = -1807164161239711298L;

    public static final String DEF_NOMBRE = "JAPO";
    public static final int LONG_MIN = 3;
    public static final int LONG_MAX = 20;

    private String nombre;

    public Persona() {
        nombre = DEF_NOMBRE;
    }

    public Persona(String nombre) {
        if (validar(nombre)) {
            this.nombre = nombre;
        } else {
            this.nombre = DEF_NOMBRE;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (validar(nombre)) {
            this.nombre = nombre;
        }
    }

    private boolean validar(String nombre) {
        boolean testOk = true;
        for (int i = 0; i < nombre.length(); i++) {
            if (Character.isLetterOrDigit(nombre.charAt(i))) {
                testOk = testOk && true;
            } else if (nombre.charAt(i) == ' ' || nombre.charAt(i) == '-') {
                testOk = testOk && true;
            } else {
                testOk = false;
            }

        }
        testOk = testOk
                && nombre.length() >= LONG_MIN && nombre.length() <= LONG_MAX;
        return testOk;
    }

    @Override
    public String toString() {
        return String.format("Yo soy %s", getClass().getSimpleName());
    }
}
