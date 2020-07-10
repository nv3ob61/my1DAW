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

import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final int DEF_ELEM = 5;
  public static final String ENTRADA = "Nombre %d ...: ";
  public static final String MSG_ERR = "ERROR: Dato introducido inválido";

  public final void launchApp() {

    String[] lista = new String[DEF_ELEM];
    int i = 0;
    int j = 0;
    do {
      try {
        lista[i] = UtilesEntrada.leerTexto(String.format(ENTRADA, i + 1));
        i++;
      } catch (Exception e) {
      }
    } while (i < DEF_ELEM);

    //separador
    System.out.println("---");

    //Imprime por pantalla lo introducido
    do {
      System.out.printf("Nombre %d ...: %s%n", j + 1, lista[j]);
      j++;
    } while (j < DEF_ELEM);

  }
}
