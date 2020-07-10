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

/**
 *
 * @author jonsui10
 */
public class Contacto implements Serializable {

  private static final long serialVersionUID = 7821010808384839758L;

  public static final String DEF_ALIAS = "Aupatu";
  public static final int DEF_EDAD = 18;
  public static final int MIN_EDAD = 18;
  public static final int MAX_EDAD = 195;
  //Para validar el nombre
  public static final int MAX_LON = 10;
  public static final int MIN_LON = 3;

  private String alias;
  private int edad;

  public Contacto() {
    alias = DEF_ALIAS;
    edad = DEF_EDAD;
  }

  public Contacto(String alias, int edad) {
    if (edad >= MIN_EDAD && edad <= MAX_EDAD) {
      this.edad = edad;
    } else {
      this.edad = DEF_EDAD;
    }

    if (validar(alias)) {
      this.alias = alias.replaceAll("\\s+", "");
    } else {
      this.alias = DEF_ALIAS;
    }
  }

  public String getAlias() {
    return alias;
  }

  public int getEdad() {
    return edad;
  }

  public void setAlias(String alias) {
    if (validar(alias)) {
      this.alias = alias.replaceAll("\\s+", "");
    } else {
      this.alias = DEF_ALIAS;
    }
  }

  public void setEdad(int edad) {
    if (edad >= MIN_EDAD && edad <= MAX_EDAD) {
      this.edad = edad;
    } else {
      this.edad = DEF_EDAD;
    }
  }

  public boolean esMayorDe(int edad) {
    return edad >= 18;
  }

  @Override
  public String toString() {
    return this.getAlias() + " - " + this.getEdad();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(this.edad)
            ^ (Double.doubleToLongBits(this.edad * 1421) >>> 32));
    return hash;
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Contacto)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.edad == ((Contacto) o).getEdad()
              && this.alias.equals(((Contacto) o).getAlias());
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
