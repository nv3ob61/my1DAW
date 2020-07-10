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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

  public static final Scanner SCN
          = new Scanner(System.in, "Windows-1252")
                  .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

  public static final int DEF_ELEM = 5;

  public final void launchApp() {

    boolean[] lista = new boolean[DEF_ELEM];

    for (int i = 0; i < lista.length; i++) {
      try {
        System.out.printf("Estado %d ...: ", i + 1);
        lista[i] = SCN.nextBoolean();
      } catch (Exception e) {
        System.out.println("OOOOPS!");
        //Borrar buffer
        SCN.nextLine();
      }
    }
    
    //separador
    System.out.println("---");

    //Imprime por pantalla lo introducido
    for (int i = 0; i < lista.length; i++) {
      System.out.printf("Estado %d ...: %b%n", i + 1, lista[i]);
    }
  }
}
