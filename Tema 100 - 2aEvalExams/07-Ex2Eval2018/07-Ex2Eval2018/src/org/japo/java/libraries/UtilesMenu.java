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

/**
 *
 * @author Jonsui
 */
public class UtilesMenu {

  public static final void mostrarMenu() {
    System.out.printf("MENÚ PRINCIPAL - ¿Qué quieres hacer?%n");
    System.out.println("-------------------");
    System.out.println("1. Alta de coche");
    System.out.println("2. Alta de microbús");
    System.out.println("3. Alta de camión");
    System.out.println("---");
    System.out.println("4. Precio alquiler vehículo");
    System.out.println("5. Precio alquiler todos los vehículos");
    System.out.println("---");
    System.out.println("6. Cambiar de color el coche");
    System.out.println("7. Alquilar un vehiculo");
    System.out.println("8. Devolver un vehiculo y mostrar factura");
    System.out.println("9. Mostrar vehiculo alquilado (por DNI)");
    System.out.println("---");
    System.out.println("0. Salir");
    System.out.println();
  }
}
