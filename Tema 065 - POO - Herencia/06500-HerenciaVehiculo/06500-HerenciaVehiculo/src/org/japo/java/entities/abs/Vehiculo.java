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
package org.japo.java.entities.abs;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
public abstract class Vehiculo extends Bastidor implements Serializable {

  private static final long serialVersionUID = 4556911317905449692L;
  
  
  public String marca;
  public String modelo;
  private int marchas;
  public int ruedas;
  public int numPlazas;
  //Boolean luces, true para encendidas y false para apagadas
  public boolean luces;

  public Vehiculo() {
  }

  public Vehiculo(String marca, String modelo, 
          int marchas, int ruedas, int numPlazas, boolean luces) {
    this.marca = marca;
    this.modelo = modelo;
    this.marchas = marchas;
    this.ruedas = ruedas;
    this.numPlazas = numPlazas;
    this.luces = luces;
  }
  
  public String getMarca() {
    return marca;
  }

  public String getModelo() {
    return modelo;
  }

  public int getNumPlazas() {
    return numPlazas;
  }
  
  public boolean isLuces() {
    return luces;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setNumPlazas(int numPlazas) {
    this.numPlazas = numPlazas;
  }

  public int getMarchas() {
    return marchas;
  }

  public int getRuedas() {
    return ruedas;
  }

  public void setMarchas(int marchas) {
    this.marchas = marchas;
  }

}
