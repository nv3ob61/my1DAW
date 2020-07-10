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

import java.io.File;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesFicheros;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author jonsui10
 */
public final class App {

  public static final String FICHERO = "datos.txt";
  public static final File FILE = new File(FICHERO);

  public final void launchApp() {
    String domi;
    String pobl;

    System.out.println("Datos empresa");
    System.out.println("=============");

    if (FILE.exists()) {
      String[] datos = UtilesFicheros.leerArrayFichero(FICHERO);

      //empezamos mostrando la pos[1] que es la que tiene la denom
      System.out.printf("Denominación .......: %s%n", datos[1]);

      //fecha
      System.out.printf("Fecha de registro ..: %s%n", datos[2]);

      //capital
      System.out.printf("Capital social .....: %s%n", datos[3]);

      //mensaje final
      System.out.println("---");
      System.out.println("Lectura de datos completada");
      System.out.println("---");

      System.out.println("Datos Adicionales");
      System.out.println("=================");

      //entrada domicilio
      do {
        domi = UtilesEntrada.leerTexto("Domicilio .......: ");
      } while (!UtilesValidacion.validaDomicilio(domi));

      //entrada poblacion, utiliza validaDenom
      do {
        pobl = UtilesEntrada.leerTexto("Población .......: ");
      } while (!UtilesValidacion.validaDenom(pobl));

      //if para actualizar.
      if (UtilesFicheros.escribirLineaFichero(domi, FICHERO, true)
              && UtilesFicheros.escribirLineaFichero(pobl, FICHERO, true)) {
        System.out.println("---");
        System.out.println("Actualización de datos completada.");
      }
    } else {
      System.out.println("ERROR: Actualización de datos cancelada.");
    }
    //Pausa
    UtilesEntrada.hacerPausa("Pulse INTRO para continuar ...");
  }
}
