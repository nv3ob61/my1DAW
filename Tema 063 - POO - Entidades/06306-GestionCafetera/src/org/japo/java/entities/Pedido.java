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
 * @author Jonsui
 */
public class Pedido implements Serializable {

  private static final long serialVersionUID = 789967993327789851L;

  public static final int AGUA = 35;
  public static final int REFRESCO = 42;
  public static final int BATIDO = 27;
  public static final String STR_BATIDO = "BATIDO";
  public static final String STR_AGUA = "AGUA";
  public static final String STR_REFRESCO = "REFRESCO";
  public static final int DEF_ITEM = AGUA;

  private int item;

  public Pedido() {
    item = DEF_ITEM;
  }

  public Pedido(int item) {
    if (item == AGUA || item == REFRESCO
            || item == BATIDO) {
      this.item = item;
    } else {
      this.item = DEF_ITEM;
    }
  }

  public int getItem() {
    return item;
  }

  public void setItem(int item) {
    if (item == AGUA || item == REFRESCO
            || item == BATIDO) {
      this.item = item;
    }
  }

  //Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "El %s es de %s ",
            getClass().getSimpleName(), switchItem(item));
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(this.item)
            ^ (Double.doubleToLongBits(this.item) >>> 32));
    return hash;
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Pedido)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.item == ((Pedido) o).getItem();
    }
    return testOk;
  }

  private String switchItem(int item) {
    String conv = "";
    switch (item) {
      case 27:
        conv = STR_BATIDO;
        break;
      case 35:
        conv = STR_AGUA;
        break;
      case 42:
        conv = STR_REFRESCO;
        break;
    }
    return conv;
  }
}
