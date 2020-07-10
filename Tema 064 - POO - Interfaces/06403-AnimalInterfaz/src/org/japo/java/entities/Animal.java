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
import org.japo.java.interfaces.IAnimal;

/**
 *
 * @author mon_mo
 */
public class Animal implements IAnimal, Serializable {

  private static final long serialVersionUID = 919170702589517419L;
  
  public static final int DEF_PATAS = 4;

  private int patas;

  //Constructores
  public Animal() {
    patas = DEF_PATAS;
  }

  public Animal(int patas) {
    if (patas > 2 && patas % 2 == 0) {
      this.patas = patas;
    } else {
      this.patas = DEF_PATAS;
    }
  }

  public int getPatas() {
    return patas;
  }

  public void setPatas(int patas) {
    if (patas > 2 && patas % 2 == 0) {
      this.patas = patas;
    }
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Animal)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.patas == ((Animal) o).getPatas();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + this.patas;
    return hash;
  }

  //Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "El %s tiene %d patas.",
            getClass().getSimpleName().toLowerCase(), patas);
  }

  @Override
  public void mostrarPatas() {
    System.out.println(toString());
  }

}
