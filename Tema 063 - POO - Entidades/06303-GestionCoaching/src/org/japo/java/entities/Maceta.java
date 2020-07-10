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

/**
 *
 *
 * Thanks to StackOverflow here
 * https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
 *
 *
 * @author jonsui10
 */
public class Maceta implements Serializable {

  private static final long serialVersionUID = 1363371579077269263L;

  public static final String DEF_NOMBRE = "Anita";
  public static final int MAX_LON = 10;
  public static final int MIN_LON = 3;

  private String nombre;

  public Maceta() {
    nombre = DEF_NOMBRE;
  }

  public Maceta(String nombre) {
    if (validar(nombre)) {
      this.nombre = nombre.replaceAll("\\s+", "");
    } else {
      this.nombre = DEF_NOMBRE;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    if (validar(nombre)) {
      this.nombre = nombre.replaceAll("\\s+", "");
    }
  }

//Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "La %s se llama %s",
            getClass().getSimpleName(), nombre);
  }
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(this.nombre.length()) ^ 
            (Double.doubleToLongBits(this.nombre.length()) >>> 32));
    return hash;
  }
 
  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Maceta)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.nombre.equals(((Maceta) o).getNombre());
    }
    return testOk;
  }
  
  private boolean validar(String nombre) {
    boolean isOk = false;
    if (nombre.length() >= MIN_LON && nombre.length() <= MAX_LON) {
      isOk = true;
    }
    return isOk;
  }
}
