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
package org.japo.java.entities.parts;

import java.io.Serializable;
import org.japo.java.interfaces.MotrizCombustion;
import org.japo.java.utils.UtilesPrints;

/**
 *
 * @author Jonsui
 */
public class MotorCombustion implements MotrizCombustion, Serializable {

  private static final long serialVersionUID = 459950890534720860L;

  private int rpm;
  private int potencia;

  public MotorCombustion() {
    rpm = UtilesPrints.DEF_RPM;
    potencia = UtilesPrints.DEF_POTENCIA;
  }

  public MotorCombustion(int rpm, int potencia) {
    this.rpm = rpm;
    this.potencia = potencia;
  }

  public int getRpm() {
    return rpm;
  }

  public int getPotencia() {
    return potencia;
  }

  public void setRpm(int rpm) {
    this.rpm = rpm;
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  @Override
  public void arrancar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void parar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void repostar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String toString() {
    return String.format("POTENCIA: %d caballos%n"
            + "RPM: %d%n", getPotencia(), getRpm());
  }

public void muestraInfoMotor() {
    System.out.println(toString());
  }
}
