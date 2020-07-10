/*
 * Copyright (C) 2020 jonsui10
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

import org.japo.java.interfaces.INeumatico;
import org.japo.java.utils.UtilesPrints;

/**
 *
 * @author jonsui10
 */
public class Neumatico implements INeumatico {

  private double presion;
  private String color;
  private int diametro;
  private String tipoNeumatico;
  private String estadoNeumatico;

  public Neumatico() {
    presion = UtilesPrints.DEF_PRESION;
    color = UtilesPrints.DEF_COLOR;
    diametro = UtilesPrints.DEF_DIAMETRO;
    tipoNeumatico = UtilesPrints.DEF_TIPONEUM;
    estadoNeumatico = UtilesPrints.DEF_ESTADONEUM;
  }

  public Neumatico(double presion, String color, int diametro,
          String tipoNeumatico, String estadoNeumatico) {
    this.presion = presion;
    this.color = color;
    this.diametro = diametro;
    this.tipoNeumatico = tipoNeumatico;
    this.estadoNeumatico = estadoNeumatico;
  }

  public double getPresion() {
    return presion;
  }

  public String getColor() {
    return color;
  }

  public int getDiametro() {
    return diametro;
  }

  public String getTipoNeumatico() {
    return tipoNeumatico;
  }

  public String getEstadoNeumatico() {
    return estadoNeumatico;
  }

  public void setPresion(double presion) {
    this.presion = presion;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setDiametro(int diametro) {
    this.diametro = diametro;
  }

  public void setTipoNeumatico(String tipoNeumatico) {
    this.tipoNeumatico = tipoNeumatico;
  }

  public void setEstadoNeumatico(String estadoNeumatico) {
    this.estadoNeumatico = estadoNeumatico;
  }

  @Override
  public void inflar(double k) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void desinflar(double k) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void cambiarNeumatico() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
