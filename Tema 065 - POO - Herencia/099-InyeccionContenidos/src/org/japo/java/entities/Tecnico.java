/*
 * Copyright (C) 2020 CicloM
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

import org.japo.java.interfaces.ITitulacion;

/**
 *
 * @author CicloM
 */
public class Tecnico {

  private ITitulacion titulacion;

  public Tecnico() {
    titulacion = null;
  }

  public Tecnico(ITitulacion titulacion) {
    this.titulacion = titulacion;
  }

  public ITitulacion getTitulacion() {
    return titulacion;
  }

  public void setTitulacion(ITitulacion titulacion) {
    this.titulacion = titulacion;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int hashCode() {
    int hash = 5;
    return hash;
  }

  @Override
  public String toString() {
    return String.format("%s", getClass().getSimpleName());
  }

  public final void ejercerProfesion() {
    if (titulacion == null) {
      System.out.println("Soy técnico");
    } else {
      titulacion.ejercerProfesion();
    }
  }

}
