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
public class AlumnoAsir extends AlumnoCiclo {

    private static final long serialVersionUID = 1963663971296271151L;

    public static final char DEF_ADM = 'B';

    private char adm;

    public AlumnoAsir() {
        super('I');
        adm = DEF_ADM;
    }

    public AlumnoAsir(char tipo) {
        super('I');
        switch (tipo) {
            case 'b':
            case 'B':
                this.adm = 'B';
                break;
            case 'd':
            case 'D':
                this.adm = 'D';
                break;
            default:
                this.adm = DEF_ADM;
        }
    }

    public char getAdm() {
        return adm;
    }

    public void setAdm(char adm) {
        switch (adm) {
            case 'b':
            case 'B':
                this.adm = 'B';
                break;
            case 'd':
            case 'D':
                this.adm = 'D';
        }
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy administrador");
    }

    @Override
    public void tomarApuntes() {
        System.out.println("Escribiendo mis IPs");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.adm;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        boolean testOk;
        if (o == null) {
            testOk = false;
        } else if (!(o instanceof AlumnoAsir)) {
            testOk = false;
        } else {
            testOk = adm == ((AlumnoAsir) o).adm;
        }
        return testOk;
    }
}
