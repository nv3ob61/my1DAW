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

import java.util.Locale;
import java.util.Objects;
import org.japo.java.interfaces.IPadre;

/**
 *
 * @author mon_mo
 */
public class Padre implements IPadre {

  public static final String DEF_NOMBRE = "Querido Papuchi";

  private String nombre;

  public Padre() {
    nombre = DEF_NOMBRE;
  }

  public Padre(String nombre) {
    int cont = 0;
    for (int i = 0; i < nombre.length(); i++) {
      if (!Character.isLetterOrDigit(i) && !Character.isWhitespace(i)
              && i != '-') {
        cont++;
      }
    }
    if (cont == 0) {
      this.nombre = nombre;
    } else {
      this.nombre = DEF_NOMBRE;
    }

  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    int cont = 0;
    for (int i = 0; i < nombre.length(); i++) {
      if (!Character.isLetterOrDigit(i) && !Character.isWhitespace(i)
              && i != '-') {
        cont++;
      }
    }
    if (cont == 0) {
      this.nombre = nombre;
    }
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
    hash = 59 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  //Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "%s - %s",
            getClass().getSimpleName(), nombre);
  }

  @Override
  public void mostrarNombre() {
    System.out.println(toString());
  }

}
