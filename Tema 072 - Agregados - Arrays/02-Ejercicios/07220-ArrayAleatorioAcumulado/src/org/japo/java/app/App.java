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

import static org.japo.java.libraries.UtilesEntrada.RND;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final int DEF_ELEM = 5;

  public static final double PRECIO_MAX = 10.0;
  public static final double PRECIO_MIN = 0.0;

  public final void launchApp() {
    //instancia del objeto array
    double[] lista = new double[DEF_ELEM];
    double total = 0;

    //llenamos el array con valores reales
    for (int i = 0; i < lista.length; i++) {
      lista[i] = RND.nextDouble() * (PRECIO_MAX - PRECIO_MIN) + PRECIO_MIN;
    }

    //separador
    System.out.println("---");

    //Imprime por pantalla lo introducido
    for (int i = 0; i < lista.length; i++) {
      System.out.printf("Precio %d ...: %.2f €%n", i + 1, lista[i]);
      total += lista[i];
    } 

    //separador
    System.out.println("---");

    System.out.printf("Total ......: %.2f €%n", total);
  }
}
