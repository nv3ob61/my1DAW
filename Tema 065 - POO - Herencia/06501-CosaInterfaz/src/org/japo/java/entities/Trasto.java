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
import org.japo.java.interfaces.ICosa;

/**
 *
 * @author Jonsui
 */
public class Trasto extends Cosa implements ICosa, Serializable {

  private static final long serialVersionUID = -6747501394130612767L;

  public static final boolean DEF_TRASTO_OK = true;

  public Trasto() {
    fragilidadOk = DEF_TRASTO_OK;
  }

  public Trasto(boolean fragilidadOk) {
    this.fragilidadOk = fragilidadOk;
  }

  @Override
  public boolean equals(Object o) {
    boolean testOk;
    if (o == null) {
      testOk = false;
    } else if (!(o instanceof Trasto)) {
      testOk = false;
    } else {
      //Si tuviera más atributos se añadirían líneas de más concatenando
      // con && en cada línea...
      testOk = this.fragilidadOk == ((Trasto) o).isFragilidadOk();
    }
    return testOk;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    return hash;
  }

  @Override
  public String toString() {
    return String.format("%s: %s es fragil (Lo genera Trasto()).",
            getClass().getSimpleName(),
            isFragilidadOk() ? "sí" : "no");
  }
}
