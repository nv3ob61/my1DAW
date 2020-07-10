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
package org.japo.java.comparators;

import java.util.Calendar;
import java.util.Comparator;
import org.japo.java.entities.Matricula;
import org.japo.java.enumerations.Criterio;

/**
 *
 * @author mon_mo
 */
public final class ComparadorMatricula implements Comparator<Matricula> {

  private Criterio orden;

  public ComparadorMatricula(Criterio orden) {
    if (orden != null) {
      this.orden = orden;
    } else {
      this.orden = Criterio.NIA;
    }
  }

  @Override
  public int compare(Matricula o1, Matricula o2) {
    // Valor de Comparación
    int comparacion;

    // Criterio Ordenacion > Comparacion
    switch (orden) {
      case NIA:
        comparacion = o1.getNia().compareTo(o2.getNia());
        break;
      case NOMBRE:
        comparacion = o1.getNombre().compareTo(o2.getNombre());
        break;
      case APELLIDOS:
        comparacion = o1.getApellidos().compareTo(o2.getApellidos());
        break;
      case LOCALIDAD:
        comparacion = o1.getLocalidad().compareTo(o2.getLocalidad());
        break;
      case FECHA_NAC:
        comparacion = comparaFechasInt(o1, o2);
        break;
      default:
        comparacion = o1.getNia().compareTo(o2.getNia());
        break;
    }

    // Devualve Comparacion
    return comparacion;
  }

  public Criterio getOrden() {
    return orden;
  }

  public void setOrden(Criterio orden) {
    if (orden != null) {
      this.orden = orden;
    }
  }

  public static int comparaFechasInt(Matricula o1, Matricula o2) {
    int comparacion = 0;
    Calendar cal1 = Calendar.getInstance();
    Calendar cal2 = Calendar.getInstance();
    cal1.setTime(o1.getFechaNac());
    cal2.setTime(o2.getFechaNac());

    if (cal1.after(cal2)) {
      comparacion = 1;
    }

    if (cal1.before(cal2)) {
      comparacion = -1;
    }

    if (cal1.equals(cal2)) {
      comparacion = 0;
    }
    return comparacion;
  }
}
