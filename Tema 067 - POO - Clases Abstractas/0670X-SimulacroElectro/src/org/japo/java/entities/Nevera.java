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

import org.japo.java.interfaces.INevera;

/**
 *
 * @author CicloM
 */
public class Nevera extends Electro implements INevera {

  private static final long serialVersionUID = -9119606216756608695L;

  public static final int DEF_POTENCIA = 400;
  public static final int DEF_TEMPMIN = -4;
  public static final int DEF_TEMPMAX = 6;
  public static final int DEF_TEMP = 0;

  private int potencia;
  private int temperatura;

  public Nevera() {
    potencia = DEF_POTENCIA;
    temperatura = DEF_TEMP;
  }

  public Nevera(int potencia, int temperatura) {
    if (potencia <= DEF_POTENCIA) {
      this.potencia = potencia;
    } else {
      this.potencia = DEF_POTENCIA;
    }
    if (temperatura >= DEF_TEMPMIN && temperatura <= DEF_TEMPMAX) {
      this.temperatura = temperatura;
    } else {
      this.temperatura = temperatura;
    }
  }

  public int getPotencia() {
    return potencia;
  }

  public int getTemperatura() {
    return temperatura;
  }

  public void setPotencia(int potencia) {
    if (potencia <= DEF_POTENCIA) {
      this.potencia = potencia;
    }
  }

  public void setTemperatura(int temperatura) {
    if (temperatura >= DEF_TEMPMIN && temperatura <= DEF_TEMPMAX) {
      this.temperatura = temperatura;
    }
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Nevera)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.potencia == ((Nevera) o).getPotencia()
              && this.temperatura == ((Nevera) o).getTemperatura();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + this.potencia;
    hash = 79 * hash + this.temperatura;
    return hash;
  }

  @Override
  public void enfriar() {
    System.out.println("Enfriando alimentos....");
  }

}
