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
  //Constantes
  final char LETRA_INI = 'A';
  final char LETRA_FIN = 'Z';

  public final void launchApp() {

    char[] lista = new char[DEF_ELEM];

    //llenamos el array con valores primitivos char
    for (int i = 0; i < lista.length; i++) {
      lista[i] = (char) (RND.nextInt(LETRA_FIN - LETRA_INI + 1) + LETRA_INI);
    }

    //separador
    System.out.println("---");

    //Imprime por pantalla lo introducido
    for (int i = 0; i < lista.length; i++) {
      System.out.printf("Símbolo %d ...: %c%n", i + 1, lista[i]);
    }
  }
}
