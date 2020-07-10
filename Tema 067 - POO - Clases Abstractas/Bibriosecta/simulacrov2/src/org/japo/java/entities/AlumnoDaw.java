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
public class AlumnoDaw extends AlumnoCiclo {

    private static final long serialVersionUID = 1963663971296271151L;

    public static final char DEF_TIPO = 'B';

    private char tipo;

    public AlumnoDaw() {
        super('I');
        tipo = DEF_TIPO;
    }

    public AlumnoDaw(char tipo) {
        super('I');
        switch (tipo) {
            case 'b':
            case 'B':
                this.tipo = 'B';
                break;
            case 'f':
            case 'F':
                this.tipo = 'F';
                break;
            default:
                this.tipo = DEF_TIPO;
        }
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        switch (tipo) {
            case 'b':
            case 'B':
                this.tipo = 'B';
                break;
            case 'f':
            case 'F':
                this.tipo = 'F';
        }
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy programador");
    }

    @Override
    public void tomarApuntes() {
        System.out.println("Escribiendo mi código");
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.tipo;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        boolean testOk;
        if (o == null) {
            testOk = false;
        } else if (!(o instanceof AlumnoDaw)) {
            testOk = false;
        } else {
            testOk = tipo == ((AlumnoDaw) o).tipo;
        }
        return testOk;
    }

}
