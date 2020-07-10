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
import org.japo.java.libraries.UtilesFecha;
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
    //recogemos los tres datos de entrada en un String[]
    String[] datos = new String[3];
    //campos de encabezado del fichero, por ejemplo en otro String[]
    String[] encabezado = new String[3];
    //agregamos valores
    encabezado[0] = "denominación";
    encabezado[1] = "fecha de registro";
    encabezado[2] = "capital social";

    boolean fechaOk;

    System.out.println("Datos Empresa");
    System.out.println("=============");

    //entrada denom
    do {
      datos[0] = UtilesEntrada.leerTexto("Denominación .......: ");
    } while (!UtilesValidacion.validaDenom(datos[0]));

    //entrada fecha
    do {
      //semáforo de la fecha
      fechaOk = false;
      datos[1] = UtilesEntrada.leerTexto("Fecha de registro ..: ");

      if (UtilesValidacion.validaFecha(datos[1])) {
        if (UtilesFecha.validarFecha(UtilesFecha.splitFecha(datos[1]))) {
//          System.out.println("TEST: Fecha OK");
          fechaOk = true;
        } else {
          System.out.println("ERROR: Fecha incorrecta");
        }
      } else {
        System.out.println("ERROR: Fecha incorrecta");
      }
    } while (!fechaOk);

    //entrada capital
    do {
      double cap = UtilesEntrada.leerReal("Capital social .....: ",
              "ERROR: Dato introducido incorrecto");
      datos[2] = String.valueOf(cap);
    } while (!UtilesValidacion.validaCapital(datos[2]));
    datos[2] = datos[2].concat("€");

    //creo que siempre va a entrar en el if...
    if (UtilesFicheros.escribirLineaFichero(datos, encabezado, FICHERO)) {
      System.out.println("---");
      System.out.println("Registro de datos correcto");
    } else {
      System.out.println("---");
      System.out.println("ERROR: Registro de datos cancelado");
    }
    //Pausa
    UtilesEntrada.hacerPausa("Pulse INTRO para continuar ...");
  }
}