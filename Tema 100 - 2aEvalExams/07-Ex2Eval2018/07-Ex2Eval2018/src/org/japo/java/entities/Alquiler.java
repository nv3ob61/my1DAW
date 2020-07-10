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

import java.util.Objects;

/**
 *
 * @author Jonsui
 */
public class Alquiler {

  private Conductor conductor;
  private int diasA;
  private Vehiculo vehi;

  public Alquiler() {
  }

  public Alquiler(Conductor conductor, int diasA, Vehiculo vehi) {
    this.conductor = conductor;
    this.diasA = diasA;
    this.vehi = vehi;
  }

  public Conductor getConductor() {
    return conductor;
  }

  public int getDiasA() {
    return diasA;
  }

  public Vehiculo getVehi() {
    return vehi;
  }

  public void setConductor(Conductor conductor) {
    this.conductor = conductor;
  }

  public void setDiasA(int diasA) {
    this.diasA = diasA;
  }

  public void setVehi(Vehiculo vehi) {
    this.vehi = vehi;
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Alquiler)) {
      testOk = false;
    } else {
      testOk = conductor == ((Alquiler) o).getConductor()
              && diasA == ((Alquiler) o).getDiasA()
              && vehi == ((Alquiler) o).getVehi();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 23 * hash + Objects.hashCode(this.conductor);
    hash = 23 * hash + this.diasA;
    hash = 23 * hash + Objects.hashCode(this.vehi);
    return hash;
  }

  @Override
  public String toString() {
    return String.format("INFO ALQUILER%n"
            + "-------------%n"
            + "Conductor ...: %s%n"
            + "Dias ........: %d%n"
            + "Vehículo ....: %s%n", conductor, diasA, vehi);
  }

  public void muestraInfoAlquiler(){
    System.out.println(toString());
  }
}
