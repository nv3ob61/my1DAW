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

import org.japo.java.enums.Color;
import org.japo.java.enums.Tipo;
import org.japo.java.interfaces.IAlquila;

/**
 *
 * @author Jonsui
 */
public class Coche extends Vehiculo implements IAlquila {

  private static final long serialVersionUID = 1217044327849878664L;

  private int plazas;

  public Coche() {
  }

  public Coche(int plazas) {
    this.plazas = plazas;
  }

  public Coche(int plazas, String matricula) {
    super();
    this.matricula = matricula;
    this.plazas = plazas;
  }

  public Coche(int plazas, String marca, Color color, Tipo motor, int cilindrada, int anyos) {
    super(marca, color, motor, cilindrada, anyos);
    this.plazas = plazas;
  }

  public Coche(int plazas, String marca, Color color, Tipo motor, int cilindrada, int anyos, String matricula) {
    super(marca, color, motor, cilindrada, anyos, matricula);
    this.plazas = plazas;
  }

  public int getPlazas() {
    return plazas;
  }

  public void setPlazas(int plazas) {
    this.plazas = plazas;
  }

  @Override
  public String toString() {
    return super.toString()
            + String.format("%nTIPO: %s%n", getClass().getSimpleName())
            + String.format("Nº de plazas ...: %d%n", getPlazas());
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Coche)) {
      testOk = false;
    } else {
      testOk = super.equals(o)
              && plazas == ((Coche) o).getPlazas();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 + hash + super.hashCode();
    hash = 79 * hash + this.plazas;
    return hash;
  }

  @Override
  public double precioAlquiler(int dias) {
    return Vehiculo.getPRECIO_BASE() + (1.5 * getPlazas() * dias);
  }
}
