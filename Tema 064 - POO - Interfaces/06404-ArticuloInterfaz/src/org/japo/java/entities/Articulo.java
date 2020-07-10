/*
 * Copyright (C) 2020 CicloM
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
import java.text.DecimalFormat;
import java.util.Locale;
import org.japo.java.interfaces.IArticulo;

/**
 *
 * @author CicloM
 */
public class Articulo implements IArticulo, Serializable {

  private static final long serialVersionUID = -456050078462488069L;

  public static final double DEF_PRECIO = 0.0;

  private double precio;

  public Articulo() {
    precio = DEF_PRECIO;
  }

  public Articulo(double precio) {
    DecimalFormat df = new DecimalFormat("#.##");
    this.precio = Double.parseDouble(df.format(precio));
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    DecimalFormat df = new DecimalFormat("#.##");
    this.precio = Double.parseDouble(df.format(precio));
  }

  //Sobrecargas
  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Articulo)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.getPrecio() == ((Articulo) o).getPrecio();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + (int) (Double.doubleToLongBits(this.precio)
            ^ (Double.doubleToLongBits(this.precio) >>> 32));
    return hash;
  }

  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "El %s cuesta %.2f €",
            getClass().getSimpleName().toLowerCase(), getPrecio());
  }

  @Override
  public void mostrarPrecio() {
    System.out.println(toString());
  }

}
