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
package org.japo.java.app;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Random;
import org.japo.java.libraries.UtilesArrays;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final int DEF_ELEM = 5;
  public static final String ENTRADA = "Dato %d ...: ";
  public static final String MSG_ERR = "ERROR: Dato introducido inválido";
  public static final Random RND = new Random();

  public static final double PRECIO_MAX = 10.0;
  public static final double PRECIO_MIN = 0.0;

  public final void launchApp() {
    //instancia del objeto array
    double[] lista = new double[DEF_ELEM];
    DecimalFormat df = new DecimalFormat("#.##");

    //llenamos el array con valores reales y el formato de 2 decimales.
    for (int i = 0; i < lista.length; i++) {
      lista[i] = Double.valueOf(df.format(RND.nextDouble()
              * (PRECIO_MAX - PRECIO_MIN) + PRECIO_MIN));
    }
    //separador
    System.out.println("---");

    for (int i = 0; i < lista.length; i++) {
      System.out.printf("Dato %d ...: %.2f€%n",
              i + 1, lista[i]);
    }

    //separador
    System.out.println("---");

    System.out.printf("Máximo ...: %.2f – Posición: %d%n",
            UtilesArrays.obtenerMaximo(lista),
            UtilesArrays.posMaximo(lista));
    System.out.printf("Mínimo ...: %.2f – Posición: %d%n", 
            UtilesArrays.obtenerMinimo(lista),
            UtilesArrays.posMinimo(lista));
  }
}
