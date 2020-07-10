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

import org.japo.java.interfaces.IDocencia;

/**
 *
 * @author Aitor Sanchez - aitor.sanchez.alum@iescamp.es
 */
public abstract class Alumno extends Persona implements IDocencia {

    private static final long serialVersionUID = -3575697850255192186L;

    public static final int DEF_EXP = 5;

    private int exp;

    public Alumno() {
        super();
        exp = DEF_EXP;
    }

    public Alumno(int exp) {
        super();
        if (validar(exp)) {
            this.exp = exp;
        } else {
            this.exp = DEF_EXP;
        }
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        if (validar(exp)) {
            this.exp = exp;
        }
    }

    public boolean validar(int num) {
        return num > 0 && num <= 100;
    }

}
