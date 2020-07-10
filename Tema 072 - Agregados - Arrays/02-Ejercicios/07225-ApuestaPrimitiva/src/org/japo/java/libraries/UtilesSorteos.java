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

import java.util.Random;

/**
 *
 * @author Jonsui
 */
public class UtilesSorteos {

  // Referencias
  public static final int LONGITUD_BOMBO_PRIMITIVA = 49;
  public static final int LONGITUD_APUESTA_PRIMITIVA = 6;

  // Sistema de Números Aleatorios
  public static final Random RND = new Random();

  // Bombo Loteria Primitiva + Array
  public static final int[] generarBomboPrimitiva() {
    // Definir bombo
    int[] bombo = new int[LONGITUD_BOMBO_PRIMITIVA];

    // Llenar bombo - Primer Número: 1
    for (int i = 0; i < bombo.length; i++) {
      bombo[i] = i + 1;
    }

    // Devolver Bombo
    return bombo;
  }
  
  
    // Apuesta Aleatoria Loteria Primitiva + Array
    public static final int[] generarApuestaPrimitiva() {
        // Definir Apuesta
        int[] apuesta = new int[LONGITUD_APUESTA_PRIMITIVA];

        // Definir bombo
        int[] bombo = generarBomboPrimitiva();

        // Generar apuesta
        for (int i = 0; i < apuesta.length; i++) {
            // Extrae la posición actual
            int posicion = RND.nextInt(LONGITUD_BOMBO_PRIMITIVA - i);

            // Extrae la bola de la posición actual
            apuesta[i] = bombo[posicion];

            // Rellena el hueco
            bombo[posicion] = bombo[LONGITUD_BOMBO_PRIMITIVA - i - 1];
        }

        // Devolver Apuesta
        return apuesta;
    }
    
    
}
