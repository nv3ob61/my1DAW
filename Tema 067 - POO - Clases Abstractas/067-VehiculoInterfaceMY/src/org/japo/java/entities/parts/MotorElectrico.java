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
import org.japo.java.interfaces.MotrizElectrico;
import org.japo.java.utils.UtilesVehiculo;

/**
 *
 * @author Jonsui
 */
public class MotorElectrico implements MotrizElectrico, Serializable {

  private static final long serialVersionUID = -1488765814710636231L;

  private int alimentacion;  // debería ser 220V o 380V
  private int potencia;      // kW, W o lo que sea, pero int
  private int consumo;       // Amperios
  private int rpm;           // no hace falta descripción...

  public MotorElectrico() {
    rpm = UtilesVehiculo.DEF_MAXRPMELEC;
    alimentacion = UtilesVehiculo.DEF_ALIMENTAELEC;
    potencia = UtilesVehiculo.DEF_POTENCIAELEC;
    consumo = UtilesVehiculo.DEF_CONSUMOELEC;
  }

  public MotorElectrico(int alimentacion, int potencia, int consumo, int rpm) {
    if (alimentacion == UtilesVehiculo.DEF_ALIMENTACIONTIPO1
            || alimentacion == UtilesVehiculo.DEF_ALIMENTACIONTIPO2) {
      this.alimentacion = alimentacion;
    } else {
      this.alimentacion = UtilesVehiculo.DEF_ALIMENTAELEC;
    }
    this.potencia = potencia;
    this.consumo = consumo;
    if (rpm <= UtilesVehiculo.DEF_MAXRPM) {
      this.rpm = rpm;
    } else {
      this.rpm = UtilesVehiculo.DEF_RPM;
    }
  }

  public int getAlimentacion() {
    return alimentacion;
  }

  public int getPotencia() {
    return potencia;
  }

  public int getConsumo() {
    return consumo;
  }

  public int getRpm() {
    return rpm;
  }

  public void setAlimentacion(int alimentacion) {
    if (alimentacion == UtilesVehiculo.DEF_ALIMENTACIONTIPO1
            || alimentacion == UtilesVehiculo.DEF_ALIMENTACIONTIPO2) {
      this.alimentacion = alimentacion;
    }
  }

  public void setPotencia(int potencia) {
    this.potencia = potencia;
  }

  public void setConsumo(int consumo) {
    this.consumo = consumo;
  }

  public void setRpm(int rpm) {
    if (rpm <= UtilesVehiculo.DEF_MAXRPM) {
      this.rpm = rpm;
    }
  }

  @Override
  public void conectar() {
    System.out.println(UtilesVehiculo.DEF_CONECTAR);
  }

  @Override
  public void desconectar() {
    System.out.println(UtilesVehiculo.DEF_DESCONECTAR);
  }

}
