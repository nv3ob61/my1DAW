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
public class Camion extends Vehiculo implements IAlquila {

  private static final long serialVersionUID = -4272527937025524464L;

  private int pma;
  private int numRuedas;

  public Camion() {
  }

  public Camion(int pma, int numRuedas) {
    this.pma = pma;
    this.numRuedas = numRuedas;
  }

//Creamos constructor a base del pma, ruedas y matrícula
  public Camion(int pma, int numRuedas, String matricula) {
    super();
    this.pma = pma;
    this.numRuedas = numRuedas;
  }

  public Camion(int pma, int numRuedas, String marca, Color color, Tipo motor, int cilindrada, int anyos) {
    super(marca, color, motor, cilindrada, anyos);
    this.pma = pma;
    this.numRuedas = numRuedas;
  }

  public Camion(int pma, int numRuedas, String marca, Color color, Tipo motor, int cilindrada, int anyos, String matricula) {
    super(marca, color, motor, cilindrada, anyos, matricula);
    this.pma = pma;
    this.numRuedas = numRuedas;
  }

  public int getPma() {
    return pma;
  }

  public int getNumRuedas() {
    return numRuedas;
  }

  public void setPma(int pma) {
    this.pma = pma;
  }

  public void setNumRuedas(int numRuedas) {
    this.numRuedas = numRuedas;
  }

  @Override
  public void muestraVehiculo() {
    super.muestraVehiculo();
    System.out.printf("TIPO: %s%n"
            + "PMA: %d kg.%n"
            + "Núm ruedas ..: %d%n", getClass().getSimpleName(), pma, numRuedas);
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Camion)) {
      testOk = false;
    } else {
      testOk = super.equals(o)
              && pma == ((Camion) o).getPma()
              && numRuedas == ((Camion) o).getNumRuedas();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + super.hashCode();
    hash = 67 * hash + this.pma;
    hash = 67 * hash + this.numRuedas;
    return hash;
  }

  @Override
  public double precioAlquiler(int dias) {
    return (Vehiculo.getPRECIO_BASE() + (20 * pma * dias) + 40) / 1000;
  }

}
