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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Elísabet Palomino
 */
public final class UtilesEntrada {

  public static final Scanner SCN
          = new Scanner(System.in, "UTF-8")
                  .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

  // Opciones + Consola > Opcion
  public static final int obtenerOpcion(String msgUsr, String msgErr, String opc) {
    int opcion;
    boolean opcionOK = false;
    do {
      opcion = leerEntero(msgUsr, msgErr);
      if (opc.contains(opcion + "")) {
        opcionOK = true;
      } else {
        System.out.println("---");
        System.out.println(msgErr);
        System.out.println("---");
      }
    } while (!opcionOK);
    return opcion;
  }

  // Consola > Cáracter
  public static final char leerCaracter(String msgUsr, String msgErr) {
    // Dato a introducir
    char dato = 0;

    // Proceso de lectura
    boolean lecturaOK = false;
    do {
      try {
        // Entrada dato
        System.out.print(msgUsr);
        dato = SCN.nextLine().charAt(0);

        // Marca el semáforo
        lecturaOK = true;
      } catch (Exception e) {
        System.out.println(msgErr);
      }
    } while (!lecturaOK);

    // Devolver dato
    return dato;
  }

  // Pausa + MSG >> INTRO
  public static final void hacerPausa(String msgUsr) {
    System.out.println("---");
    System.out.println(msgUsr);
    hacerPausa();
  }

  // Pausa >> INTRO
  public static final void hacerPausa() {
    System.out.println("---");
    System.out.print("Pulse INTRO para continuar ...");
    SCN.nextLine();
    System.out.println("---");
  }

  // Consola >> Entero
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
        System.out.println("---");
        System.out.println(msgErr);
        System.out.println("---");
      } finally {
        SCN.nextLine();
      }
    } while (!lecturaOK);

    // Devolver dato
    return dato;
  }

  // Consola >> Real
  public static final double leerReal(String msgUsr, String msgErr) {
    // Dato a introducir
    double dato = 0;

    // Proceso de lectura
    boolean lecturaOK = false;
    do {
      try {
        // Entrada dato
        System.out.print(msgUsr);
        dato = SCN.nextDouble();

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

  // Consola >> Entero [min .. max]
  public static final int leerEntero(String msgUsr, String msgErr, int min, int max) {
    // Número a devolver
    int dato;

    // Semáforo validación
    boolean rangoOK;

    // Bucle Validación
    do {
      // Introducir Número
      dato = leerEntero(msgUsr, msgErr);

      // Validar Número
      rangoOK = dato >= min && dato <= max;

      // Mensaje de error
      if (!rangoOK) {
        System.out.println(msgErr);
      }
    } while (!rangoOK);

    // Devolver Número
    return dato;
  }

  // Consola >> Real [min .. max]
  public static final double leerReal(String msgUsr, String msgErr, double min, double max) {
    // Número a devolver
    double dato;

    // Semáforo validación
    boolean rangoOK;

    // Bucle Validación
    do {
      // Introducir Número
      dato = leerReal(msgUsr, msgErr);

      // Validar Número
      rangoOK = dato >= min && dato <= max;

      // Mensaje de error
      if (!rangoOK) {
        System.out.println(msgErr);
      }
    } while (!rangoOK);

    // Devolver Número
    return dato;
  }

  // Consola >> Texto
  public static final String leerTexto(String msgUsr) {
    System.out.print(msgUsr);
    return SCN.nextLine();
  }

  // Confirmación S/N + Defecto > Boolean
  public static final boolean confirmarProceso(String msgUsr, boolean defectoOK) {
    // Semáforo
    boolean isOk = false;
    boolean confirmacionOK = defectoOK;
    do {
      // Consola > Caracter
      String entrada = leerTexto(msgUsr);

      // Analisis Entrada
      if (entrada.length() > 0) {
        // Entrada > Caracter 1
        char c = entrada.charAt(0);
        if (UtilesValidacion.validar(Character.toString(c), UtilesMenu.OPC_MENU_SN)) {
          isOk = true;
          // Caracter [Ss | Nn] > Boolean
          confirmacionOK = "Ss".contains(c + "");
        } else {
          System.out.println("ERROR: Opción no válida.");
        }
      }
    } while (!isOk);
    // Devolución Confirmación
    return confirmacionOK;
  }
  
  
  public static final Date leerFecha(String msgUsr) {
    boolean isOk = false;
    Date fecha = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    do {
      try {
        fecha = sdf.parse(UtilesEntrada.leerTexto(msgUsr));
        isOk = true;
      } catch (ParseException parseException) {
        System.out.println("ERROR: Fecha introducida incorrecta");
      }
    } while (!isOk);
    return fecha;
  }
}
