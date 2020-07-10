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

import org.japo.java.interfaces.IHorno;

/**
 *
 * @author CicloM
 */
public class Horno extends Electro implements IHorno {

  private static final long serialVersionUID = -8195616856298728124L;

  public static final int DEF_POTENCIA = 1200;
  public static final int DEF_TEMPMAX = 280;
  public static final int DEF_TEMP = 0;

  private int potencia;
  private int temperatura;

  public Horno() {
    potencia = DEF_POTENCIA;
    temperatura = DEF_TEMP;
  }

  public Horno(int potencia, int temperatura) {
    if (potencia <= DEF_POTENCIA) {
      this.potencia = potencia;
    } else {
      this.potencia = DEF_POTENCIA;
    }
    if (temperatura <= DEF_TEMPMAX) {
      this.temperatura = temperatura;
    } else {
      this.temperatura = DEF_TEMP;
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
    if (temperatura <= DEF_TEMPMAX) {
      this.temperatura = temperatura;
    }
  }

  @Override
  public final boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Horno)) {
      testOk = false;
    } else {
      testOk = this.potencia == ((Horno) o).getPotencia()
              && this.temperatura == ((Horno) o).getTemperatura();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + this.potencia;
    hash = 89 * hash + this.temperatura;
    return hash;
  }

  @Override
  public void calentar() {
    System.out.println("Calentando alimentos....");
  }
}
