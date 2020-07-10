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

import org.japo.java.libraries.UtilesArrays;
import org.japo.java.libraries.UtilesSorteos;

/**
 *
 * @author mon_mo
 */
public final class App {

  public final void launchApp() {
    //Generamos la apuesta aleatoria.
    int[] apuesta = UtilesSorteos.generarApuestaPrimitiva();

    //intro
    System.out.println("APUESTA DE LOTERÍA PRIMITIVA");
    System.out.println("============================");
    System.out.println();
    System.out.println("Generando apuesta ...");
    System.out.println();
    System.out.println("Apuesta NO ordenada");
    System.out.println("-------------------");

    for (int i = 0; i < apuesta.length; i++) {
      System.out.printf("Número %d ....: %d%n", i + 1, apuesta[i]);
    }

    //ordenamos la apuesta
    UtilesArrays.ordenarBurbuja(apuesta);

    //Separador y mensajes salida
    System.out.println();
    System.out.println("Ordenando la apuesta ...");
    System.out.println();
    System.out.println("Apuesta SI ordenada");
    System.out.println("-------------------");

    //Recorre de nuevo el array con los elementos ordenados.
    for (int i = 0; i < apuesta.length; i++) {
      System.out.printf("Número %d ....: %d%n", i + 1, apuesta[i]);
    }
  }
}
