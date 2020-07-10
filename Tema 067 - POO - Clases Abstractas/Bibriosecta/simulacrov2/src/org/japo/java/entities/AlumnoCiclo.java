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
public abstract class AlumnoCiclo extends AlumnoSecundaria {

    private static final long serialVersionUID = -2851335740559246219L;

    public static final char DEF_FAMILIA = 'I';

    private char familia;

    public AlumnoCiclo() {
        super('c');
        familia = DEF_FAMILIA;
    }

    public AlumnoCiclo(char familia) {
        super('c');
        switch (familia) {
            case 'i':
            case 'I':
                this.familia = 'I';
                break;
            case 'd':
            case 'D':
                this.familia = 'D';
                break;
            default:
                this.familia = DEF_FAMILIA;
        }
    }

    public char getFamilia() {
        return familia;
    }

    public void setFamilia(char familia) {
        switch (familia) {
            case 'i':
            case 'I':
                this.familia = 'I';
                break;
            case 'd':
            case 'D':
                this.familia = 'D';
        }
    }
}
