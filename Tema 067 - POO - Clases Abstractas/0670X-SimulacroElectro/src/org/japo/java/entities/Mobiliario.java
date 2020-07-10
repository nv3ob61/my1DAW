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

import java.io.Serializable;
import org.japo.java.interfaces.IMobiliario;

/**
 *
 * @author CicloM
 */
public abstract class Mobiliario implements IMobiliario, Serializable {

  private static final long serialVersionUID = -2088266422238113051L;

  public static final int ANCHO_MIN = 20;
  public static final int ANCHO_MAX = 200;

  public static final int ALTO_MIN = 20;
  public static final int ALTO_MAX = 200;

  public static final int FONDO_MIN = 20;
  public static final int FONDO_MAX = 200;

  //Valores por defecto
  public static final int DEF_ALTO = 100;
  public static final int DEF_ANCHO = 100;
  public static final int DEF_FONDO = 100;

  private int ancho;
  private int alto;
  private int fondo;

  public Mobiliario() {
    ancho = DEF_ANCHO;
    alto = DEF_ALTO;
    fondo = DEF_FONDO;
  }

  public Mobiliario(int ancho, int alto, int fondo) {
    if (validarAlto(alto)) {
      this.alto = alto;
    } else {
      this.alto = DEF_ALTO;
    }

    if (validarAncho(ancho)) {
      this.ancho = ancho;
    } else {
      this.ancho = DEF_ANCHO;
    }
    if (validarFondo(fondo)) {
      this.fondo = fondo;
    } else {
      this.fondo = DEF_FONDO;
    }
  }

  public int getAncho() {
    return ancho;
  }

  public int getAlto() {
    return alto;
  }

  public int getFondo() {
    return fondo;
  }

  public void setAncho(int ancho) {
    if (validarAncho(ancho)) {
      this.ancho = ancho;
    }
  }

  public void setAlto(int alto) {
    if (validarAlto(alto)) {
      this.alto = alto;
    }
  }

  public void setFondo(int fondo) {
    if (validarFondo(fondo)) {
      this.fondo = fondo;
    }
  }

  final boolean validarAlto(int alto) {
    return alto >= ALTO_MIN && alto <= ALTO_MAX;
  }

  final boolean validarAncho(int ancho) {
    return ancho >= ANCHO_MIN && ancho <= ANCHO_MAX;
  }

  final boolean validarFondo(int fondo) {
    return fondo >= FONDO_MIN && fondo <= FONDO_MAX;
  }

}
