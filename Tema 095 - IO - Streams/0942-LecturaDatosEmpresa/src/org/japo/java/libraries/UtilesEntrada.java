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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Jonsui
 */
public class UtilesEntrada {

  // Formatos Fecha
  public static final String FORMATO_FECHA01 = "dd/MM/yyyy";

  // Scanner + Codificación Windows
  public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

  // Locale Spanish
  public static final Locale LCL = new Locale("es", "ES");

  // Consola >> Texto
  public static final String leerTexto(String msgUsr) {
    System.out.print(msgUsr);
    return SCN.nextLine();
  }

  // Consola >> Real
  public static final double leerReal(String msgUsr, String msgErr) {
    // Dato a introducir
    double dato = 0;

    // Proceso de lectura
    boolean lecturaOK = false;
    do {
      try {
        // Entrada dato
        System.out.print(msgUsr);
        dato = SCN.nextDouble();

        // Marca el semáforo
        lecturaOK = true;
      } catch (Exception e) {
        System.out.println(msgErr);
      } finally {
        SCN.nextLine();
      }
    } while (!lecturaOK);

    // Devolver dato
    return dato;
  }

  // Consola >> Calendar
  public static final Calendar leerDatoTemporal(
          String patron, Locale locale, String msgUsr, String msgErr) {
    // Formateador
    SimpleDateFormat sdf = new SimpleDateFormat(patron, locale);

    // Referencia Calendar
    Calendar calendar = null;

    // Intro + Parse
    try {
      // Consola >> Dato (Texto)
      String texto = leerTexto(msgUsr);

      // Texto >> Date
      Date date = sdf.parse(texto);

      // Instancia Objeto Calendar
      calendar = Calendar.getInstance();

      // Date >> Calendar
      calendar.setTime(date);
    } catch (ParseException e) {
      System.out.println(msgErr);
    }

    // Devuelve Calendar
    return calendar;
  }
  // Consola >> Calendar (Locale ESP)

  public static final Calendar leerDatoTemporal(
          String patron, String msgUsr, String msgErr) {
    return leerDatoTemporal(patron, LCL, msgUsr, msgErr);
  }

  // Consola >> Fecha
  public static final Calendar leerFecha(String msgUsr, String msgErr) {
    return leerDatoTemporal(FORMATO_FECHA01, msgUsr, msgErr);
  }

  // Pausa + MSG >> INTRO
  public static final void hacerPausa(String msgUsr) {
    System.out.println("---");
    System.out.println(msgUsr);
    SCN.nextLine();
  }
}
