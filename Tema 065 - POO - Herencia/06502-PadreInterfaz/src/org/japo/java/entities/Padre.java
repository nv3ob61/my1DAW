/*
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.japo.java.entities;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import org.japo.java.interfaces.IPadre;

/**
 *
 * @author mon_mo
 */
public class Padre implements IPadre, Serializable {

    private static final long serialVersionUID = 4261363471317377428L;

    public static final String DEF_NOMBRE = "Papuchi";
    public static final int DEF_NOMBREMINLEN = 3;

    public String nombrePadre;

    public Padre() {
        nombrePadre = DEF_NOMBRE;
    }

    public Padre(String nombrePadre) {
        if (validar(nombrePadre)) {
            this.nombrePadre = nombrePadre;
        } else {
            this.nombrePadre = DEF_NOMBRE;
        }
    }

    private String getNombre() {
        return nombrePadre;
    }


    @Override
    public final boolean equals(Object o) {
        boolean testOk;
        if (o == null) {
            testOk = false;
        } else if (!(o instanceof Padre)) {
            testOk = false;
        } else {
            //Si tuviera más atributos se añadirían líneas de más concatenando
            // con && en cada línea...
            testOk = this.getNombre().equals(((Padre) o).getNombre());
        }
        return testOk;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombrePadre);
        return hash;
    }

    //Sobrecargas
    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%s se llama %s%n",
                getClass().getSimpleName(), nombrePadre);
    }

    @Override
    public void mostrarNombre() {
        System.out.println(toString());
    }

    @Override
    public void saludar() {
        System.out.printf("Hola %s, ¿Cómo te va?%n", this.nombrePadre);
    }

    public final boolean validar(String nombre) {
        return nombrePadre.length() >= DEF_NOMBREMINLEN;
    }
}
