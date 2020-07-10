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
public class Equipo implements Serializable {

  private static final long serialVersionUID = 6466190920772429784L;

  private final int MIN_MIEM = 2;
  private final int MAX_MIEM = 4;
  private final int DEF_MIEM = 3;
  private final double MAX_PRES = 30.0;
  private final double DEF_PRES = 21.0;

  private int miem;
  private double pres;

  public Equipo() {
    miem = DEF_MIEM;
    pres = DEF_PRES;
  }

  public Equipo(int miem, double pres) {
    if (miem >= MIN_MIEM && miem <= MAX_MIEM) {
      this.miem = miem;
    } else {
      this.miem = DEF_MIEM;
    }
    if (pres >= MAX_PRES) {
      this.pres = pres;
    } else {
      this.pres = DEF_PRES;
    }
  }

  public int getMiem() {
    return miem;
  }

  public void setMiem(int miem) {
    if (miem >= MIN_MIEM && miem <= MAX_MIEM) {
      this.miem = miem;
    }
  }

  public double getPres() {
    return pres;
  }

  public void setPres(double pres) {
    if (pres >= MAX_PRES) {
      this.pres = pres;
    }
  }
  
  //Sobrecargas
  @Override
  public final String toString() {
    return String.format(Locale.ENGLISH, "El %s consta de %d miembros.%n"
            + "Su presupuesto es de %.2f €. %n",
            getClass().getSimpleName(), miem, pres);
  }
  
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + (int) (Double.doubleToLongBits(this.pres*miem) ^ (Double.doubleToLongBits(this.miem*pres) >>> 32));
    return hash;
  }
  
  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Equipo)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.miem == ((Equipo) o).getMiem() &&
               this.pres == ((Equipo) o).getPres();
    }
    return testOk;
  }
}
