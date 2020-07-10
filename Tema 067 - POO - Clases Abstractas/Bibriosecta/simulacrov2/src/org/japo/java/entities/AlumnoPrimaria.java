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

/**
 *
 * @author Aitor Sanchez - aitor.sanchez.alum@iescamp.es
 */
public abstract class AlumnoPrimaria extends Alumno {

    private static final long serialVersionUID = -78327665190095330L;

    public static final String DEF_TUTOR = "Paco";

    private String tutor;

    public AlumnoPrimaria() {
        super();
        tutor = DEF_TUTOR;
    }

    public AlumnoPrimaria(String tutor) {
        super();
        this.tutor = tutor;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
