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
 * @author mon_mode
 */
public final class Mandocleta implements Serializable {

  private static final long serialVersionUID = -2074248138230073904L;
  //Límite de velocidad
  public static final double DEF_VELOCIDAD = 0.0;
  public static final double MAX_VEL = 5;
  public static final double TO_METROS_SEG = 0.277778;

  //Atributos
  private double velocidad;

  //Constructor Predeterminado
  public Mandocleta() {
    velocidad = DEF_VELOCIDAD;
  }

  //Constructor Parametrizado
  public Mandocleta(double velocidad) {
    if (validar(velocidad)) {
      this.velocidad = velocidad;
    } else if (velocidad >= MAX_VEL) {
      this.velocidad = MAX_VEL;
    } else {
      this.velocidad = DEF_VELOCIDAD;
    }
  }

  //Accesores
  public double getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(double velocidad) {
    if (validar(velocidad)) {
      this.velocidad = velocidad;
    } else if (velocidad >= MAX_VEL) {
      this.velocidad = MAX_VEL;
    }
  }

  //Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "%s - %.2f m/s",
            getClass().getSimpleName(), toMetroSeg(velocidad));
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Mandocleta)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.velocidad == ((Mandocleta) o).getVelocidad();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(this.velocidad) ^ (Double.doubleToLongBits(this.velocidad) >>> 32));
    return hash;
  }

  private boolean validar(double velocidad) {
    return Math.abs(velocidad) <= MAX_VEL;
  }

  public double toMetroSeg(double velocidad) {

    return TO_METROS_SEG * velocidad;
  }
}
