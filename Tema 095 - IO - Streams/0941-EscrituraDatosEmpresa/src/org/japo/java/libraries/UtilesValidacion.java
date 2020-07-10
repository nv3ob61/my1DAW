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

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Jonsui
 */
public class UtilesValidacion {

  public static final String REG_FECHA
          = "^([0]?[1-9]|[1|2][0-9]|[3][0|1])/([0]?[1-9]|[1][0-2])/([0-9]{4}|[0-9]{2})$";

  //Precio real con dos decimales.
  public static final String REG_CAPITAL = "[0-9]+([\\.,][0-9]{1,2})?"; //Real pos

  public static final String REG_DENOM = "[a-zA-ZñÑ áéíóúÁÉÍÓÚüÜ.,]{1,50}";

  // Dato + Expresión Regular
  public static final boolean validar(String dato, String er) {
    // Semáforo de validación
    boolean testOK = false;

    // Proceso de validación
    try {
      // Compila la expresión regular
      Pattern patron = Pattern.compile(er);

      // Genera el motor de búsqueda
      Matcher detector = patron.matcher(dato);

      // Averiguar Coincidencia
      testOK = detector.matches();
    } catch (PatternSyntaxException e) {
      System.out.println(e);
    }

    // Devolver Semáforo
    return testOK;
  }

  public static final boolean validaDenom(String denom) {
    return validar(denom, REG_DENOM);
  }

  public static final boolean validaFecha(String fecha) {
    return validar(fecha, REG_FECHA);
  }

  public static final boolean validaCapital(String capital) {
    return validar(capital, REG_CAPITAL);
  }
}
