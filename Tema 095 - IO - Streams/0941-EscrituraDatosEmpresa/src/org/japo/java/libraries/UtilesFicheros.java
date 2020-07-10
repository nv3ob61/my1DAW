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
package org.japo.java.libraries;

import java.io.FileWriter;

/**
 *
 * @author Jonsui
 */
public class UtilesFicheros {

  public static final boolean escribirLineaFichero(String[] array,
          String[] encabezado, String fichero) {
    boolean procesoOK = true;

    try (FileWriter fw = new FileWriter(fichero, true)) {

      //bucle para el encabezado, utiliza los elementos del array, no del encabez
      for (int i = 0; i < array.length; i++) {
        if (i == array.length - 1) {
          fw.append(encabezado[i] + System.getProperty("line.separator"));
        } else {
          fw.append(encabezado[i] + ",");
        }
      }

      //bucle para elementos
      for (int i = 0; i < array.length; i++) {
        if (i == array.length - 1) {
          //para la última línea, no añade el salto..
          fw.append(array[i]);
        } else {
          fw.append(array[i] + System.getProperty("line.separator"));
        }
      }
    } catch (Exception e) {
      procesoOK = false;
    }

    return procesoOK;
  }
}
