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

import java.util.Locale;
import java.util.Scanner;
import org.japo.java.entities.Matricula;
import org.japo.java.enums.Color;

/**
 *
 * @author Jonsui
 */
public class UtilesEntrada {

  public static final Scanner SCN
          = new Scanner(System.in, "Windows-1252")
                  .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

  public static final String MSG_COL = "Introduzca color: ";
  public static final String MSG_MATR = "Introduzca matrícula: ";

  public static final int leerEntero(String msgUsr, String msgErr) {
    // Dato a introducir
    int dato = 0;

    // Proceso de lectura
    boolean lecturaOK = false;
    do {
      try {
        // Entrada dato
        System.out.print(msgUsr);
        dato = SCN.nextInt();

        // Marca el semáforo
        lecturaOK = true;
      } catch (Exception e) {
        System.out.println(msgErr);
      } finally {
        SCN.nextLine();
      }
    } while (!lecturaOK);

    // Devolver dato
    return dato;
  }

  // Consola >> Texto
  public static final String leerTexto(String msgUsr) {
    System.out.print(msgUsr);
    return SCN.nextLine();
  }

  public static Color validaColor(Color c) {

    //Validador del color del microbus
    do {
      c = null;
      String color = UtilesEntrada.leerTexto(MSG_COL).toLowerCase();
      switch (color) {
        case "blanco":
          c = Color.BLANCO;
          break;
        case "negro":
          c = Color.NEGRO;
          break;
        case "amarillo":
          c = Color.AMARILLO;
          break;
        case "azul":
          c = Color.AZUL;
          break;
        case "verde":
          c = Color.VERDE;
          break;
        case "rojo":
          c = Color.ROJO;
          break;
        default:
          System.out.println("ERROR: Color introducido incorrecto");
      }
    } while (c == null);

    return c;
  }

  public static final String validarMatricula() {
    //Validamos el formato de la matrícula
    String matricula;
    boolean isOk = false;
    do {
      matricula = UtilesEntrada.leerTexto(MSG_MATR);
      if (!matricula.matches(Matricula.EXP_MATRICULA)) {
        System.out.println("ERROR: Formato de matrícula incorrecto");
      } else {
        isOk = true;
      }
    } while (!isOk);
    return matricula;
  }
}
