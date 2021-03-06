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
  public static final String ENTRADA = "Aforo actual ...: ";
  public static final String MSG_ERR = "ERROR: Dato introducido inválido";

  public final void launchApp() {

    int[] lista = new int[DEF_ELEM];

    for (int i = 0; i < lista.length; i++) {
      try {
        lista[i] = UtilesEntrada.leerEntero(ENTRADA, MSG_ERR);
      } catch (Exception e) {
        System.out.println("OOOOPS!");
        //Borrar buffer
        UtilesEntrada.SCN.nextLine();
      }
    }

    //Separador
    System.out.println("---");
    
    //Salida con bucle for : e
    for (int i : lista) {
      System.out.printf("Aforo actual ...: %3d personas%n", i);
    }

  }
}
