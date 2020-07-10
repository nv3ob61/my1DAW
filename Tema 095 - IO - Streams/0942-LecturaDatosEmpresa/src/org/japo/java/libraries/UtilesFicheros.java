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

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonsui
 */
public class UtilesFicheros {

  public static final String[] leerArrayFichero(String fichero) {

    // Referencia del Array 
    String[] array;

    //Lista Lineas de TEXTO
    List<String> lista = new ArrayList<>();

    //Proceso de lectura 
    try (FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr)) {
      //Referencia Linea de Texto Actual 
      String linea;

      // Bucle Recorre las lineas del fichero 
      do {
        // Lectura linea actual 
        linea = br.readLine();

        // Incorpora la linea actual 
        if (linea != null) {
          lista.add(linea);
        }
      } while (linea != null);

      //Extraccion del texto acumulado 
      array = lista.toArray(new String[lista.size()]);

    } catch (Exception e) {
      array = null;

    }
    // Devuelve la linea 
    return array;
  }
  
}
