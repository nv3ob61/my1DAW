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

import org.japo.java.entities.abs.Bastidor;

/**
 *
 * @author Jonsui
 */
public class Remolque extends Bastidor {

  private static final long serialVersionUID = -5242130270715918940L;

  public static final int DEF_EJES = 1;
  private static final int MMA = 4500;
  public static final int DEF_CARGA = 2000;

  private int ejes;
  private final int mma;
  private double carga;

  public Remolque() {
    ejes = DEF_EJES;
    mma = MMA;
    carga = DEF_CARGA;
  }

  public Remolque(int ejes, double carga) {
    this.ejes = ejes;
    this.mma = MMA;
    if (carga > 0 && carga <= MMA) {
      this.carga = carga;
    } else {
      this.carga = DEF_CARGA;
    }
  }

  public int getEjes() {
    return ejes;
  }

  public double getMma() {
    return mma;
  }

  public double getCarga() {
    return carga;
  }

  public void setEjes(int ejes) {
    this.ejes = ejes;
  }

  public void setCarga(double carga) {
    if (carga > 0 && carga <= MMA) {
      this.carga = carga;
    }
  }

  @Override
  public void desmontar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void montar() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void conducir() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
