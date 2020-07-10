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
public class MicroBus extends Vehiculo implements IAlquila {

  private static final long serialVersionUID = -2998827510127062066L;
  public static final int DEF_PLAZAS = 14;
  public static final int DEF_METROS = 20;
  
  private int plazas;
  private int metros;

  public MicroBus() {
    plazas = DEF_PLAZAS;
    metros = DEF_METROS;
  }

  public MicroBus(int plazas, int metros) {
    this.plazas = plazas;
    this.metros = metros;
  }

  //Constructor añadiendo matrícula...
  public MicroBus(int plazas, String matricula) {
    super();
    this.plazas = plazas;
  }
  
  public MicroBus(int plazas, int metros, String marca, Color color, Tipo motor, int cilindrada, int anyos) {
    super(marca, color, motor, cilindrada, anyos);
    this.plazas = plazas;
    this.metros = metros;
  }

  public MicroBus(int plazas, int metros, String marca, Color color, Tipo motor, int cilindrada, int anyos, String matricula) {
    super(marca, color, motor, cilindrada, anyos, matricula);
    this.plazas = plazas;
    this.metros = metros;
  }

  public int getPlazas() {
    return plazas;
  }

  public int getMetros() {
    return metros;
  }

  public void setPlazas(int plazas) {
    this.plazas = plazas;
  }

  public void setMetros(int metros) {
    this.metros = metros;
  }

  @Override
  public void muestraVehiculo() {
    super.muestraVehiculo();
    System.out.printf("TIPO: %s%n"
            + "Plazas: %d plazas%n"
            + "Metros ..: %d m.%n", getClass().getSimpleName(), plazas, metros);
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof MicroBus)) {
      testOk = false;
    } else {
      testOk = super.equals(o)
              && plazas == ((MicroBus) o).getPlazas()
              && metros == ((MicroBus) o).getMetros();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + super.hashCode();
    hash = 41 * hash + this.plazas;
    hash = 41 * hash + this.metros;
    return hash;
  }

  @Override
  public double precioAlquiler(int dias) {
    return Vehiculo.getPRECIO_BASE() + (1.5 * getPlazas() * dias) + (2 * getPlazas());
  }
}
