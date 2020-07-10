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

import org.japo.java.entities.abs.Vehiculo;
import org.japo.java.entities.parts.MotorCombustion;
import org.japo.java.entities.parts.Neumatico;
import org.japo.java.utils.UtilesVehiculo;

/**
 *
 * @author Jonsui
 */
public class Camion extends Vehiculo {

  private MotorCombustion motor;
  private Neumatico [] neumaticos;

  public Camion() {
    super();
    motor = new MotorCombustion();
    neumaticos = new Neumatico[UtilesVehiculo.DEF_RUEDASCAMION];
  }

  public Camion(MotorCombustion motor, Neumatico[] neumaticos) {
    this.motor = motor;
    this.neumaticos = neumaticos;
  }

  public Camion(MotorCombustion motor, Neumatico[] neumaticos, String marca, String modelo, int marchas, int ruedas, int numPlazas, boolean luces, String tipoVehiculo, double kmRecorridos, int revisiones, int contador) {
    super(marca, modelo, marchas, ruedas, numPlazas, luces, tipoVehiculo, kmRecorridos, revisiones, contador);
    this.motor = motor;
    this.neumaticos = neumaticos;
  }

  public MotorCombustion getMotor() {
    return motor;
  }

  public Neumatico[] getNeumaticos() {
    return neumaticos;
  }

  public void setMotor(MotorCombustion motor) {
    this.motor = motor;
  }

  public void setNeumaticos(Neumatico[] neumaticos) {
    this.neumaticos = neumaticos;
  }



  @Override
  public int obtenerNumeroRevisiones(double km) {
    int rev = (int) (km / UtilesVehiculo.MARGEN_CAMION);
    return rev;
  }

  @Override
  public void mostrarInfoRevisiones() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
