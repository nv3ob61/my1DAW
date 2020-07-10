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
public abstract class AlumnoSecundaria extends Alumno {

    private static final long serialVersionUID = -5722191964920415820L;

    public static final char DEF_ITINERARIO = 'C';

    private char itinerario;

    public AlumnoSecundaria() {
        super();
        itinerario = DEF_ITINERARIO;
    }

    public AlumnoSecundaria(char itinerario) {
        super();
        switch (itinerario) {
            case 'C':
            case 'c':
                this.itinerario = 'C';
                break;
            case 'E':
            case 'e':
                this.itinerario = 'E';
                break;
            case 'B':
            case 'b':
                this.itinerario = 'B';
                break;
            default:
                this.itinerario = DEF_ITINERARIO;
        }
    }

    public char getItinerario() {
        return itinerario;
    }

    public void setItinerario(char itinerario) {
        switch (itinerario) {
            case 'C':
            case 'c':
                this.itinerario = 'C';
                break;
            case 'E':
            case 'e':
                this.itinerario = 'E';
                break;
            case 'B':
            case 'b':
                this.itinerario = 'B';
        }
    }
}
